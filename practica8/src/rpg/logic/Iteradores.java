package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.model.Personaje;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iteradores {

    public void cobroDeImpuestos(List<Personaje> listaPersonajes) throws SQLException {
        PersonajeDAO personajeDAO = new PersonajeDAO();
        // Crear lista de personajes que SI tengan ciudad
        List<Personaje> personajes_con_ciudad = new ArrayList<>();
        for (Personaje personaje : listaPersonajes) {
            if (personaje.getId_ciudad_actual().equals(null)) {
                personajes_con_ciudad.add(personaje);
            }
        }
        // Crear lista de iteradores
        Iterator<Personaje> iteradorPersonajes = personajes_con_ciudad.iterator();
        // Recorro la lista de personajes con ciudad:
        while (iteradorPersonajes.hasNext()) { // Siempre que haya algun personaje detrás se ejecutará el bucle:
            // Guardo el personaje de cada iteraccion en una variable para trabajar sobre el:
            Personaje personaje = iteradorPersonajes.next();
            personaje.setOro(personaje.getOro()-20); // le resto 20 al oro de cada personaje
            // Si el oro del personaje baja de 0:
            if (personaje.getOro()<0) {
                // Lo eliminamos de la lista de iteracciones
                iteradorPersonajes.remove();
                // Y ponemos su ciudad a null
                personajeDAO.desterrarPersonaje(personaje);
            }
            // Actualizamos en cada iteracion la tabla de personajes con el nuevo oro
            personajeDAO.actualizarPersonaje(personaje);
        }
    }
}
