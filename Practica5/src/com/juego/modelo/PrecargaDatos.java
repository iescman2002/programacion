package com.juego.modelo;

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
    }
}