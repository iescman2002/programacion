package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.*;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.util.ArrayList;
import java.util.List;

public class GestionMundo {
    // Inicializar listas de objetos
    List<Personajes> personajes;
    List<Items> items;
    List<Ciudades> ciudades;

    public GestionMundo() throws RecursoNoEncontradoException {
        personajes = new ArrayList<>();
        items = new ArrayList<>();
        ciudades = new ArrayList<>();

        cargarTodo();
    }

    public void cargarTodo() throws RecursoNoEncontradoException {
        // Rellenar las listas de objetos
        try { // Si no lee alguno de estos archivos
            this.personajes= new JsonHelper().readList("Practica7/Ficheros/personajes.json", Personajes.class);
            this.items = new JsonHelper().readList("Practica7/Ficheros/Items.json", Items.class);
            this.ciudades = new TxtHelper().leerLineas("Practica7/Ficheros/ciudades.txt");
        }
        catch (Exception e) { // Lanza el mensaje de error
            throw new RecursoNoEncontradoException("Error: El fichero "+e.getMessage()+" no existe.");
        }
    }
    public void crearPersonaje(String nombre, String raza,Integer nivel, List<String> idsItem) throws DatoInvalidoException {
        try { // !!!!!! REVISAR EXCEPTION
            // Agregar nuevo personaje (igual que si crearamos un objeto)
            Personajes personaje = new Personajes(nombre, raza, nivel, idsItem);
            this.personajes.add(personaje); // Lo añadimos a la lista
        }
        catch (Exception e) {
            throw new DatoInvalidoException("Error: El dato "+e.getMessage() +" no sigue un formato valido.");
        }
    }
    public void guardarCambios() {
        new JsonHelper().writeList("Practica7/Ficheros/personajes.json",personajes);
    }

    // Metodo para imprimir el resultado final
    public void informeFinal() {
        int contador=1;
        System.out.println("Resultado final: ");
        System.out.println("------------------");
        System.out.println("Ciudades: ");
        for (Ciudades ciudad : ciudades) {
            System.out.println("Ciudad "+contador+" : "+ciudad.toString());
            contador++;
        }
        System.out.println("------------------");
        System.out.println("Items: ");
        contador=1;
        for (Items item : items) {
            System.out.println("Item "+contador+" : "+item.toString());
            contador++;
        }
        System.out.println("------------------");
        System.out.println("Personajes: ");
        contador=1;
        for (Personajes personaje : personajes) {
            System.out.println("Personaje "+contador+" : "+personaje.toString());
            contador++;
        }
        System.out.println("------------------");
    }
}