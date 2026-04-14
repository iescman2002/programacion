package rpg.utils;

import rpg.exception.DatoInvalidoException;
import rpg.exception.RecursoNoEncontradoException;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private String path;

    public Logger() {
        this.path = "Info.logs";
    }


    public void escribirLog(String mensaje) throws RecursoNoEncontradoException, DatoInvalidoException {
        // Copia y pega de la practica 7
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.path, true))) { // Leer el fichero
            writer.write(mensaje);
            writer.newLine();
        } catch (FileNotFoundException e) {
            throw new RecursoNoEncontradoException("El fichero: " + e.getMessage() + " no ha sido encontrado.");
        } catch (IOException e) {
            throw new DatoInvalidoException("No se ha podido escribir en el fichero logs.");
        }
    }
}
