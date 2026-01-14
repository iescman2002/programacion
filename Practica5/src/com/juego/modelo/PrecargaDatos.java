package com.juego.modelo;

// Importamos todos los tipos de raza que puede ser un personaje
import com.juego.razas.Elfo;
import com.juego.razas.Humano;
import com.juego.razas.Enano;

import java.util.ArrayList;

public class PrecargaDatos {

    // Crear Lista para almacenar los personajes
    public static ArrayList<Personaje> personajes = new ArrayList<>();

    // Crear personajes por defecto 1 y 2 con stats por defecto 0 en el Constructor
    public PrecargaDatos() {
        Personaje pj1 = new Personaje("personaje1",new Elfo());     // Se crea pj1 y le indicamos que la raza será Elfo (Falta añadir clase, modificar despues)
        Personaje pj2 = new Personaje("personaje2", new Humano());  // Se crea pj2 y le indicamos que la raza será Humano
        // Añadir los personajes precargados a la lista de personajes
        personajes.add(pj1);
        personajes.add(pj2);
        // Añadir las stats de la raza al pj
        pj1.actualizarStatsSegunRaza();
        pj1.actualizarStatsSegunRaza();
    }
    public static void main (String[] args ) {
        PrecargaDatos p = new PrecargaDatos();
        System.out.println(personajes.get(0).toString());
        System.out.print(personajes.get(1).toString());

    }
}