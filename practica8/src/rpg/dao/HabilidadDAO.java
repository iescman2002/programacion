package rpg.dao;

import rpg.model.Habilidad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDAO extends ConexionBaseDatos {
    private List<Habilidad> habilidades;

    public HabilidadDAO() throws SQLException {
        this.habilidades = new ArrayList<>();

        precargaHabilidades();
    }

    public List<Habilidad> getHabilidades() {
        return this.habilidades;
    }
    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    private void precargaHabilidades() throws SQLException {
        this.resultSet = statement.executeQuery("SELECT * FROM HABILIDADES");

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            Integer danio_base = resultSet.getInt("dano_base");
            Integer usos_maximos = resultSet.getInt("usos_maximos");
            Integer id_clase = resultSet.getInt("id_clase");

            habilidades.add(new Habilidad(id,nombre,danio_base,usos_maximos,id_clase));
        }
    }
}
