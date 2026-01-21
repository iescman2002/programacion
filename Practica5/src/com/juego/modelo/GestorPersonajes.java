package com.juego.modelo;

import com.juego.clases.*;
import com.juego.presentacion.Presentador;
import com.juego.razas.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorPersonajes {


    // Crear Lista para almacenar los personajes
    public ArrayList<Personaje> personajes = new ArrayList<>();
    // Atributos de GestorPersonaje
    private Scanner s; // Creo un atributo de tipo scanner llamado s para no tener que crearlo en menuCrearPersonaje todo el rato

    // Constructor de GestorPersonajes
    public GestorPersonajes() {
        this.s = new Scanner(System.in); // Constuctor atributo del scanner
    }

    // Metodo para el menu de crear personaje
    public void menuCrearPersonaje() {
        System.out.print("Introduzca el nombre del personaje: ");
        String nombre = s.next();
        System.out.print("Introduzca a continuación la raza: (humano, elfo, enano): ");
        String raza = s.next();
        System.out.print("Introduzca a continuación la clase: (bardo, druida, guerrero, mago, monje, paladin, picaro, sacerdote): ");
        String clase = s.next();

        Personaje pj3 = new Personaje(nombre,seleccionarRaza(raza),seleccionarClase(clase)); // Crea personaje con los valores que introduzca el usuario
        personajes.add(pj3); // Añade pj3 a la lista de personajes en precarga de datos.
        pj3.actualizarStatsSegunRaza(); // Añadir las stats de la raza al pj
        pj3.anadirStatsClase(); // Actualizar las stats del personaje a los valores de la raza + los valores de la clase
        pj3.agregarHabilidad(); // Añadir las habilidades al personaje

        finCrearPersonaje(); // Volver al menu principal
    }
    // Metodo para volver al menu principal una vez terminado la creación de personaje.
    public void finCrearPersonaje() {
        System.out.print("Su personaje ha sido creado con exito. Volviendo al menú principal...\n");
        Presentador p = new Presentador();
        p.inicio();
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

    }

    public void anadirPersonaje(Personaje pj){
        this.personajes.add(pj);
    }
}