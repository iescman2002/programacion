import rpg.dao.*;

import rpg.model.*;

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
        System.out.println("---------------------------------------------------------");
        RazaDAO razaDAO = new RazaDAO();
        for (Raza raza : razaDAO.getRazas()) {
            System.out.println(raza.toString());
        }
        System.out.println("---------------------------------------------------------");
        ClaseDAO claseDAO = new ClaseDAO();
        for (Clase clase : claseDAO.getClases()) {
            System.out.println(clase.toString());
        }
        System.out.println("---------------------------------------------------------");
        HabilidadDAO habilidadDAO = new HabilidadDAO();
        for (Habilidad habilidad : habilidadDAO.getHabilidades()) {
            System.out.println(habilidad.toString());
        }
    }
}