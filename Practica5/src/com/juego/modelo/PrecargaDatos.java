package com.juego.modelo;
import com.juego.clases.*;

// Importamos todos los tipos de raza que puede ser un personaje
import com.juego.razas.Elfo;
import com.juego.razas.Humano;
import com.juego.razas.Enano;

// Importamos todos los tipos de clase que puede ser un personaje
import com.juego.razas.ModificadoresRazas;

import java.util.ArrayList;

public class PrecargaDatos {

    // Crear Lista para almacenar los personajes
    public static ArrayList<Personaje> personajes = new ArrayList<>();
    // Crear personajes por defecto 1 y 2 con stats por defecto 0 en el Constructor
    public PrecargaDatos() {
        // Precargar razas
        ModificadoresRazas elfo = new Elfo();
        ModificadoresRazas enano = new Enano();
        ModificadoresRazas humano = new Humano();
        // Precargar clases
        StatsClases guerrero = new Guerrero();
        StatsClases bardo = new Bardo();
        StatsClases druida = new Druida();
        StatsClases mago = new Mago();
        StatsClases monje = new Monje();
        StatsClases paladin = new Paladin();
        StatsClases picaro = new Picaro();
        StatsClases sacerdote = new Sacerdote();

        // Precargar personajes
        Personaje pj1 = new Personaje("personaje1", elfo, sacerdote);     // Se crea pj1 y le indicamos que la raza será Elfo (Falta añadir clase, modificar despues)
        Personaje pj2 = new Personaje("personaje2", humano, paladin);  // Se crea pj2 y le indicamos que la raza será Humano
        // Añadir los personajes precargados a la lista de personajes
        personajes.add(pj1);
        personajes.add(pj2);
        // Añadir las stats de la raza al pj
        pj1.actualizarStatsSegunRaza();
        pj2.actualizarStatsSegunRaza();
        // Actualizar las stats del personaje a los valores de la raza + los valores de la clase
        pj1.anadirStatsClase();
        pj2.anadirStatsClase();
        // Añadir habilidades al personaje
        pj1.agregarHabilidad();
        pj2.agregarHabilidad();
    }
}