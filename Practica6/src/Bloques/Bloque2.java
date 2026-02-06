package Bloques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bloque2 {
    // El Repositorio de Gremios (Ejercicio 7)
    public void repositorioDeGremios() {
       // Crear Hashmap donde la clave es el nombre del gremio y el valor el sus miembros
        HashMap<String, ArrayList<String>> RepositorioDeGremios = new HashMap<>();
        //Crear miembros del gremio1
        ArrayList<String> miembrosGremio1 = new ArrayList<>();
        miembrosGremio1.add("Juan");
        miembrosGremio1.add("Manuel");
        miembrosGremio1.add("Claudia");
        // Agregar al repositorio de gremios el gremio 1 (clave) y sus miembros (valor)
        RepositorioDeGremios.put("Magos", miembrosGremio1);
        //Crear miembros del gremio2
        ArrayList<String> miembrosGremio2 = new ArrayList<>();
        miembrosGremio2.add("Laura");
        miembrosGremio2.add("José");
        miembrosGremio2.add("Pedro");
        // Agregar al repositorio de gremios el gremio 1 (clave) y sus miembros (valor)
        RepositorioDeGremios.put("Luchadores",miembrosGremio2);

        // Llamar a la funcion que imprime los miembros del gremio (Luchadores) del RepositorioDeGremios que le pasamos
        System.out.println("Bloque 2 Ejercicio 7:");
        imprimirMiembros(RepositorioDeGremios,"Luchadores");
        }
        // Funcion que imprima solo los miembros de un gremio especifico (Ejercicio 7 pt2)
        private void imprimirMiembros(HashMap<String, ArrayList<String>> RepositorioDeGremios, String gremio) {
        // Imprime todos los valores (miembros) del gremio que le pasamos (gremio) que se encuentra en el Hashmap (repositoriodeGremios)
        System.out.println(RepositorioDeGremios.get(gremio));
    }
    // El Sistema de Loot (Botín) (Ejercicio 8)
    public void sistemaDeLoot() {
        // Crear Hashmap de Botin con un una clave String (Monstruo) y un valor HashSet dentro (Objetos)
        HashMap<String, HashSet<String>> Botin = new HashMap<>();
        // Definir los objetos que soltaran los monstruos
        HashSet<String>  lootTrasgo = new HashSet<>();
        HashSet<String>  lootHydra = new HashSet<>();
        HashSet<String>  lootMedusa = new HashSet<>();
        // Rellenar los loots con contenido
        lootTrasgo.add("Espada Oxidada");

        lootHydra.add("Cabeza de Hydra");

        lootMedusa.add("Escama de Medusa");
        // Reto: Si voy a añadir a lootTrasgo Espada Oxidada y esta ya existe se ignora automáticamente.
        lootTrasgo.add("Espada Oxidada"); // Como es un HashSet no puede haber contenido repetido entonces se omite solo automaticamente
        // Añadir el loot a cada animal
        Botin.put("Trasgo", lootTrasgo);
        Botin.put("Hydra", lootHydra);
        Botin.put("Medusa", lootMedusa);

        System.out.println("Bloque 2 Ejercicio 8:\n"+Botin.entrySet());
    }
    // Rastreador de Estadisticas Complejas
    public void rastreadorEstadisticasComplejas() {
        // Crear HashMap del personaje con sus estadisticas
        HashMap<String, HashMap<String, Integer>> personajesConEstadisticas = new HashMap<>();

        // Crear Hashmap que contiene las estadisticas del personaje
        HashMap<String, Integer> estadisticas_pj1 = new HashMap<>();
        HashMap<String, Integer> estadisticas_pj2 = new HashMap<>();
        HashMap<String, Integer> estadisticas_pj3 = new HashMap<>();
        // Añadir las stats del personaje
        estadisticas_pj1.put("Fuerza",18);
        estadisticas_pj1.put("Destreza",12);
        estadisticas_pj1.put("Vida",100);

        estadisticas_pj2.put("Fuerza",15);
        estadisticas_pj2.put("Destreza",15);
        estadisticas_pj2.put("Vida",110);

        estadisticas_pj3.put("Fuerza",17);
        estadisticas_pj3.put("Destreza",10);
        estadisticas_pj3.put("Vida",90);

        // Añadir las estadisticas de los personajes a los Personajes
        personajesConEstadisticas.put("Tomas",estadisticas_pj1);
        personajesConEstadisticas.put("Laura",estadisticas_pj2);
        personajesConEstadisticas.put("Conan",estadisticas_pj3);

        // Reto: Buscar a Conan y sumarle +2 a fuerza
        if (personajesConEstadisticas.containsKey("Conan")) { // Si la clave es igual que el nombre Conan
            personajesConEstadisticas.get("Conan").put("Fuerza",personajesConEstadisticas.get("Conan").get("Fuerza")+2);  // De la clave Conan cambiamos su valor a otro valor -> El otro valor contiene  la misma clave que tenia pero ahora el parametro será el valor de la fuerza que tenia antes +2
        }
        // Imprimir personajes con estadisticas
        System.out.println("Bloque 2 Ejercicio 9:\n"+personajesConEstadisticas.entrySet());
    }
}