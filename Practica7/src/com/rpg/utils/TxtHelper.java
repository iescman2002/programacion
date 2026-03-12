package com.rpg.utils;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.Ciudades;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper{


    public List<Ciudades> leerLineas(String path) throws DatoInvalidoException, RecursoNoEncontradoException {
        try { /* Primer try catch para mandar error si falla la lectura del fichero*/
            List<String> lineas = Files.readAllLines(Paths.get(path)); /* Se crea una lista donde se guarda el contenido del fichero*/
            List<Ciudades> ciudades = new ArrayList<>();
            int numlinea = 1;
            for (String linea : lineas) {
                try { /* Segundo try catch para mandar error si hay una linea corrupta y pasar a la siguiente ciudad (por eso se hace dentro del for, para hacerlo sobre cada linea) */
                    String[] s = linea.split(";"); /* Indicamos el separador de los campos que es ; y guardamos los correspondientes atributos en el array */
                    Ciudades c = new Ciudades(  /* Creamos una nueva ciudad para cada linea del fichero */
                    s[0],                       /* Atributo nombre */
                    Integer.parseInt(s[1]),     /* Atributo poblacion (pasamos el dato String que es como lo teniamos guardado a Integer)*/
                    s[2],                       /* Atributo clima */
                    Integer.parseInt(s[3])      /* Atributo riesgo (pasamos el dato String que es como lo teniamos guardado a Integer)*/
                    );
                    ciudades.add(c);
                    new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: Ciudad "+numlinea +" Añadida. Pasando a la siguiente ciudad.");
                }
                catch (Exception e) {
                    new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] ERROR: Linea "+numlinea +" corrupta. Pasando a la siguiente ciudad.");
                }
                numlinea++;
        }
        return ciudades;}
        catch (IOException e) {
            new LoggerCustom().escribirLog("["+ LocalDateTime.now()+"] ERROR: No se ha podido leer el fichero: "+e.getMessage());
            throw new DatoInvalidoException("El fichero +"+e.getMessage()+" no se ha podido leer.");
        }
    }
}