package com.juego.modelo;

import com.juego.clases.*;
import com.juego.habilidades.Habilidades;
import com.juego.presentacion.Presentador;
import com.juego.razas.*;

import java.util.ArrayList;

public class GestorPersonajes {

    // Atributos estaticos para que se puedan usar para todo el programa sin tener que crearlos siempre. Por ejemplo si no se crearan estatic cada vez que creara un nuevo GestorPersonajes se crearia un nuevo arraylist de personajes vacio
    public static ArrayList<Personaje> personajes = new ArrayList<>();

    // Metodo para el menu de crear personaje
    public void menuCrearPersonaje() {
        System.out.print("Introduzca el nombre del personaje: ");
        String nombre = PrecargaDatos.s.next();
        System.out.print("Introduzca a continuación la raza: (humano, elfo, enano): ");
        String raza = PrecargaDatos.s.next();
        System.out.print("Introduzca a continuación la clase: (bardo, druida, guerrero, mago, monje, paladin, picaro, sacerdote): ");
        String clase = PrecargaDatos.s.next();

        Personaje pj3 = new Personaje(nombre,seleccionarRaza(raza),seleccionarClase(clase)); // Crea personaje con los valores que introduzca el usuario
        personajes.add(pj3); // Añade pj3 a la lista de personajes en precarga de datos.
        pj3.actualizarStatsSegunRaza(); // Añadir las stats de la raza al pj
        pj3.anadirStatsClase(); // Actualizar las stats del personaje a los valores de la raza + los valores de la clase
        pj3.agregarHabilidad(); // Añadir las habilidades al personaje
        for (Habilidades habilidad: pj3.getHabilidades()) { // Actualiza las estadisticas de las habilidades segun la fuerza del personaje
            habilidad.actualizarDanioHabilidad(pj3); //
        }

        finCrearPersonaje(); // Volver al menu principal
    }
    // Metodo para volver al menu principal una vez terminado la creación de personaje.
    public void finCrearPersonaje() {
        System.out.print("Su personaje ha sido creado con exito. Volviendo al menú principal...\n");
        new Presentador();
    }
    // Metodo unico para agregar la raza al crear el personaje nuevo
    private ModificadoresRazas seleccionarRaza(String raza) {
        switch (raza) {
            case "elfo":
                return new Elfo();
            case "enano":
                return new Enano();
            case "humano":
                return new Humano();
        default:
            return null;
        }
    }
    // Metodo unico para agregar la clase al crear el personaje nuevo
    private StatsClases seleccionarClase(String clase) {
        switch (clase){
            case "bardo":
                return new Bardo();
            case "druida":
                return new Druida();
            case "guerrero":
                return new Guerrero();
            case "mago":
                return new Mago();
            case "monje":
                return new Monje();
            case "paladin":
                return new Paladin();
            case "picaro":
                return new Picaro();
            case "sacerdote":
                return new Sacerdote();
            default:
                return null;
        }
    }
    // Metodo para ver los personajes creados en la lista
    public void mostrarPersonajes() {
        int contador= 1;
        for (Personaje personaje : personajes) {
            System.out.println("╠═════════════════════════════════════╣");
            System.out.println("║ "+contador+". "+personaje.toString());
            contador++;
        }
    }

    public void anadirPersonaje(Personaje pj){
        personajes.add(pj);
    }

    // Metodo para escoger personaje 1 y personaje 2 (Se devuelve como array de 2 personajes) para poder devolver 2 datos diferentes en una sola ejecucion
    public Personaje[] elegirPersonajes(){
        // Crear array local y fijo para guardar los personajes que volvemos
        Personaje[] personajes_pelean = new Personaje[2]; // Limitamos el tamaño a 2
        // Para escoger personaje1
        System.out.print("╔═════════════════════════════════════╗\n");
        System.out.print("║  Jugador 1, escoja su personaje:    ║\n");
        mostrarPersonajes();
        System.out.println("╠═════════════════════════════════════╗");
        System.out.print("║  Inserte aquí su opción: ");
        int opcion1 = PrecargaDatos.s.nextInt();
        System.out.print("╚═════════════════════════════════════╝\n");
        for (int i=0;i < personajes.size();i++) {
            if (i+1==opcion1) {
                personajes_pelean[0] = personajes.get(i); // Guardo en la posicion 0 el personaje elegido por jugador1
            }
        }
        // Para escoger personaje 2
        System.out.print("╔═════════════════════════════════════╗\n");
        System.out.print("║  Jugador 2, escoja su personaje:    ║\n");
        mostrarPersonajes();
        System.out.println("╠═════════════════════════════════════╗");
        System.out.print("║  Inserte aquí su opción: ");
        int opcion2 = PrecargaDatos.s.nextInt();
        System.out.print("╚═════════════════════════════════════╝\n");
        for (int i=0;i < personajes.size();i++) {
            if (i+1==opcion2) {
                personajes_pelean[1] = personajes.get(i); // Guardo en la posicion 0 el personaje elegido por jugador2
            }
        }
        System.out.println("╔═══════════════════════╗");
        System.out.println("║ ¡Comienza el combate! ║");
        System.out.println("║ Combate entre:        ║");
        System.out.println("║ "+personajes_pelean[0].getNombre()+" y "+personajes_pelean[1].getNombre());
        return personajes_pelean; // Devuelvo el array
    }
}