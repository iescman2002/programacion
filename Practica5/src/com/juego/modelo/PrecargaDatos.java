package com.juego.modelo;

// Importamos todos los tipos de raza que puede ser un personaje
import com.juego.habilidades.Habilidades;
import com.juego.razas.*;

// Importamos todos los tipos de clase que puede ser un personaje
import com.juego.clases.*;

import java.util.Scanner;


public class PrecargaDatos {

    public static Scanner s = new Scanner (System.in); // Se precarga el Scanner como static para poder usarlo posteriormente en el resto de clases sin crearlo de nuevo
    // Crear personajes por defecto 1 y 2 con stats por defecto 0 en el Constructor
    public PrecargaDatos() {
        // Crear GestorPersonajes
        GestorPersonajes gp = new GestorPersonajes();
        // Precargar personajes
        Personaje pj1 = new Personaje("Gladiador", new Humano(), new Guerrero());     // Se crea pj1 y le indicamos su raza y clase
        Personaje pj2 = new Personaje("Señor Malfoi", new Elfo(), new Mago());  // Se crea pj2 y le indicamos su raza y clase
        Personaje pj3 = new Personaje("Funko Cantarin",new Enano(),new Bardo());
        Personaje pj4 = new Personaje("Buda de los Alpes",new Humano(),new Monje());
        Personaje pj5 = new Personaje("Hippie del bosque",new Humano(),new Druida());
        Personaje pj6 = new Personaje("Justiciero de la espada",new Humano(),new Paladin());
        Personaje pj7 = new Personaje("Cura chikitin",new Enano(),new Sacerdote());
        Personaje pj8 = new Personaje("Carterista",new Elfo(),new Picaro());
        // Añadir los personajes precargados a la lista de personajes
        gp.anadirPersonaje(pj1);
        gp.anadirPersonaje(pj2);
        gp.anadirPersonaje(pj3);
        gp.anadirPersonaje(pj4);
        gp.anadirPersonaje(pj5);
        gp.anadirPersonaje(pj6);
        gp.anadirPersonaje(pj7);
        gp.anadirPersonaje(pj8);
        // Añadir las stats de la raza al pj
        pj1.actualizarStatsSegunRaza();
        pj2.actualizarStatsSegunRaza();
        pj3.actualizarStatsSegunRaza();
        pj4.actualizarStatsSegunRaza();
        pj5.actualizarStatsSegunRaza();
        pj6.actualizarStatsSegunRaza();
        pj7.actualizarStatsSegunRaza();
        pj8.actualizarStatsSegunRaza();
        // Actualizar las stats del personaje a los valores de la raza + los valores de la clase
        pj1.anadirStatsClase();
        pj2.anadirStatsClase();
        pj3.anadirStatsClase();
        pj4.anadirStatsClase();
        pj5.anadirStatsClase();
        pj6.anadirStatsClase();
        pj7.anadirStatsClase();
        pj8.anadirStatsClase();
        // Añadir habilidades al personaje
        pj1.agregarHabilidad();
        pj2.agregarHabilidad();
        pj3.agregarHabilidad();
        pj4.agregarHabilidad();
        pj5.agregarHabilidad();
        pj6.agregarHabilidad();
        pj7.agregarHabilidad();
        pj8.agregarHabilidad();
        // Actualizar daño e inteligencia de las habilidades
        for (Personaje personaje : GestorPersonajes.personajes) { // Recorre todos los personajes del array
            for (Habilidades habilidad : personaje.getHabilidades()) { // Recorre todas las habilidades de cada personaje
                habilidad.actualizarDanioHabilidad(personaje); // Actualiza las stats de cada habilidad de cada personaje
            }
        }
    }
}