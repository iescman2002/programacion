package rpg.dao;

import rpg.model.Personaje;
import rpg.model.Raza;
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
        // Obtener id del personaje:
        Integer id_personaje = 0; // Pongo primero el id del personaje que voy a crear en 0
        for (Personaje personaje : this.personajes) { // Recorro todos los personajes para actualizar el id del personaje cada vez que haya uno
            id_personaje = personaje.getId(); // cuando no hayan más personajes detras el id_personaje será el id del último personaje introducido (que es lo que buscamos)
        }
        // Ahora le sumo 1 al id_personaje (que tiene el id del último personaje introducido) para que asi tenga de valor el id que le corresponderia
        id_personaje++;

        // El personaje lo creamos con el idCiudad 1 por defecto porque es al único al que podrá acceder con su nivel.
        RazaDAO razaDAO = new RazaDAO();
        Integer vida = 100; // La vida por defecto sera 100 + el bonificador de la vida que tenga la raza que ha seleccionado.
        for (Raza raza : razaDAO.getRazas()) {
            vida += raza.getBonificado_vida();
        }
        Personaje personaje = new Personaje(id_personaje,nombre,1,100,vida,id_raza,id_clase,1);
        this.personajes.add(personaje);

        // Insertar en la base de datos el personaje creado:
        insertarPersonaje(personaje);
        // Actualizar personajes_habilidades con las habilidades correspondientes del nuevo personaje creado:
        Personajes_HabilidadesDAO personajesHabilidadesDAO = new Personajes_HabilidadesDAO();
        personajesHabilidadesDAO.actualizarPersonajeHabilidades(personaje);
        // Elegir las habilidades que quiere tener el personaje
        new Menus().MenuElegirHabilidades(personaje);
    }

    private void insertarPersonaje(Personaje personaje) throws SQLException {
        String sql = "INSERT INTO PERSONAJES (id, nombre, nivel, oro, vida_actual, id_raza, id_clase, id_ciudad_actual) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setInt(1,personaje.getId());
        preparedStatement.setString(2,personaje.getNombre());
        preparedStatement.setInt(3,personaje.getNivel());
        preparedStatement.setInt(4,personaje.getOro());
        preparedStatement.setInt(5,personaje.getVida_actual());
        preparedStatement.setInt(6,personaje.getId_raza());
        preparedStatement.setInt(7,personaje.getId_clase());
        preparedStatement.setInt(8,personaje.getId_ciudad_actual());

        int rowsAffected = preparedStatement.executeUpdate();
    }
}
