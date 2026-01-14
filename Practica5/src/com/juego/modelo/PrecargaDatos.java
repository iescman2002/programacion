package com.juego.modelo;

// Importamos todos los tipos de raza que puede ser un personaje
import com.juego.razas.Elfo;
import com.juego.razas.Humano;
import com.juego.razas.Enano;

// Importamos todos los tipos de clase que puede ser un personaje
import com.juego.clases.Bardo;
import com.juego.clases.Druida;
import com.juego.clases.Guerrero;
import com.juego.clases.Mago;
import com.juego.clases.Monje;
import com.juego.clases.Paladin;
import com.juego.clases.Picaro;
import com.juego.clases.Sacerdote;

import java.util.ArrayList;

public class PrecargaDatos {

    // Crear Lista para almacenar los personajes
    public static ArrayList<Personaje> personajes = new ArrayList<>();

    // Crear personajes por defecto 1 y 2 con stats por defecto 0 en el Constructor
    public PrecargaDatos() {
        Personaje pj1 = new Personaje("personaje1",new Elfo(),new Sacerdote());     // Se crea pj1 y le indicamos que la raza será Elfo (Falta añadir clase, modificar despues)
        Personaje pj2 = new Personaje("personaje2", new Humano(),new Paladin());  // Se crea pj2 y le indicamos que la raza será Humano
        // Añadir los personajes precargados a la lista de personajes
        personajes.add(pj1);
        personajes.add(pj2);
        // Añadir las stats de la raza al pj
        pj1.actualizarStatsSegunRaza();
        pj2.actualizarStatsSegunRaza();
        // Actualizar las stats del personaje a los valores de la raza + los valores de la clase
        pj1.AnadirStatsClase();
        pj2.AnadirStatsClase();
    }
    public static void main (String[] args ) {
        PrecargaDatos p = new PrecargaDatos();
        System.out.println(personajes.get(0).toString());
        System.out.print(personajes.get(1).toString());

    }
}