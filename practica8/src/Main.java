import rpg.dao.CiudadDAO;
import rpg.dao.ItemDAO;
import rpg.model.Ciudad;
import rpg.model.Item;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        ItemDAO itemDAO = new ItemDAO();
        for (Item item : itemDAO.getItems()) {
            System.out.println(item.toString());
        }
        System.out.println("---------------------------------------------------------");
        CiudadDAO ciudadDAO = new CiudadDAO();
        for (Ciudad ciudad : ciudadDAO.getCiudades()) {
            System.out.println(ciudad.toString());
        }
    }
}