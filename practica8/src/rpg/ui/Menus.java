package rpg.ui;

import rpg.dao.*;
import rpg.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menus {

    Scanner s = new Scanner(System.in);
    public Menus() throws SQLException {

    }

    public void cargarMenuPrincipal() throws SQLException {
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
                MenucrearPersonaje();
                break;
            default:
                System.out.print("Saliendo...");
                break;
        }
    }

    private void MenucrearPersonaje() throws SQLException {
        System.out.println("Ha seleccionado crear personaje.");
        System.out.print("Indique el nombre del personaje: ");
        String nombre = s.nextLine();
        System.out.println("De las siguientes razas:");

        RazaDAO razas = new RazaDAO();
        for (Raza raza : razas.getRazas()) {
            System.out.println(raza.getId()+". Raza "+raza.getNombre()+", Bonificador de vida: "+raza.getBonificado_vida()+", Bonificador de fuerza: "+raza.getBonificado_fuerza());
        }
        System.out.println("Seleccione la que quiera que tenga el personaje: ");
        int id_raza = s.nextInt();

        ClaseDAO clases = new ClaseDAO();
        System.out.println("Y de las siguientes clases:");
        for (Clase clase : clases.getClases()) {
            System.out.println(clase.getId()+". Clase "+clase.getNombre());
        }
        System.out.print("Seleccione la que quiera que tenga el personaje: ");
        int id_clase =  s.nextInt();

        new PersonajeDAO().crearPersonaje(nombre,id_raza,id_clase);
    }
    public void MenuElegirHabilidades(Personaje personaje) throws SQLException {
        // Elegir las habilidades que quiere tener el personaje
        System.out.println("Su personaje ha sido creado con exito, eliga a continuación las habilidades que quiere que tenga el personaje: ");
        // Mostrar las habilidades del personaje
        Personajes_HabilidadesDAO personajesHabilidadesDAO = new Personajes_HabilidadesDAO();
        List<Personajes_Habilidades> personajes_habilidades= personajesHabilidadesDAO.getPersonajes_habilidades();

        HabilidadDAO habilidadDAO = new HabilidadDAO();
        List<Habilidad> habilidades = habilidadDAO.getHabilidades();

        HashMap<Integer, Integer> ids_habilidades_posibles = new HashMap<>(); // La clave sera el contador y el valor el id de la habilidad

        Boolean elegirHabilidad = true;
        while(elegirHabilidad) {
            Integer contador = 1;
            for (Personajes_Habilidades personaje_habilidades : personajes_habilidades) { // Recorro las filas de la tabla personajes_habilidades (porque cada personajes_habilidades es lo mismo que una fila)
                if (personaje.getId().equals(personaje_habilidades.getId_personaje())) { // Si el id del personaje que le pasamos es igual al id de personajes_habilidad
                    // Muestro las habilidades correspondientes al id del personaje
                    for (Habilidad habilidad : habilidades) {
                        if (personaje_habilidades.getId_habilidad().equals(habilidad.getId())) {
                            System.out.println(contador + ". Habilidad: " + habilidad.getNombre() + ". Daño: " + habilidad.getDanio_base() + ". Usos maximos: " + habilidad.getUsos_maximos());
                            contador++;
                            ids_habilidades_posibles.put(contador, personaje_habilidades.getId_habilidad());
                        }
                    }
                }
            }
            System.out.print("Seleccione la que quiera que tenga el personaje o seleccione cualquier otro numero si desea salir: ");
            Integer opcion_escogida = s.nextInt();
            // Si la opcion_escogida esta dentro del hashmap
            if (ids_habilidades_posibles.containsKey(opcion_escogida)) {
                // pone como true la columna equipada_combate de personajes_habilidades
                personajesHabilidadesDAO.equiparHabilidad(personaje.getId(),ids_habilidades_posibles.get(opcion_escogida)); // Le pasamos el id del personaje y el id de la habilidad que estamos equipando (que sera el valor de la clave de la opcion que escogio el usuario)
            }
            // Sino esta dentro del hashmap, significa que el usuario no quiere tener mas habilidades asi que sale del bucle de escoger habilidades
            else {
                elegirHabilidad = false;
            }
        }
    }
}