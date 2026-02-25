package com.rpg.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

    public void leerLineas() throws IOException {
        String linea = this.br.readLine();
        while (linea != null) {
            System.out.println(linea);
            linea = br.readLine();
        }
        fr.close();
    }
}