package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private Gson gson; /* Creamos gson como atributo para trabajar con el*/

    public JsonHelper() {
        this.gson = new Gson(); /* Lo inicializamos en el constructor*/
    }
    // Metodos

    // Lee los datos del json
    public <T> List<T> leerFichero(String path, Class<T> clazz) { // Metodo generico que devuelve una lista de cualquier tipo (como Items o Personajes) al cual se le pasa la ruta del archivo json (String) y la clase a la que pertenece (Ej: Si es items.json la Clazz es Items.class
        try (Reader reader = new FileReader(path)) {  /* Guardamos en el reader el archivo que le hemos indicado en la ruta*/
            Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType(); /*Usamos los Token para convertir el archivo en una List<T> del objeto que corresponda */
            List<T> lista = gson.fromJson(reader, typeOfT); /* Crea la lista*/

            return lista != null ? lista : new ArrayList<>(); /* Devolvemos la lista si es que existe y sino devolvemos una lista nueva vacia.*/
        }
        catch (IOException e) { /* En caso de haber algun fallo leyendo los datos del archivo, se imprime este error*/
            System.err.println("Error al leer JSON: "+e.getMessage());
            return new ArrayList<>();
        }
    }
}
