import rpg.dao.ItemDAO;
import rpg.model.Item;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        ItemDAO itemDAO = new ItemDAO();
        for (Item item : itemDAO.getItems()) {
            System.out.println(item.toString());
        }
    }
}