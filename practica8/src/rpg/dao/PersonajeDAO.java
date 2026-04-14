package rpg.dao;

import rpg.exception.NivelInsuficienteException;
import rpg.model.*;
import rpg.ui.Menus;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonajeDAO extends ConexionBaseDatos {

    private List<Personaje> personajes;

    public PersonajeDAO() throws SQLException {
        this.personajes = new ArrayList<>();
        precargaPersonajes();
    }

    public List<Personaje> getPersonajes() {
        return this.personajes;
    }
    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    private void precargaPersonajes() throws SQLException {

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
    }

    public void crearPersonaje(String nombre,Integer id_raza, Integer id_clase) throws SQLException {
        RazaDAO razaDAO = new RazaDAO();
        Integer vida = 100; // La vida por defecto sera 100 + el bonificador de la vida que tenga la raza que ha seleccionado.
        for (Raza raza : razaDAO.getRazas()) {
            if(raza.getId().equals(id_raza)) {
                vida += raza.getBonificado_vida();
                break;
            }
        }
        Personaje personaje = new Personaje(null,nombre,1,100,vida,id_raza,id_clase,1);
        this.personajes.add(personaje);

        // Insertar en la base de datos el personaje creado:
        insertarPersonaje(personaje);
        // Actualizar personajes_habilidades con las habilidades correspondientes del nuevo personaje creado:
        Personajes_HabilidadesDAO personajesHabilidadesDAO = new Personajes_HabilidadesDAO();
        personajesHabilidadesDAO.actualizarPersonajeHabilidades(personaje);
        // Elegir las habilidades que quiere tener el personaje
        new Menus().menuElegirHabilidades(personaje);
    }

    private void insertarPersonaje(Personaje personaje) throws SQLException {
        String sql = "INSERT INTO PERSONAJES (nombre, nivel, oro, vida_actual, id_raza, id_clase, id_ciudad_actual) VALUES(?,?,?,?,?,?,?) RETURNING ID";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setString(1,personaje.getNombre());
        preparedStatement.setInt(2,personaje.getNivel());
        preparedStatement.setInt(3,personaje.getOro());
        preparedStatement.setInt(4,personaje.getVida_actual());
        preparedStatement.setInt(5,personaje.getId_raza());
        preparedStatement.setInt(6,personaje.getId_clase());
        preparedStatement.setInt(7,personaje.getId_ciudad_actual());

        this.resultSet = preparedStatement.executeQuery();

        // Una vez insertamos el personaje se generará automaticamente el serial (id), entonces tendremos que cambiar el null del objeto personaje creado por el serial creado:
        // Actualizamos el id del personaje de null a la generada:
        if (resultSet.next()) {
            personaje.setId(resultSet.getInt("id"));
        }
    }

    public Boolean verificarNivelCiudad(Personaje personaje, Ciudad ciudad) throws NivelInsuficienteException {
        if (personaje.getNivel() >= ciudad.getNivel_minimo_acceso()) {
            return true;
        }
        else {
            throw new NivelInsuficienteException("Nivel insuficiente para acceder a la ciudad");
        }
    }

    public void actualizarCiudad(Personaje personaje, Ciudad ciudad) throws SQLException {
        String sql = "UPDATE PERSONAJES SET ID_CIUDAD_ACTUAL=? WHERE ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,ciudad.getId());
        preparedStatement.setInt(2,personaje.getId());

        int rowsAffected = preparedStatement.executeUpdate();
    }

    public Boolean verificarCompraItem(Personaje personaje, Item item)  {
        // Devuelve true si el personaje tiene oro suficiente para comprar el item y false si no
        return personaje.getOro()>=item.getPrecio_oro();
    }

    public void comprarItem(Personaje personaje, Item item) {
        // Primero le resto el precio del item al personaje

        // Despues inserto el personaje y el item comprado en inventario
    }
}
