package com.rpg.utils;

import com.rpg.model.Ciudades;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper{


    public List<Ciudades> leerLineas(String path) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(path)); /* Se crea una lista donde se guarda el contenido del fichero*/
        List<Ciudades> ciudades = new ArrayList<>();
        for (String linea : lineas) {
            String[] s = linea.split(";"); /* Indicamos el separador de los campos que es ; y guardamos los correspondientes atributos en el array */
            Ciudades c = new Ciudades( /* Creamos una nueva ciudad para cada linea del fichero */
            s[0],                       /* Atributo nombre */
            Integer.parseInt(s[1]),     /* Atributo poblacion (pasamos el dato String que es como lo teniamos guardado a Integer)*/
            s[2],                       /* Atributo clima */
            Integer.parseInt(s[3])      /* Atributo riesgo (pasamos el dato String que es como lo teniamos guardado a Integer)*/
            );
            ciudades.add(c);
        }
        return ciudades;
    }
}