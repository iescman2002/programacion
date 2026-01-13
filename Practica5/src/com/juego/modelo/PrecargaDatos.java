package com.juego.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrecargaDatos {

    // Crear Lista para almacenar los personajes
    public static ArrayList<Personaje> personajes = new ArrayList<>();

    // Crear personajes por defecto 1 y 2 con stats por defecto 0 en el Constructor
    public PrecargaDatos() {
        Personaje pj1 = new Personaje("personaje1", 0, 0, 0, 0, 0);
        Personaje pj2 = new Personaje("personaje2", 0, 0, 0, 0, 0);

        // Añadir los personajes precargados a la lista de personajes
        personajes.add(pj1);
        personajes.add(pj2);
    }
    /* Seleccionar la raza y la clase de los personajes
    pj1.addRaza();
    pj1.addClase();
    pj2.addRaza();
    pj2.addClase();
    */
}