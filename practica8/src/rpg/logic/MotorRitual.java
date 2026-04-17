package rpg.logic;

import rpg.dao.InventarioDAO;
import rpg.dao.PersonajeDAO;
import rpg.dao.Personajes_HabilidadesDAO;
import rpg.exception.DatoInvalidoException;
import rpg.model.Inventario;
import rpg.model.Personaje;
import rpg.model.Personajes_Habilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MotorRitual {


    public void procesarRitual(List<Personaje> expedicion, int idClaseEvolucionada) throws DatoInvalidoException {
        // La clave es el personaje y El valor es el n de habilidades_equipadas
        Personajes_HabilidadesDAO personajesHabilidadesDAO = new Personajes_HabilidadesDAO();
        HashMap<Integer, Integer> idPersonajes_habilidades_equipadas = new HashMap<>();

        for (Personajes_Habilidades personaje_Habilidades : personajesHabilidadesDAO.getPersonajes_habilidades()) {
            // Si tenemos guardado ya de antes el id_personaje actualizo +1 al valor (habilidades_usadas)
            if (idPersonajes_habilidades_equipadas.containsKey(personaje_Habilidades.getId_personaje())) {
                // Y es true (esta equipada
                if (personaje_Habilidades.getEquipada_combate()) {
                    idPersonajes_habilidades_equipadas.replace(personaje_Habilidades.getId_personaje(), idPersonajes_habilidades_equipadas.get(personaje_Habilidades.getId_personaje()) + 1);
                }
            } else {
                idPersonajes_habilidades_equipadas.put(personaje_Habilidades.getId_personaje(), 1);
            }
        }

        // Crear lista de personajes que tienen 3 habilidades escogidas:
        List<Personaje> personajesCon3Habilidades = new ArrayList<>();
        for (Personaje personaje : expedicion) {
            // Si tiene <= 3 habilidades equipadas lo añado a la lista
            if (idPersonajes_habilidades_equipadas.containsKey(personaje.getId())) {
                if (idPersonajes_habilidades_equipadas.get(personaje.getId()) == 3) {
                    personajesCon3Habilidades.add(personaje);
                }
            }
        }
        // Comprobar que tenga +5 items:
        InventarioDAO inventarioDAO = new InventarioDAO();
        HashMap<Personaje, Integer> personaje_items = new HashMap<>();

        for (Inventario inventario : inventarioDAO.getInventarios()) {
            for (Personaje personaje : personajesCon3Habilidades) {
                if (inventario.getId_personaje().equals(personaje.getId())) {
                    personaje_items.put(personaje, inventario.getCantidad());
                }
            }
        }

        // Si cumplen las 2 condiciones:
        PersonajeDAO personajeDAO = new PersonajeDAO();
        for (Personaje personaje : personaje_items.keySet()) {
            if (personaje_items.get(personaje) > 5) {
                personaje.setId(idClaseEvolucionada);
                // Actualizar base de datos
                personajeDAO.actualizarIdPersonaje(personaje, idClaseEvolucionada);
                // Actualizar el oro
                personaje.setOro(personaje.getOro() - 50);
                personajeDAO.actualizarOroPersonaje(personaje);
            }
        }

        // Uso de Iterador:
        Iterator<Personaje> iterador = personaje_items.keySet().iterator();
        while (iterador.hasNext()) {
            Personaje personaje = iterador.next();
            if (personaje.getVida_actual()<personaje.getVida_actual()*0.10) {
                iterador.remove();
                personajeDAO.desterrarPersonaje(personaje);
            }
        }

    }
}
