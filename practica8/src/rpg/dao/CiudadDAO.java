package rpg.dao;

import rpg.model.Ciudad;
import rpg.model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO extends ConexionBaseDatos {
    private List<Ciudad> ciudades;

    public CiudadDAO() throws SQLException {
        this.ciudades = new ArrayList<>();
        precargarCiudades();
    }

    private void precargarCiudades() throws SQLException {
        this.resultSet = statement.executeQuery("SELECT * FROM CIUDADES"); // Hacemos una consulta de TODAS las columnas de la tabla Items.

        while(resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            Integer nivel_minimo_acceso = resultSet.getInt("nivel_minimo_acceso");

            ciudades.add(new Ciudad(id, nombre, nivel_minimo_acceso)); // Y crea un personaje que añade a la lista que contiene la información de las bases de datos.
        }
    }

    public List<Ciudad> getCiudades() {
        return this.ciudades;
    }
    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
