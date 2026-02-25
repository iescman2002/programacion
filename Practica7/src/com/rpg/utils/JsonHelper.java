package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rpg.model.Item;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    // Clases
    private Reader reader;
    private List<Item> lista;

    public JsonHelper() throws IOException {
        this.reader= Files.newBufferedReader(Paths.get("Practica7/Ficheros/items.json")); // Indicamos de donde sacamos los items
        this.lista = new Gson().fromJson(reader, new TypeToken<List<Item>>().getType()); // Le decimos a Gson que queremos una lista de tipo Item usando TypeToken
        for (Item i: lista) {
            System.out.println("\n Nombre: "+i.getNombre());
        }
    }

    // Metodos
    // Lee los datos del json
    public <T> List<T> readList(String path, Class<T> clazz) {
        try (Reader reader = new FileReader(path)) {
            Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
            List<T> lista = gson.fromJson(reader, typeOfT);
        }
        catch (IOException e) {
            System.err.println("Error al leer JSON: "+e.getMessage());
            return new ArrayList<>;
        }
    }
    // Guarda la lista de personajes actualizada en el JSON
    public <T> void writeList(String path, List<T> lista) {

    }*/
}
