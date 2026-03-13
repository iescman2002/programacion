package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.*;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.LoggerCustom;
import com.rpg.utils.TxtHelper;

import java.time.LocalDateTime;
import java.util.*;

public class GestionMundo {
    // Inicializar listas de objetos
    private List<Personajes> personajes;
    private List<Items> items;
    private List<Ciudades> ciudades;
    // Crear Hashmap para buscar items por id de forma eficiente
    private HashMap<String, Items> coleccionDeItems; // La clave String será el idItem y el valor será el propio item

    public GestionMundo() throws RecursoNoEncontradoException, DatoInvalidoException {
        this.personajes = new ArrayList<>();
        this.items = new ArrayList<>();
        this.ciudades = new ArrayList<>();
        this.coleccionDeItems = new HashMap<>();
        cargarTodo();
    }

    public void cargarTodo() throws RecursoNoEncontradoException, DatoInvalidoException {
        // Rellenar las listas de objetos
        this.personajes= new JsonHelper().readList("Practica7/Ficheros/personajes.json", Personajes.class);
        new LoggerCustom().escribirLog("["+ LocalDateTime.now()+"] INFO: Lista de personajes cargada con exito.");
        this.items = new JsonHelper().readList("Practica7/Ficheros/items.json", Items.class);
        new LoggerCustom().escribirLog("["+ LocalDateTime.now()+"] INFO: Lista de Items cargada con exito.");
        this.ciudades = new TxtHelper().leerLineas("Practica7/Ficheros/ciudades.txt");
        new LoggerCustom().escribirLog("["+ LocalDateTime.now()+"] INFO: Lista de Ciudades cargada con exito.");
        // Rellenar el HashMap con los items
        for (Items item : this.items) {
            this.coleccionDeItems.put(item.getId(),item);
        }

        // Validar los idItems de los personajes (Asegurarse que los idItems existan)
        validacion(); // Metido en una función aparte para poder validar despues de crear un personaje tambien sin copiar codigo.
        validacionBiomas();
    }

