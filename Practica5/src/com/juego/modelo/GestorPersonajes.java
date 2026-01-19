package com.juego.modelo;

import com.juego.clases.*;
import com.juego.razas.Elfo;
import com.juego.razas.Enano;
import com.juego.razas.Humano;
import com.juego.razas.ModificadoresRazas;

import java.util.Scanner;

import static com.juego.modelo.PrecargaDatos.personajes;

public class GestorPersonajes {

    public GestorPersonajes() {
        menuCrearPersonaje();
    }

    // Metodo para el menu de crear personaje
    public void menuCrearPersonaje() {
        Scanner s = new Scanner(System.in);
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
}