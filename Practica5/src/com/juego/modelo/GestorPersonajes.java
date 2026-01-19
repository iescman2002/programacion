package com.juego.modelo;

import com.juego.razas.Elfo;
import com.juego.razas.Enano;
import com.juego.razas.Humano;
import com.juego.razas.ModificadoresRazas;

import java.util.Scanner;

public class GestorPersonajes {

    public GestorPersonajes() {
        menuCrearPersonaje();
    }

    // Metodo para el menu de crear personaje
    public void menuCrearPersonaje() {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca el nombre del personaje: ");
        String nombre = s.next();
        System.out.print("Introduzca a continuación la raza: (humano, elfo, enano)");
        String raza = s.next();
        System.out.print("Introduzca a continuación la clase: (bardo, druida, guerrero, mago, monje, paladin, picaro, sacerdote)");
        String clase = s.next();
    }
}