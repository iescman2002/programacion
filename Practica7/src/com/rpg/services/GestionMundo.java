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
}
