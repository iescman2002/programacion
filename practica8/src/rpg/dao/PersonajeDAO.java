package rpg.dao;

import rpg.model.Personaje;

import java.sql.SQLException;
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
}
