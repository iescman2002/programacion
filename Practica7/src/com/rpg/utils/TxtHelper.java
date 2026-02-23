package com.rpg.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtHelper {
    // Leer ficheros
    private File file;
    private FileReader fr;
    private BufferedReader br;

    // Constructor
    public TxtHelper() {
        this.file = Files.newBufferedReader( Paths.get("../../Ficheros/ciudades.txt"));
        this.fr = new FileReader(file);
        this.br = new BufferedReader(fr);
    }

    public void leerLineas() {
        String linea;
        while ((linea = file.readLine()) != null) {
            System.out.println(linea);
        }
    }
}