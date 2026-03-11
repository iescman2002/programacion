package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.rpg.handler.FormatoInvalidoException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.Personajes;

import java.io.*;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonHelper {
    private Gson gson; /* Creamos gson como atributo para trabajar con el*/

    public JsonHelper() {
        this.gson = new GsonBuilder().setPrettyPrinting().create(); /* Lo inicializamos en el constructor*/
    }
    // Metodos

    // Lee los datos del json
    public <T> List<T> readList(String path, Class<T> clazz) throws RecursoNoEncontradoException { // Metodo generico que devuelve una lista de cualquier tipo (como Items o Personajes) al cual se le pasa la ruta del archivo json (String) y la clase a la que pertenece (Ej: Si es items.json la Clazz es Items.class
        try (Reader reader = new FileReader(path)) {  /* Guardamos en el reader el archivo que le hemos indicado en la ruta*/
            Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType(); /*Usamos los Token para convertir el archivo en una List<T> del objeto que corresponda */
            List<T> lista = gson.fromJson(reader, typeOfT); /* Crea la lista*/

            return lista != null ? lista : new ArrayList<>(); /* Devolvemos la lista si es que existe y sino devolvemos una lista nueva vacia.*/
        }
        catch (IOException e) { /* En caso de haber algun fallo leyendo los datos del archivo, se imprime este error*/
            throw new RecursoNoEncontradoException("Error al leer JSON: "+e.getMessage());
        }
    }

    // Escribir en el json
    public <T> void writeList(String path, List<T> lista) throws FormatoInvalidoException { // Le pasamos a la funcion el archivo json y la lista con la que queremos que actualice el archivo
        try (Writer writer = new FileWriter(path)) {    // Creamos un writer al cual donde le indicamos el archivo json del cual vamos a escribir (path)
            gson.toJson(lista,writer);                // Usamos el metodo de gson toJson para actualizar el archivo (writer) con la lista actualizada de objetos que le hayamos pasado (lista)
        } catch (IOException e) {
            throw new FormatoInvalidoException("Error al escribir el JSON: " + e.getMessage());
        }
    }
}