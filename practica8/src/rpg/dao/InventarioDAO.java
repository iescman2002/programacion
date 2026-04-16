package rpg.dao;

import rpg.exception.DatoInvalidoException;
import rpg.model.Inventario;
import rpg.utils.Logger;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO extends ConexionBaseDatos {

    private List<Inventario> inventarios;
    private Logger logger;
    public InventarioDAO() throws DatoInvalidoException {
        this.inventarios = new ArrayList<>();
        this.logger = new Logger();
        precargarInventarios();
    }

    public List<Inventario> getInventarios() {
        return this.inventarios;
    }
    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    private void precargarInventarios() throws DatoInvalidoException {
        try{
            this.resultSet = statement.executeQuery("SELECT * FROM INVENTARIOS");

            while (resultSet.next()) {
                Integer id_personaje = resultSet.getInt("id_personaje");
                Integer id_item = resultSet.getInt("id_item");
                Integer cantidad = resultSet.getInt("cantidad");

                inventarios.add(new Inventario(id_personaje,id_item,cantidad));
            }
        } catch (SQLException e) {
            logger.escribirLog("["+ LocalDateTime.now() +"] ERROR: No se pudieron cargar los inventarios: " + e.getMessage());
        }
    }
}
