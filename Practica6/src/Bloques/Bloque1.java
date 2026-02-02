package Bloques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bloque1 {
    // Registro de Muertes
    public ArrayList<String> registroDeMuertes() {
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
        // Devolver registroCombate para poder usarlo en el ejercicio4.
        return registroCombate;
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
    // Limpieza del Calabozo
    public void limpiezaDelCalabozo() {
        // Usar el array list de la lista 1
        ArrayList<String> lista = registroDeMuertes();
        // Eliminar el evento más antiguo (posicion 0)
        lista.removeFirst();
        // Añadir nuevo evento al final
        lista.add("Dragón avistado");
        // Mostrar el arraylist actualizado
        System.out.println("Bloque 1 Ejercicio 4:");
        for (String eventos : lista) {
            System.out.println(eventos);
        }
    }
    // Mercado de Hechizos
    public void mercadodeHechizos() {
        // Crear HashMap para hechizos y coste
        HashMap<String, Double> hechizos = new HashMap<>();
        // Rellenar HashMap con algunos claves y valor
        hechizos.put("Bola de fuego", 250.21);
        hechizos.put("Rayo helado", 12.75);
        hechizos.put("Tormenta eléctrica", 320.50);
        hechizos.put("Explosión arcana", 32.15);
        hechizos.put("Llamas infernales", 275.90);
        hechizos.put("Viento cortante", 20.33);
        // Imprimir los hechizos que cuestan mas de 50 de mana
        System.out.println("Bloque 1 Ejercicio 5:");
        for (String hechizo : hechizos.keySet()) {
            if (hechizos.get(hechizo)>50) {
                System.out.println("Hechizo: "+hechizo+" Cuesta: "+ hechizos.get(hechizo));
            }
        }
    }
}
