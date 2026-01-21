package com.juego.modelo;

// Importamos todos los tipos de raza que puede ser un personaje
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
        // Añadir los personajes precargados a la lista de personajes
        gp.anadirPersonaje(pj1);
        gp.anadirPersonaje(pj2);
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