package com.rpg.utils;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RecursoNoEncontradoException;

import java.io.*;

public class LoggerCustom {
    private String path;

    public LoggerCustom() {
        this.path = "Practica7/Ficheros/errores.log";
    }

    public void escribirLog(String mensaje) throws RecursoNoEncontradoException, DatoInvalidoException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.path, true))) { // Leer el fichero
            writer.write(mensaje);
            writer.newLine();
        }
        catch (FileNotFoundException e) {
            throw new RecursoNoEncontradoException("El fichero: " + e.getMessage() + " no ha sido encontrado.");
        }
        catch (IOException e) {
            throw new DatoInvalidoException("No se ha podido escribir en el fichero logs.");
        }
    }
}