    public void crearPersonaje() throws DatoInvalidoException, RecursoNoEncontradoException {
        // Probar que se pueden agregar personajes
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Introduzca el nombre del personaje: ");
            String nombre = s.next();
            new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: El usuario ha introducido correctamente el nombre.");
            System.out.print("Introduzca la raza del personaje: ");
            String raza = s.next();
            new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: El usuario ha introducido correctamente la raza.");
            // Escoger nivel
            System.out.print("Introduzca el nivel del personaje: ");
            Integer nivel;
            while (true) {
                nivel = s.nextInt();
                if (nivel >= 0) {
                    new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: El usuario ha introducido correctamente el nivel.");
                    break;
                }
                else {
                    System.out.print("El nivel tiene que ser superior o igual a 0, intentelo de nuevo: ");
                    new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: El usuario ha introducido un nivel negativo, volviendolo a intentar.");
                }
            }
            // Elegir los items para el usuario
            List<String> listaDeItems = new ArrayList<>();
            // Los muestra
            System.out.println("De estos siguientes items: ");
            for (Items item : this.coleccionDeItems.values()) {
                System.out.println(item.toString());
            }
            // Bucle para escoger un item correcto
            while(true) {
                System.out.print("Introduzca el id del item que quiere agregar o introduzca Salir para salir: ");
                String idEscogido = s.next();
                if (idEscogido.equalsIgnoreCase("Salir")) { // Si lo que hemos introducido es igual a salir (da igual las mayusculas o minusculas lo que mira son los caracteres) se sale
                    break;
                }
                if (!this.coleccionDeItems.containsKey(idEscogido)) { // Si el usuario ha introducido un id que NO existe en la coleccion de items
                    new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] ERROR: El idItem "+idEscogido+" introducido no existe en el sistema.");
                }
                else {
                    listaDeItems.add(idEscogido); // Añadimos a la lista el item escogido
                }
            }
            // Elegir la ciudad para el usuario
            String ciudad = "";
            // Bucle para elegir una ciudad correcta.
                for (Ciudades ciud : this.ciudades) {
                    System.out.print("Introduzca el nombre de la ciudad: ");
                    ciudad = s.next();
                    if (ciud.getNombre().equals(ciudad)) {
                        break;
                    }
                    else {
                        System.out.println("Ha introducido una ciudad invalida.");
                        new LoggerCustom().escribirLog("[" + LocalDateTime.now() + "] ERROR: El usuario ha introducido la ciudad " + ciudad + " y no existe.");
                    }
                }
            // Agregar nuevo personaje (igual que si crearamos un objeto)
            Personajes personaje = new Personajes(nombre, raza, nivel, listaDeItems, ciudad);
            this.personajes.add(personaje); // Lo añadimos a la lista
            validacion(); // y lo validamos para asegurarnos que lo hayamos creado bien
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
        for (Ciudades ciudad : this.ciudades) {
            System.out.println("Ciudad "+contador+" : "+ciudad.toString());
            contador++;
        }
        new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: Se han impreso correctamente todas las ciudades.");
        System.out.println("------------------");
        System.out.println("Items: ");
        contador=1;
        for (Items item : this.items) {
            System.out.println("Item "+contador+" : "+item.toString());
            contador++;
        }
        new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: Se han impreso correctamente todos los items.");
        System.out.println("------------------");
        System.out.println("Personajes: ");
        contador=1;
        for (Personajes personaje : this.personajes) {
            System.out.println("Personaje "+contador+" : "+personaje.toString());
            contador++;
        }
        new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: Se han impreso correctamente todos los personajes.");
        System.out.println("------------------");
    }

    // Metodo para validar que los items de la lista de cada personaje exista.
    private void validacion() throws RecursoNoEncontradoException, DatoInvalidoException {
        for (Personajes personaje : this.personajes) { // Recorro los personajes
            for (String idPersonaje : personaje.getEquipoIds()) {
                if (this.coleccionDeItems.containsKey(idPersonaje)) { // Si la clave es igual al idPersonaje (es decir que existe el item)
                    new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: El item"+ this.coleccionDeItems.get(idPersonaje).getId() +" del personaje "+personaje.getNombre() +" se ha validado correctamente.");
                }
                else { // Si el item que busca no se encuentra
                    new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] ERROR: El item "+idPersonaje+ " del personaje "+personaje+" no existe.");
                    throw new DatoInvalidoException("Error: El item asociado al personaje no existe.");
                }
            }
        }
    }

    // Metodo para validar los biomas
    private void validacionBiomas() throws RecursoNoEncontradoException, DatoInvalidoException {
        // La clave es el nombre de la ciudad y el valor el clima
        HashMap<String, String> coleccionCiudades = new HashMap<>();
        for (Ciudades ciudad : this.ciudades) {
            coleccionCiudades.put(ciudad.getNombre(),ciudad.getClima());
        }

        List<Personajes> personajesAEliminar = new ArrayList<>(); // Creamos una lista de personajes que vamos a eliminar para no eliminar los personajes directamente en media ejecucion del bucle.

        for (Personajes personaje : this.personajes) {
            // validacion de Personaje con Raza = "Enano" y con el Clima de la Ciudad= "Desertico".
            if ((coleccionCiudades.get(personaje.getNombreCiudad()).equalsIgnoreCase("Desertico"))&&(personaje.getRaza().equalsIgnoreCase("Enano"))) { // Si el nombre de la ciudad del personaje (clave) es igual que Desertico (valor = Desertico) Y la raza del personaje es igual a Enano, manda error.
                personajesAEliminar.add(personaje); // Añade el personaje a la lista de personajes a eliminar.
                new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] ERROR: El personaje "+personaje.getNombre() +" tiene la raza "+personaje.getRaza()+" y el clima de su ciudad es "+coleccionCiudades.get(personaje.getNombreCiudad())+". Eliminando Personaje.");
            }
            else {
                new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: El personaje "+ personaje.getNombre() +" tiene su ciudad"+personaje.getNombreCiudad()+" validada correctamente.");
            }
            // validacion de Item con Tipo = "Hielo" y con el Clima de la Ciudad del Personaje = "Volcanica".
            for(String idItem : personaje.getEquipoIds()) { // Recorro los items del cada personaje
                if (this.coleccionDeItems.containsKey(idItem)) { // Si se encuentra el item (idItem) en la lista de items (clave del HashMap)
                    if(this.coleccionDeItems.get(idItem).getTipo().equalsIgnoreCase("Hielo")&&(coleccionCiudades.get(personaje.getNombreCiudad()).equalsIgnoreCase("Volcanico"))) { // Y el tipo del item es igual a hielo Y el Clima de la ciudad del personaje es "Volcanico"
                        personajesAEliminar.add(personaje); // Añade el personaje a la lista de personajes a eliminar.
                        new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] ERROR: El personaje "+ personaje.getNombre()+ " tiene el objeto "+this.coleccionDeItems.get(idItem).getNombre()+" y el clima de su ciudad es "+coleccionCiudades.get(personaje.getNombreCiudad())+". Eliminando Personaje.");
                    }
                    else {
                        new LoggerCustom().escribirLog("["+LocalDateTime.now()+"] INFO: El item "+ this.coleccionDeItems.get(idItem).getNombre() +" del personaje "+personaje.getNombre()+" ha sido validado correctamente.");
                    }
                }
            }
        }
        // Eliminar personajes de la lista
        this.personajes.removeAll(personajesAEliminar);
    }
}