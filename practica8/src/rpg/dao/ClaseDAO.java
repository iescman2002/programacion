package rpg.dao;

import rpg.exception.DatoInvalidoException;
import rpg.model.Clase;
import rpg.utils.Logger;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClaseDAO extends ConexionBaseDatos {
    private List<Clase> clases;
    Logger logger;
    public ClaseDAO() throws DatoInvalidoException {
        this.clases = new ArrayList<>();
        this.logger = new Logger();
        precargaClases();
    }

    public List<Clase> getClases() {
        return this.clases;
    }
    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    private void precargaClases() throws DatoInvalidoException {
        try{
            this.resultSet = statement.executeQuery("SELECT * FROM CLASES_RPG"); // Hacemos una consulta de TODAS las columnas de la tabla Clases.
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                this.clases.add(new Clase(id,nombre));
            }
        } catch (SQLException e) {
            logger.escribirLog("["+ LocalDateTime.now() +"] ERROR: No se pudieron cargar las clases: " + e.getMessage());
        }
    }
}
