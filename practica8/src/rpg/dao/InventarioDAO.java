package rpg.dao;

import rpg.model.Inventario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO extends ConexionBaseDatos {

    private List<Inventario> inventarios;

    public InventarioDAO() throws SQLException {
        this.inventarios = new ArrayList<>();
        precargarInventarios();
    }

    public List<Inventario> getInventarios() {
        return this.inventarios;
    }
    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    private void precargarInventarios() throws SQLException {

        this.resultSet = statement.executeQuery("SELECT * FROM INVENTARIOS");

        while (resultSet.next()) {
            Integer id_personaje = resultSet.getInt("id_personaje");
            Integer id_item = resultSet.getInt("id_item");
            Integer cantidad = resultSet.getInt("cantidad");

            inventarios.add(new Inventario(id_personaje,id_item,cantidad));
        }
    }
}
