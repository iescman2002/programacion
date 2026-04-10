package rpg.dao;

import rpg.model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO extends ConexionBaseDatos{
    private List<Item> items;
    public ItemDAO() throws SQLException {
        this.items = new ArrayList<>();
        precargarItems();
    }

    private void precargarItems() throws SQLException {
        this.resultSet = statement.executeQuery("SELECT * FROM ITEMS"); // Hacemos una consulta de TODAS las columnas de la tabla Items.

        while (resultSet.next()) { // Mientras haya otra fila:
            // Guarda los datos de la base de datos en las variables
            Integer id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String tipo = resultSet.getString("tipo");
            Integer precio_oro = resultSet.getInt("precio_oro");
            Integer bonificador_ataque = resultSet.getInt("bonificador_ataque");
            Integer bonificador_defensa = resultSet.getInt("bonificador_defensa");
            items.add(new Item(id, nombre, tipo, precio_oro, bonificador_ataque, bonificador_defensa)); // Y crea un personaje que añade a la lista que contiene la información de las bases de datos.
        }
    }

    public List<Item> getItems() {
        return this.items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
