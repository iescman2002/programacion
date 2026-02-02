package Bloques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bloque1 {
    // Registro de Muertes
    public void registroDeMuertes() {
        // Crear arraylist
        ArrayList<String> registroCombate = new ArrayList<>();
        // Añadir eventos al array
        registroCombate.add("Orco derrotado.");
        registroCombate.add("Poción usada.");
        registroCombate.add("Jugador eliminado.");
        registroCombate.add("Habilidad usada.");
        registroCombate.add("Curar jugador.");
        // Mostrar el 3er evento
        System.out.println("Bloque 1 Ejercicio1: "+registroCombate.get(2));
    }
    // El Censo Único
    public void censoUnico() {
        // Crear HashSet de nombres de villano
        HashSet<String> Villano = new HashSet<>();
        // Intentar añadir 2 veces Morgoth
        Villano.add("Morgoth");
        Villano.add("Morgoth");
        // Imprimir el tamaño del Set
        System.out.println("Bloque 1 Ejercicio2: "+Villano);
    }
    // Bolsa de Oro
    public void bolsaDeOro() {
        // Crear HashMap
        HashMap<String, Integer> Aventureros = new HashMap<>();
        // Añadir 3 heroes
        Aventureros.put("Juan",654);
        Aventureros.put("Maria",421);
        Aventureros.put("Jorge",533);
        // Mostrar el oro (valor) de cualquiera usando el nombre (clave)
        System.out.println("Bloque 1 Ejercicio3: "+Aventureros.get("Maria"));
    }
}
