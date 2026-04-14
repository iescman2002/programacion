import rpg.dao.*;

import rpg.exception.FondosInsuficientesException;
import rpg.model.*;
import rpg.ui.Menus;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, FondosInsuficientesException {

        Menus menu = new Menus();
        menu.cargarMenuPrincipal();
        /* PROBAR QUE CARGAN BIEN LOS ITEMS
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
        System.out.println("---------------------------------------------------------");
        PersonajeDAO personajeDAO = new PersonajeDAO();
        for (Personaje personaje : personajeDAO.getPersonajes()) {
            System.out.println(personaje.toString());
        }
        System.out.println("---------------------------------------------------------");
        InventarioDAO inventarioDAO = new InventarioDAO();
        for (Inventario inventario : inventarioDAO.getInventarios()) {
            System.out.println(inventario.toString());
        }
        System.out.println("---------------------------------------------------------");
        Personajes_HabilidadesDAO personajesHabilidadesDAO = new Personajes_HabilidadesDAO();
        for (Personajes_Habilidades personaje_habilidades : personajesHabilidadesDAO.getPersonajes_habilidades()) {
            System.out.println(personaje_habilidades.toString());
        }
         */
    }
}