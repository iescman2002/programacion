package rpg.dao;

import rpg.model.Clase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClaseDAO extends ConexionBaseDatos {
    private List<Clase> clases;

    public ClaseDAO() throws SQLException {
        this.clases = new ArrayList<>();
        precargaClases();
    }

    public List<Clase> getClases() {
        return this.clases;
    }
    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    private void precargaClases() throws SQLException {
        this.resultSet = statement.executeQuery("SELECT * FROM RAZAS"); // Hacemos una consulta de TODAS las columnas de la tabla Items.

        while(resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");

            this.clases.add(new Clase(id,nombre));
        }
    }
}
