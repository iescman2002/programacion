package rpg.dao;

import rpg.exception.DatoInvalidoException;
import rpg.exception.LimiteHabilidadesException;
import rpg.exception.NivelInsuficienteException;
import rpg.exception.RecursoNoEncontradoException;
import rpg.model.*;
import rpg.ui.Menus;
import rpg.utils.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonajeDAO extends ConexionBaseDatos {

    private List<Personaje> personajes;
    private Logger logger;
    public PersonajeDAO() throws DatoInvalidoException {
        this.personajes = new ArrayList<>();
        this.logger = new Logger();
        precargaPersonajes();
    }

    public List<Personaje> getPersonajes() {
        return this.personajes;
    }
    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    private void precargaPersonajes() throws DatoInvalidoException {
        try {
            this.resultSet = statement.executeQuery("SELECT * FROM PERSONAJES");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                Integer nivel = resultSet.getInt("nivel");
                Integer oro = resultSet.getInt("oro");
                Integer vida_actual = resultSet.getInt("vida_actual");
                Integer id_raza = resultSet.getInt("id_raza");
                Integer id_clase = resultSet.getInt("id_clase");
                Integer id_ciudad_actual = resultSet.getInt("id_ciudad_actual");

                personajes.add(new Personaje(id,nombre,nivel,oro,vida_actual,id_raza,id_clase,id_ciudad_actual));
            }
        } catch (SQLException e) {
            logger.escribirLog("["+ LocalDateTime.now() +"] ERROR: No se pudieron cargar los personajes: " + e.getMessage());
        }
    }

    public void crearPersonaje(String nombre,Integer id_raza, Integer id_clase) throws DatoInvalidoException, LimiteHabilidadesException {
        RazaDAO razaDAO = new RazaDAO();
        Integer vida = 100; // La vida por defecto sera 100 + el bonificador de la vida que tenga la raza que ha seleccionado.
        for (Raza raza : razaDAO.getRazas()) {
            if (raza.getId().equals(id_raza)) {
                vida += raza.getBonificado_vida();
                break;
            }
        }
        Personaje personaje = new Personaje(null, nombre, 1, 100, vida, id_raza, id_clase, 1);
        this.personajes.add(personaje);

        // Insertar en la base de datos el personaje creado:
        insertarPersonaje(personaje);
        // Actualizar personajes_habilidades con las habilidades correspondientes del nuevo personaje creado:
        Personajes_HabilidadesDAO personajesHabilidadesDAO = new Personajes_HabilidadesDAO();
        personajesHabilidadesDAO.actualizarPersonajeHabilidades(personaje);
        // Elegir las habilidades que quiere tener el personaje
        new Menus().menuElegirHabilidades(personaje, null);
        System.out.println("Su personaje ha sido creado con exito.");
    }

    private void insertarPersonaje(Personaje personaje) throws DatoInvalidoException {
        try {
            String sql = "INSERT INTO PERSONAJES (nombre, nivel, oro, vida_actual, id_raza, id_clase, id_ciudad_actual) VALUES(?,?,?,?,?,?,?) RETURNING ID";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

            preparedStatement.setString(1, personaje.getNombre());
            preparedStatement.setInt(2, personaje.getNivel());
            preparedStatement.setInt(3, personaje.getOro());
            preparedStatement.setInt(4, personaje.getVida_actual());
            preparedStatement.setInt(5, personaje.getId_raza());
            preparedStatement.setInt(6, personaje.getId_clase());
            preparedStatement.setInt(7, personaje.getId_ciudad_actual());

            this.resultSet = preparedStatement.executeQuery();

            // Una vez insertamos el personaje se generará automaticamente el serial (id), entonces tendremos que cambiar el null del objeto personaje creado por el serial creado:
            // Actualizamos el id del personaje de null a la generada:
            if (resultSet.next()) {
                personaje.setId(resultSet.getInt("id"));
            }
            logger.escribirLog("[" + LocalDateTime.now() + "] INFO: Personaje " + personaje.getId() + ". " + personaje.getNombre() + " creado con exito.");
        } catch (SQLException e) {
            logger.escribirLog("["+ LocalDateTime.now()+"] ERROR: No se pudo insertar el personaje: " + e.getMessage());
        }
    }

    public Boolean verificarNivelCiudad(Personaje personaje, Ciudad ciudad) throws NivelInsuficienteException, DatoInvalidoException {
        if (personaje.getNivel() >= ciudad.getNivel_minimo_acceso()) {
            return true;
        }
        else {
            logger.escribirLog("["+ LocalDateTime.now()+"] ERROR: Personaje "+personaje.getId()+". "+personaje.getNombre()+" no tiene nivel suficiente par accede a la ciudad."+" Nivel del jugador: "+personaje.getNivel()+". Nivel de acceso a la ciudad: "+ciudad.getNivel_minimo_acceso());
            throw new NivelInsuficienteException("Nivel insuficiente para acceder a la ciudad");
        }
    }

    public void actualizarCiudad(Personaje personaje, Ciudad ciudad) throws DatoInvalidoException {
        try {
            String sql = "UPDATE PERSONAJES SET ID_CIUDAD_ACTUAL=? WHERE ID=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ciudad.getId());
            preparedStatement.setInt(2, personaje.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            logger.escribirLog("[" + LocalDateTime.now() + "] INFO: Personaje " + personaje.getId() + ": " + personaje.getNombre() + ". Ciudad actualizada a: " + ciudad.getId());
        } catch (SQLException e) {
            logger.escribirLog("["+ LocalDateTime.now() +"] ERROR: No se pudo actualizar la ciudad del personaje "+personaje.getId()+" - "+e.getMessage());
        }
    }

    public Boolean verificarCompraItem(Personaje personaje, Item item)  {
        // Devuelve true si el personaje tiene oro suficiente para comprar el item y false si no
        return personaje.getOro()>=item.getPrecio_oro();
    }

    public void comprarItem(Personaje personaje, Item item) throws DatoInvalidoException {
        // Primero le resto el precio del item al personaje
       try {
           Integer oroTrasCompra = personaje.getOro() - item.getPrecio_oro();

           personaje.setOro(oroTrasCompra);

           // Actualizo en la base de datos el nuevo oro del personaje:
           String sql = "UPDATE PERSONAJES SET ORO=? WHERE ID=?";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);

           preparedStatement.setInt(1, personaje.getOro());
           preparedStatement.setInt(2, personaje.getId());

           int rowsAffected = preparedStatement.executeUpdate();
           // Despues inserto el personaje y el item comprado en inventario
           InventarioDAO inventarioDAO = new InventarioDAO();
           List<Inventario> inventarios = inventarioDAO.getInventarios();
           // Busco si el id_personaje con el id_idem ya está en el inventario (si el personaje tiene ya este item)
           Boolean registradoAnteriormente = false;
           Inventario inventario_donde_se_encuentra = null;
           for (Inventario inventario : inventarios) {
               // Si id_personaje y id_item estan en la lista (==true), actualizo la cantidad de estos a la actual +1
               if ((inventario.getId_personaje().equals(personaje.getId()) && (inventario.getId_item().equals(item.getId())))) {
                   inventario_donde_se_encuentra = inventario;
                   registradoAnteriormente = true;
                   inventario.setCantidad(inventario.getCantidad() + 1); // Le sumo 1 a la cantidad del personaje
                   break;
               }
           }
           // Actualizar la cantidad del item del personaje en la tabla Inventarios de la BD
           if (registradoAnteriormente) {
               sql = "UPDATE INVENTARIOS SET CANTIDAD =? WHERE ID_PERSONAJE=? AND ID_ITEM=?";
               preparedStatement = connection.prepareStatement(sql); // actualizar la query sql

               preparedStatement.setInt(1, inventario_donde_se_encuentra.getCantidad());
               preparedStatement.setInt(2, personaje.getId());
               preparedStatement.setInt(3, item.getId());
               rowsAffected = preparedStatement.executeUpdate();
           }
           // Si id_personaje y id_item no estan en la lista (!=true), inserto un nuevo inventario con el id_personaje, id_item y cantidad en 1
           // Insertar el nuevo item del personaje en la tabla Inventarios de la BD
           else {
               sql = "INSERT INTO INVENTARIOS(ID_PERSONAJE,ID_ITEM,CANTIDAD) VALUES (?,?,?)";
               preparedStatement = connection.prepareStatement(sql); // actualizar la query sql

               preparedStatement.setInt(1, personaje.getId());
               preparedStatement.setInt(2, item.getId());
               preparedStatement.setInt(3, 1);

               rowsAffected = preparedStatement.executeUpdate();
           }
           logger.escribirLog("[" + LocalDateTime.now() + "] INFO: El personaje " + personaje.getId() + " ha comprado el item " + item.getId() + ". ");
       } catch (SQLException e) {
           logger.escribirLog("["+ LocalDateTime.now() +"] ERROR: No se pudo comprar el item "+item.getId()+" para el personaje "+personaje.getId()+" - "+e.getMessage());
       }
    }

    public void desterrarPersonaje(Personaje personaje) throws DatoInvalidoException {
        try {
            String sql = "UPDATE PERSONAJES SET ID_CIUDAD_ACTUAL=? WHERE ID=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNull(1, Types.INTEGER); // Establecemos el parametro 1 (id_ciudad_actual) como null especificando el tipo de dato de la base de datos con Types (INTEGER)
            preparedStatement.setInt(2, personaje.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            logger.escribirLog("[" + LocalDateTime.now() + "] ERROR: Personaje " + personaje.getId() + " Desterrado. Su ciudad se ha establecido a null porque su oro tras los impuestos es: " + personaje.getOro() + ".");
        } catch (SQLException e) {
            logger.escribirLog("[" + LocalDateTime.now() + "] ERROR: No se pudo desterrar al personaje "+ personaje.getId() + " - " + e.getMessage());
        }
    }

    public void actualizarOroPersonaje(Personaje personaje) throws DatoInvalidoException {
        try {
            String sql = "UPDATE PERSONAJES SET ORO=? WHERE ID=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // Actualizamos solo el oro del jugador porque es el unico valor que cambiamos (-20)
            // No actualizamos la columna id_ciudad_actual porque la actualizamos ya cuando la desterramos
            preparedStatement.setInt(1,personaje.getOro());
            preparedStatement.setInt(2,personaje.getId());

            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.escribirLog("[" + LocalDateTime.now() + "] ERROR: No se pudo actualizar el oro del personaje "+ personaje.getId() + " - " + e.getMessage());

        }
    }
}
