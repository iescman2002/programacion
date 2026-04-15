package rpg.ui;

import rpg.dao.*;
import rpg.exception.DatoInvalidoException;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.NivelInsuficienteException;
import rpg.exception.RecursoNoEncontradoException;
import rpg.logic.Iteradores;
import rpg.model.*;
import rpg.utils.Logger;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menus {

    private Scanner s;
    private Logger logger;
    private PersonajeDAO personajeDAO;

    public Menus() throws SQLException {
        this.logger = new Logger();
        this.s = new Scanner(System.in);
        this.personajeDAO = new PersonajeDAO();
    }

    public void cargarMenuPrincipal() throws SQLException, FondosInsuficientesException, RecursoNoEncontradoException, DatoInvalidoException {
        System.out.println("¡Bienvenido al XPG Guild Master!");
        System.out.println("A continuación, indique que opción deseas acceder:");
        System.out.println("1. Crear personaje.");
        System.out.println("2. Viajar de ciudad.");
        System.out.println("3. Comprar Items.");
        System.out.println("4. Cobro de Impuestos.");
        System.out.println("5. [SOON].");
        System.out.println("--------------------------------");

        logger.escribirLog("["+ LocalDateTime.now()+"] INFO: MenuPrincipal cargado con exito.");
        int opcion = s.nextInt();
        s.nextLine(); // Para limpiar la entrada de texto anterior que sino provoca fallos despues
        switch (opcion) {
            case 1:
                menuCrearPersonaje();
                break;
            case 2:
                menuCambiarDeCiudad();
                break;
            case 3:
                menuComprarItems();
                break;
            case 4:
                new Iteradores().cobroDeImpuestos(personajeDAO.getPersonajes());
                break;
            default:
                System.out.print("Saliendo...");
                break;
        }
    }

    private void menuCrearPersonaje() throws SQLException, RecursoNoEncontradoException, DatoInvalidoException {
        System.out.println("Ha seleccionado crear personaje.");
        System.out.print("Indique el nombre del personaje: ");
        String nombre = s.nextLine();
        System.out.println("De las siguientes razas:");

        RazaDAO razas = new RazaDAO();
        for (Raza raza : razas.getRazas()) {
            System.out.println(raza.getId()+". Raza "+raza.getNombre()+", Bonificador de vida: "+raza.getBonificado_vida()+", Bonificador de fuerza: "+raza.getBonificado_fuerza());
        }
        System.out.println("Seleccione la que quiera que tenga el personaje: ");
        int id_raza = s.nextInt();

        ClaseDAO clases = new ClaseDAO();
        System.out.println("Y de las siguientes clases:");
        for (Clase clase : clases.getClases()) {
            System.out.println(clase.getId()+". Clase "+clase.getNombre());
        }
        System.out.print("Seleccione la que quiera que tenga el personaje: ");
        int id_clase =  s.nextInt();

        personajeDAO.crearPersonaje(nombre,id_raza,id_clase);
    }
    public void menuElegirHabilidades(Personaje personaje) throws SQLException, RecursoNoEncontradoException, DatoInvalidoException {
        // Elegir las habilidades que quiere tener el personaje
        System.out.println("Su personaje ha sido creado con exito, eliga a continuación las habilidades que quiere que tenga el personaje: ");
        // Mostrar las habilidades del personaje
        Personajes_HabilidadesDAO personajesHabilidadesDAO = new Personajes_HabilidadesDAO();
        List<Personajes_Habilidades> personajes_habilidades= personajesHabilidadesDAO.getPersonajes_habilidades();

        HabilidadDAO habilidadDAO = new HabilidadDAO();
        List<Habilidad> habilidades = habilidadDAO.getHabilidades();

        HashMap<Integer, Integer> ids_habilidades_posibles = new HashMap<>(); // La clave sera el contador y el valor el id de la habilidad

        Boolean elegirHabilidad = true;
        while(elegirHabilidad) {
            ids_habilidades_posibles.clear(); // Limpio el hasmap cada ve que se vuelve a llamar al bucle
            Integer contador = 1;
            for (Personajes_Habilidades personaje_habilidades : personajes_habilidades) { // Recorro las filas de la tabla personajes_habilidades (porque cada personajes_habilidades es lo mismo que una fila)
                if (personaje.getId().equals(personaje_habilidades.getId_personaje())) { // Si el id del personaje que le pasamos es igual al id de personajes_habilidad
                    // Muestro las habilidades correspondientes al id del personaje
                    for (Habilidad habilidad : habilidades) {
                        if (personaje_habilidades.getId_habilidad().equals(habilidad.getId())) {
                            System.out.println(contador + ". Habilidad: " + habilidad.getNombre() + ". Daño: " + habilidad.getDanio_base() + ". Usos maximos: " + habilidad.getUsos_maximos());
                            ids_habilidades_posibles.put(contador, personaje_habilidades.getId_habilidad());
                            contador++;
                        }
                    }
                }
            }
            System.out.print("Seleccione la que quiera que tenga el personaje o seleccione cualquier otro numero si desea salir: ");
            Integer opcion_escogida = s.nextInt();
            // Si la opcion_escogida esta dentro del hashmap
            if (ids_habilidades_posibles.containsKey(opcion_escogida)) {
                // pone como true la columna equipada_combate de personajes_habilidades
                personajesHabilidadesDAO.equiparHabilidad(personaje.getId(),ids_habilidades_posibles.get(opcion_escogida)); // Le pasamos el id del personaje y el id de la habilidad que estamos equipando (que sera el valor de la clave de la opcion que escogio el usuario)
            }
            // Sino esta dentro del hashmap, significa que el usuario no quiere tener mas habilidades asi que sale del bucle de escoger habilidades
            else {
                elegirHabilidad = false;
            }
        }
    }
    private void menuCambiarDeCiudad() throws SQLException, RecursoNoEncontradoException,DatoInvalidoException {
        System.out.println("Ha seleccionado cambiar al personaje de ciudad.");
        System.out.println("De los siguientes jugadores:");
        // Imprimir los posibles personajes:

        List<Personaje> personajes = personajeDAO.getPersonajes();
        for (Personaje personaje : personajes) {
            System.out.println(personaje.getId()+". Personaje "+personaje.getNombre()+". Nivel: "+personaje.getNivel());
        }

        System.out.print("Elija el personaje que quiera cambiar de ciudad: ");
        Integer id_personaje_escogido = s.nextInt();
        // Guardamos el personaje que va a cambiar de ciudad
        Personaje personaje_escogido = null;

        for (Personaje personaje : personajes) {
            if (personaje.getId().equals(id_personaje_escogido)) {
                personaje_escogido = personaje;
                break;
            }
        }
        // Obtener ciudad actual
        String ciudad_actual = null;
        List<Ciudad> ciudades = new CiudadDAO().getCiudades();
        for (Ciudad ciudad : ciudades) {
            if (ciudad.getId().equals(personaje_escogido.getId_ciudad_actual())) {
                ciudad_actual = ciudad.getNombre();
            }
            /*if (personaje_escogido.getId_ciudad_actual() == null) {
                ciudad_actual = null;
            }*/
        }
        if (ciudad_actual != null) {
            // Imprimir las ciudades disponibles
            System.out.println("Ha seleccionado cambiar al personaje de ciudad.\nSu ciudad actual es: " + ciudad_actual);
            System.out.println("---------------------------------");

            System.out.println("De las siguientes ciudades: ");
            for (Ciudad ciudad : ciudades) {
                System.out.println(ciudad.getId() + ". Ciudad " + ciudad.getNombre() + ". Nivel minimo para acceder: " + ciudad.getNivel_minimo_acceso());
            }
            System.out.print("Por favor, escoga la ciudad a la que desea irse: ");

            Integer id_ciudad_escogida = s.nextInt();

            // Convertir a ciudad la ciudad escogida
            Ciudad nuevaCiudad = null;

            for (Ciudad ciudad : ciudades) {
                if (ciudad.getId().equals(id_ciudad_escogida)) {
                    nuevaCiudad = ciudad;
                    break;
                }
            }
            // Verificar si tiene el nivel suficiente el jugador para cambiar de ciudad
            try {
                Boolean puedeCambiarseDeCiudad = personajeDAO.verificarNivelCiudad(personaje_escogido, nuevaCiudad);
                if (puedeCambiarseDeCiudad) { // El jugador cumple con el nivel de la ciudad
                    personajeDAO.actualizarCiudad(personaje_escogido, nuevaCiudad);
                }
            } catch (NivelInsuficienteException e) {
                System.out.println("No puede cambiar de ciudad. No cumple el nivel minimo.");
            }
        }
        else {
            System.out.println("El personaje seleccionado está desterrado porque su oro es negativo. Ni tiene ciudad ni puede entrar a ninguna.");
            logger.escribirLog("["+LocalDateTime.now()+"] ERROR: Se ha intentado cambiar la ciudad del personaje "+personaje_escogido.getId()+". El personaje se encuentra actualmente desterrado (Oro: "+personaje_escogido.getOro()+").");
        }
    }
    private void menuComprarItems() throws SQLException, FondosInsuficientesException, RecursoNoEncontradoException, DatoInvalidoException {
        // Elegir el personaje que vaya a comprar el item:
        System.out.println("Ha seleccionado la opción para comprar items.");
        System.out.println("De los siguientes jugadores:");
        // Imprimir los posibles personajes:
        List<Personaje> personajes = personajeDAO.getPersonajes();
        for (Personaje personaje : personajes) {
            System.out.println(personaje.getId()+". Personaje "+personaje.getNombre()+". Oro: "+personaje.getOro());
        }

        System.out.print("elija el personaje con el que quiera comprar el/los items: ");
        Integer id_personaje_escogido = s.nextInt();
        // Guardamos el personaje que va a comprar
        Personaje personaje_escogido = null;
        for (Personaje personaje : personajes) {
            if (personaje.getId().equals(id_personaje_escogido)) {
                personaje_escogido = personaje;
                break;
            }
        }
        // Imprimimos todos los items disponibles:
        ItemDAO itemDAO  = new ItemDAO();
        List<Item> items = itemDAO.getItems();
        System.out.println("--------------------------------");
        System.out.println("Items disponibles:");
        for (Item item : items) {
            System.out.println(item.getId()+". "+item.getNombre()+". Precio: "+item.getPrecio_oro()+" de Oro. Bono Daño: "+item.getBonificador_ataque()+".  Bono Defensa: "+item.getBonificador_defensa());
        }
        System.out.print("Introduzca el item que desea comprar: ");
        Integer id_item_escogido = s.nextInt();
        // Guardamos el item que quiere a comprar
        Item item_escogido = null;
        for (Item item : items) {
            if (item.getId().equals(id_item_escogido)) {
                item_escogido = item;
            }
        }
        // Verificar si el personaje tiene Oro suficiente para comprar el item
        Boolean puede_comprar = personajeDAO.verificarCompraItem(personaje_escogido,item_escogido);
        // Si puede comprar el item lo compramos
        if (puede_comprar) {
            personajeDAO.comprarItem(personaje_escogido,item_escogido);
        }
        // Y sino podemos lanzamos excepcion
        else {
            logger.escribirLog("["+ LocalDateTime.now()+"] ERROR: El personaje "+personaje_escogido.getId()+". No tiene fondos suficientes para comprar el item "+item_escogido.getId()+". Oro del jugador: "+ personaje_escogido.getOro()+". Precio Item: "+ item_escogido.getPrecio_oro()+".");
            throw new FondosInsuficientesException("No se ha podido comprar el item, fondos insuficientes.");
        }
    }
}