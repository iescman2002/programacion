package rpg.logic;

import rpg.dao.InventarioDAO;
import rpg.dao.ItemDAO;
import rpg.dao.PersonajeDAO;
import rpg.exception.DatoInvalidoException;
import rpg.exception.LimiteHabilidadesException;
import rpg.exception.RecursoNoEncontradoException;
import rpg.model.Inventario;
import rpg.model.Item;
import rpg.model.Personaje;
import rpg.ui.Menus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MotorCombate {

    public MotorCombate() throws SQLException, RecursoNoEncontradoException, DatoInvalidoException, LimiteHabilidadesException {
        InicioCombate();
    }

    private void InicioCombate() throws SQLException, RecursoNoEncontradoException, DatoInvalidoException, LimiteHabilidadesException {
        System.out.println("FASE 1. Preparación del combate.");
        // Primero, Elegir personajes que van a combatir
        Personaje[] personajes_pelean = new Menus().menuElegirPersonaje();
        Personaje personaje1 = personajes_pelean[0];
        Personaje personaje2 = personajes_pelean[1];
        // Despues, elegir las habilidades de los personajes
        new Menus().menuElegirHabilidades(personaje1,1);
        new Menus().menuElegirHabilidades(personaje2,2);
        // Ahora, calculamos el daño total de cada personaje
        Integer[] stats_pj1 = obtenerDanioYDefensa(personaje1);
        Integer[] stats_pj2 = obtenerDanioYDefensa(personaje2);

        Integer danio_pj1 = stats_pj1[0];
        Integer danio_pj2 = stats_pj2[0];
        // Ahora, calculamos la defensa total de cada personaje
        Integer defensa_pj1 = stats_pj1[1];
        Integer defensa_pj2 = stats_pj2[1];
    }

    private Integer[] obtenerDanioYDefensa(Personaje pj) throws SQLException {
        InventarioDAO inventarioDAO = new InventarioDAO();
        List<Inventario> inventarios = inventarioDAO.getInventarios();

        HashMap<Integer,Integer> itemsPJ = new HashMap<>(); // La clave es el id_item y el valor la cantidad del item
        // Obtener el id de los items del personaje
        for (Inventario inventario : inventarios) {
            // Si el item no esta añadido al hashmap lo añado y le pongo 1 de cantidad
            if (inventario.getId_personaje().equals(pj.getId())&&(!itemsPJ.containsKey(inventario.getId_item()))) {
                itemsPJ.put(inventario.getId_item(),1);
            }
            // Si ya se ha añadido el item al hashmap sumo 1 al valor (cantidad)
            else if (inventario.getId_personaje().equals(pj.getId())&&itemsPJ.containsKey(inventario.getId_item())) {
                itemsPJ.replace(inventario.getId_item(),itemsPJ.get(inventario.getId_item())+1);
            }
        }

        Integer dmgTotal_pj = 0;
        Integer defTotal_pj = 0;

        ItemDAO itemDAO = new ItemDAO();
        List<Item> items = itemDAO.getItems();
        for (Item item : items) {
            if (itemsPJ.containsKey(item.getId())) {
                // si el item se encuentra en los items del personaje,
                Integer danio = item.getBonificador_ataque()*itemsPJ.get(item.getId()); // Daño del personaje = bono_ataque del item * cantidad de veces que tiene el item
                Integer def = item.getBonificador_defensa()*itemsPJ.get(item.getId()); // Defensa del personaje = bono_ataque del item * cantidad de veces que tiene el item
                dmgTotal_pj += danio;
                defTotal_pj += def;
            }
        }
        Integer[] stats = new Integer[2];
        stats[0] =  dmgTotal_pj; // El daño del personaje en la posicion 0
        stats[1] =  defTotal_pj; // La defensa del personaje en la posicion 1
        return stats;
    }
}
