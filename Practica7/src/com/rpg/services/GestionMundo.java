package com.rpg.services;

import com.rpg.model.*;
import com.rpg.utils.JsonHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestionMundo {
    // Inicializar listas de objetos
    List<Personajes> personajes;
    List<Items> items;
    List<Ciudades> ciudades;

    public GestionMundo() throws IOException {
        personajes = new ArrayList<>();
        items = new ArrayList<>();
        ciudades = new ArrayList<>();

        cargarTodo();
    }

    public void cargarTodo() throws IOException {
        // Rellenar las listas de objetos
        this.personajes= new JsonHelper().readList("Practica7/Ficheros/personajes.json", Personajes.class);
        this.items = new JsonHelper().readList("Practica7/Ficheros/Items.json", Items.class);

        List<String> lineas = Files.readAllLines(Paths.get("Practica7/Ficheros/ciudades.txt")); /* Se crea una lista donde se guarda el contenido del fichero*/
        for (String linea : lineas) {
            String[] s = linea.split(";"); /* Indicamos el separador de los campos que es ; y guardamos los correspondientes atributos en el array */
            Ciudades c = new Ciudades( /* Creamos una nueva ciudad para cada linea del fichero */
                    s[0],                       /* Atributo nombre */
                    Integer.parseInt(s[1]),     /* Atributo poblacion (pasamos el dato String que es como lo teniamos guardado a Integer)*/
                    s[2],                       /* Atributo clima */
                    Integer.parseInt(s[3])      /* Atributo riesgo (pasamos el dato String que es como lo teniamos guardado a Integer)*/
            );
            this.ciudades.add(c); /* Añadimos la ciudad a la lista de ciudades*/
        }
    }
    public void crearPersonaje(String nombre, String raza, List<String> idsItem) {
        // Agregar nuevo personaje (igual que si crearamos un objeto)
        Personajes personaje = new Personajes(nombre, raza, 1, idsItem); // Todos los personajes que creamos empiezan siendo nivel 1
        this.personajes.add(personaje); // Lo añadimos a la lista
    }
    public void guardarCambios() {
        new JsonHelper().writeList("Practica7/Ficheros/personajes.json",personajes);
    }

    // Metodo para imprimir el resultado final
    public void informeFinal() {
        int contador=1;
        System.out.println("Resultado final: ");
        System.out.println("------------------");
        System.out.println("Ciudades: ");
        for (Ciudades ciudad : ciudades) {
            System.out.println("Ciudad "+contador+" : "+ciudad.toString());
            contador++;
        }
        System.out.println("------------------");
        System.out.println("Items: ");
        contador=1;
        for (Items item : items) {
            System.out.println("Item "+contador+" : "+item.toString());
            contador++;
        }
        System.out.println("------------------");
        System.out.println("Personajes: ");
        contador=1;
        for (Personajes personaje : personajes) {
            System.out.println("Personaje "+contador+" : "+personaje.toString());
            contador++;
        }
        System.out.println("------------------");
    }
}