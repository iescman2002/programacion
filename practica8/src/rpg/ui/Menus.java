package rpg.ui;

import rpg.dao.ClaseDAO;
import rpg.dao.PersonajeDAO;
import rpg.dao.RazaDAO;
import rpg.model.Clase;
import rpg.model.Personaje;
import rpg.model.Raza;

import java.sql.SQLException;
import java.util.Scanner;

public class Menus {

    Scanner s = new Scanner(System.in);
    public Menus() throws SQLException {
        cargarMenuPrincipal();
    }

    private void cargarMenuPrincipal() throws SQLException {
        System.out.println("¡Bienvenido al XPG Guild Master!");
        System.out.println("A continuación, indique que opción deseas acceder:");
        System.out.println("1. Crear personaje.");
        System.out.println("2. [SOON].");
        System.out.println("3. [SOON].");
        System.out.println("--------------------------------");

        int opcion = s.nextInt();
        s.nextLine(); // Para limpiar la entrada de texto anterior que sino provoca fallos despues
        switch (opcion) {
            case 1:
                crearPersonaje();
                break;
            default:
                System.out.print("Saliendo...");
                break;
        }
    }

    private void crearPersonaje() throws SQLException {
        System.out.println("Ha seleccionado crear personaje.");
        System.out.print("Indique el nombre del personaje: ");
        String nombre = s.nextLine();
        System.out.println("De las siguientes razas:");
        RazaDAO razas = new RazaDAO();
        ClaseDAO clases = new ClaseDAO();

        for (Raza raza : razas.getRazas()) {
            System.out.println(raza.getId()+". Raza "+raza.getNombre()+", Bonificador de vida: "+raza.getBonificado_vida()+", Bonificador de fuerza: "+raza.getBonificado_fuerza());
        }
        System.out.println("Seleccione la que quiera que tenga el personaje: ");
        int raza = s.nextInt();
        System.out.println("Y de las siguientes clases:");
        for (Clase clase : clases.getClases()) {
            System.out.println(clase.getId()+". Clase "+clase.getNombre());
        }
        System.out.print("Seleccione la que quiera que tenga el personaje: ");
        int clase =  s.nextInt();

        Integer id_personaje = 0; // Pongo primero el id del personaje que voy a crear en 0
        PersonajeDAO personajes = new PersonajeDAO();
        for (Personaje personaje : personajes.getPersonajes()) { // Recorro todos los personajes para actualizar el id del personaje cada vez que haya uno
            id_personaje = personaje.getId(); // cuando no hayan más personajes detras el id_personaje será el id del último personaje introducido (que es lo que buscamos)
        }
        // Ahora le sumo 1 al id_personaje (que tiene el id del último personaje introducido) para que asi tenga de valor el id que le corresponderia
        id_personaje++;

        PersonajeDAO personajeDAO = new PersonajeDAO();
        //personajeDAO.getPersonajes().add(new Personaje(id_personaje,nombre,1,100,));
    }
}