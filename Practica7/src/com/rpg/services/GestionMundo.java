package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.*;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.LoggerCustom;
import com.rpg.utils.TxtHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionMundo {
    // Inicializar listas de objetos
    List<Personajes> personajes;
    List<Items> items;
    List<Ciudades> ciudades;

    public GestionMundo() throws RecursoNoEncontradoException, DatoInvalidoException {
        personajes = new ArrayList<>();
        items = new ArrayList<>();
        ciudades = new ArrayList<>();

        cargarTodo();
    }

    public void cargarTodo() throws RecursoNoEncontradoException, DatoInvalidoException {
        // Rellenar las listas de objetos
        /*try { */ // Eliminamos el try catch porque la función readList y leerLineas ya tiene un try catch incorporado entonces meter otro seria duplicar el error
            this.personajes= new JsonHelper().readList("Practica7/Ficheros/personajes.json", Personajes.class);
            new LoggerCustom().escribirLog("["+ LocalDateTime.now()+"] INFO: Lista de personajes leida con exito.");
            this.items = new JsonHelper().readList("Practica7/Ficheros/Items.json", Items.class);
            new LoggerCustom().escribirLog("["+ LocalDateTime.now()+"] INFO: Lista de Items leida con exito.");
            this.ciudades = new TxtHelper().leerLineas("Practica7/Ficheros/ciudades.txt");
            new LoggerCustom().escribirLog("["+ LocalDateTime.now()+"] INFO: Lista de Ciudades leida con exito.");
        /*}
        catch (Exception e) { // Lanza el mensaje de error
            new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] ERROR: El fichero "+e.getMessage()+" no ha sido encontrado.");
            throw new RecursoNoEncontradoException("Error: El fichero "+e.getMessage()+" no existe o no ha sido encontrado.");
        }*/
    }
    public void crearPersonaje() throws DatoInvalidoException, RecursoNoEncontradoException {
        // Probar que se pueden agregar personajes
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Introduzca el nombre del personaje: ");
            String nombre = s.next();
            System.out.print("Introduzca la raza del personaje: ");
            String raza = s.next();
            System.out.print("Introduzca el nivel del personaje: ");
            Integer nivel = s.nextInt();
            // Agregar nuevo personaje (igual que si crearamos un objeto)
            Personajes personaje = new Personajes(nombre, raza, nivel, new ArrayList<>());
            this.personajes.add(personaje); // Lo añadimos a la lista
            new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: El personaje "+personaje.getNombre()+" ha sido creado.");
        }
        catch (Exception e) {
            new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] ERROR: El dato "+e.getMessage()+" no sigue un formato válido.");
            throw new DatoInvalidoException("Error: El dato "+e.getMessage() +" no sigue un formato válido.");
        }
    }
    public void guardarCambios() throws RecursoNoEncontradoException {
        try{
            new JsonHelper().writeList("Practica7/Ficheros/personajes.json",personajes);
        } catch (Exception e) {
            throw new RecursoNoEncontradoException("Error: El fichero "+e.getMessage()+" no existe o no ha sido encontrado.");
        }
    }

    // Metodo para imprimir el resultado final
    public void informeFinal() throws RecursoNoEncontradoException, DatoInvalidoException {
        int contador=1;
        System.out.println("Resultado final: ");
        System.out.println("------------------");
        System.out.println("Ciudades: ");
        for (Ciudades ciudad : ciudades) {
            System.out.println("Ciudad "+contador+" : "+ciudad.toString());
            contador++;
        }
        new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: Se han impreso correctamente todas las ciudades.");
        System.out.println("------------------");
        System.out.println("Items: ");
        contador=1;
        for (Items item : items) {
            System.out.println("Item "+contador+" : "+item.toString());
            contador++;
        }
        new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: Se han impreso correctamente todos los items.");
        System.out.println("------------------");
        System.out.println("Personajes: ");
        contador=1;
        for (Personajes personaje : personajes) {
            System.out.println("Personaje "+contador+" : "+personaje.toString());
            contador++;
        }
        new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: Se han impreso correctamente todos los personajes.");
        System.out.println("------------------");
    }
}