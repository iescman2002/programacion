package com.rpg.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper{
    // Leer ficheros
    private File file;
    private FileReader fr;
    private BufferedReader br;

    // Constructor
    public TxtHelper() throws IOException {
        this.file = new File("Practica7/Ficheros/ciudades.txt"); // Indicar la ruta del fichero
        this.fr = new FileReader(file); // Para poder leer un fichero
        this.br = new BufferedReader(fr); // Para leer mas de un caracter
    }

    public List<String> leerLineas() throws IOException {
        String linea = this.br.readLine();
        List<String> lineas = new ArrayList<>();
        while (linea != null) {
            lineas.add(linea); /* Añade la linea a la lista */
            linea = br.readLine(); /* Salto de linea */
        }
        fr.close();
        return lineas;
    }
}