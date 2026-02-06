package Bloques;

import java.util.ArrayList;
import java.util.HashMap;

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
}