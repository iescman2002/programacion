package rpg.dao;

import rpg.model.Personajes_Habilidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personajes_HabilidadesDAO extends ConexionBaseDatos {
    private List<Personajes_Habilidades> personajes_habilidades;

    public Personajes_HabilidadesDAO() throws SQLException {
        this.personajes_habilidades = new ArrayList<>();
        precargarPersonajes_Habilidades();
    }

    public List<Personajes_Habilidades> getPersonajes_habilidades() {
        return this.personajes_habilidades;
    }
    public void setPersonajes_habilidades(List<Personajes_Habilidades> personajes_habilidades) {
        this.personajes_habilidades = personajes_habilidades;
    }

    private void precargarPersonajes_Habilidades() throws SQLException {
        this.resultSet = statement.executeQuery("SELECT * FROM PERSONAJES_HABILIDADES");

        while (resultSet.next()) {
            Integer id_personaje = resultSet.getInt("id_personaje");
            Integer id_habilidad = resultSet.getInt("id_habilidad");
            Boolean equipada_combate = resultSet.getBoolean("equipada_combate");

            personajes_habilidades.add(new Personajes_Habilidades(id_personaje,id_habilidad,equipada_combate));
        }
    }
}
