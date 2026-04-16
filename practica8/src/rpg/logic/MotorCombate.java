package rpg.logic;

import rpg.dao.*;
import rpg.exception.DatoInvalidoException;
import rpg.exception.LimiteHabilidadesException;
import rpg.exception.RecursoNoEncontradoException;
import rpg.model.*;
import rpg.ui.Menus;
import rpg.utils.Logger;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MotorCombate {
    Personaje personaje1;
    List<Habilidad> habilidades_pj1;
    Personaje personaje2;
    List<Habilidad> habilidades_pj2;
    // Guardamos en una coleccion las habilidades de los personajes y sus usos restantes
    HashMap<Habilidad,Integer> pj1_Habilidades_usos_restantes;
    HashMap<Habilidad,Integer> pj2_Habilidades_usos_restantes;
    // Las stats del Daño Fisico y la defensa que tendrán los personajes
    Integer pj1_danio_fisico;
    Integer pj2_danio_fisico;
    Integer pj1_defensa;
    Integer pj2_defensa;
    Menus menus;
    Logger logger;

    public MotorCombate() throws SQLException, RecursoNoEncontradoException, DatoInvalidoException, LimiteHabilidadesException {
        this.logger = new Logger();
        this.menus = new Menus();
        // Primero, Elegir personajes que van a combatir
        Personaje[] personajes_pelean = this.menus.menuElegirPersonaje();
        this.personaje1 = personajes_pelean[0];
        this.personaje2 = personajes_pelean[1];

        this.habilidades_pj1 = new ArrayList<>();
        this.habilidades_pj2 = new ArrayList<>();
        this.pj1_Habilidades_usos_restantes = new HashMap<>();
        this.pj2_Habilidades_usos_restantes = new HashMap<>();

        InicioCombate();
    }

    private void InicioCombate() throws SQLException, RecursoNoEncontradoException, DatoInvalidoException, LimiteHabilidadesException {
        System.out.println("FASE 1. Preparación del combate.");
        // Despues, elegir las habilidades de los personajes
        this.habilidades_pj1 = this.menus.menuElegirHabilidades(this.personaje1, 1);
        this.habilidades_pj2 = this.menus.menuElegirHabilidades(this.personaje2, 2);
        for (Habilidad habilidad : this.habilidades_pj1) {
            this.pj1_Habilidades_usos_restantes.put(habilidad, habilidad.getUsos_maximos());
        }
        for (Habilidad habilidad : this.habilidades_pj2) {
            this.pj2_Habilidades_usos_restantes.put(habilidad, habilidad.getUsos_maximos());
        }

        // Ahora, calculamos el daño total de cada personaje
        Integer[] stats_pj1 = obtenerDanioYDefensa(this.personaje1);
        Integer[] stats_pj2 = obtenerDanioYDefensa(this.personaje2);

        this.pj1_danio_fisico = stats_pj1[0];
        this.pj2_danio_fisico = stats_pj2[0];
        // Ahora, calculamos la defensa total de cada personaje
        this.pj1_defensa = stats_pj1[1];
        this.pj2_defensa = stats_pj2[1];

        // Iniciar combate
        System.out.println("-------------------------------");
        System.out.println("FASE 2. Comienza el combate!");
        combatir();
        // Si la vida de personaje1 es <= 0 El ganador es personaje2, sino el ganador es personaje1
        Personaje ganador = (this.personaje1.getVida_actual() <= 0) ? personaje2 : personaje1;
        System.out.println("El ganador es: " + ganador.getNombre());
        logger.escribirLog("["+ LocalDate.now()+"] INFO: El jugador "+ganador.getNombre()+" ha ganado el combate.");
    }

    private Integer[] obtenerDanioYDefensa(Personaje pj) throws SQLException, RecursoNoEncontradoException, DatoInvalidoException {
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
        logger.escribirLog("["+ LocalDate.now()+"] INFO: La defensa y el daño de los personajes que pelearán han sido cargadas con éxito.");
        return stats;
    }

    private Boolean habilidadSePuedeUsar(Habilidad habilidad, Integer jugador) {
    // Verifica si la habilidad tiene usos suficientes para hacerse o no
        Boolean puedeUsarse = false;
        // Si es el jugador 1:
        if (jugador.equals(1)) {
            if (this.pj1_Habilidades_usos_restantes.get(habilidad)>0) {
                puedeUsarse = true;
            }
        }
        if (jugador.equals(2)) {
            if (this.pj2_Habilidades_usos_restantes.get(habilidad)>0) {
                puedeUsarse = true;
            }
        }
        return puedeUsarse;
    }

    private void usarHabilidad(Personaje pj,Habilidad habilidad) {
        // Si el personaje que ataca es el pj1:
        if (pj.equals(this.personaje1)) {
            // 1ero: Resto 1 a los usos restantes de la habilidad:
            Integer usos_restantes = pj1_Habilidades_usos_restantes.get(habilidad)-1;
            this.pj1_Habilidades_usos_restantes.replace(habilidad,usos_restantes);
            // 2ndo: Obtener el daño que va a hacer la habilidad:
            Integer dmg_habilidad = habilidad.getDanio_base()-(pj2_defensa / 2);
            if (dmg_habilidad<=0) {dmg_habilidad = 1;} // Si el daño acaba siendo negativo o 0 pongo un daño minimo de 1
            // 3ro: Restarle a la vida del personaje al que le atacamos el daño que haremos:
            this.personaje2.setVida_actual(this.personaje2.getVida_actual()-dmg_habilidad);
            System.out.println("------------------------------------------");
            System.out.println("El personaje "+pj.getNombre()+" ha infligido un total de: "+dmg_habilidad+" daño.");
        }
        // Sino pos el personaje que ataca será el pj2:
        else {
            // 1ero: Resto 1 a los usos restantes de la habilidad
            Integer usos_restantes = pj2_Habilidades_usos_restantes.get(habilidad)-1;
            this.pj2_Habilidades_usos_restantes.replace(habilidad,usos_restantes);
            // 2ndo: Obtener el daño que va a hacer la habilidad:
            Integer dmg_habilidad = habilidad.getDanio_base()-(pj1_defensa / 2);
            if (dmg_habilidad<=0) {dmg_habilidad = 1;} // Si el daño acaba siendo negativo o 0 pongo un daño minimo de 1
            // 3ro: Restarle a la vida del personaje al que le atacamos el daño que haremos:
            this.personaje1.setVida_actual(this.personaje1.getVida_actual()-dmg_habilidad);
            System.out.println("El personaje "+pj.getNombre()+" ha infligido un total de: "+dmg_habilidad+" daño.");
        }
    }

    private void ataqueBasico(Personaje pj) {
        // Si el personaje que ataca es el pj1:
        if (pj.equals(this.personaje1)) {
            // 1ero: Guardo el daño total que haré (para que sea más legible)
            Integer dmg_total = this.pj1_danio_fisico-(pj2_defensa/2);
            if (dmg_total<=0) {dmg_total = 1;} // Si el daño acaba siendo negativo o 0 pongo un daño minimo de 1
            // 2ndo: Le resto a la vida del personaje al que le atacamos el daño que haremos:
            this.personaje2.setVida_actual(this.personaje2.getVida_actual()-dmg_total);
        }
        // Sino pos el personaje que ataca será el pj2:
        else {
            // 1ero: Guardo el daño total que haré (para que sea más legible)
            Integer dmg_total = this.pj2_danio_fisico-(pj1_defensa/2);
            if (dmg_total<=0) {dmg_total = 1;} // Si el daño acaba siendo negativo o 0 pongo un daño minimo de 1
            // 2ndo: Le resto a la vida del personaje al que le atacamos el daño que haremos:
            this.personaje1.setVida_actual(this.personaje1.getVida_actual()-dmg_total);
        }
    }

    private void combatir() throws RecursoNoEncontradoException, DatoInvalidoException {
        logger.escribirLog("["+ LocalDate.now()+"] INFO: Combate empezado entre el jugador "+this.personaje1.getId()+" y el jugador + "+this.personaje2.getId()+".");
        Integer turno = 1;
        while (this.personaje1.getVida_actual() > 0 && this.personaje2.getVida_actual() > 0) {
            // Turno jugador 1:
            System.out.println("Turno  "+turno+". Va el jugador 1:");
            turno(this.personaje1);
            logger.escribirLog("["+ LocalDate.now()+"] INFO: Turno "+turno+" finalizado.");
            turno++;
            // Si en el turno del jugador 1 muere el jugador 2:
            if (this.personaje2.getVida_actual() <= 0) {
                break; // Salgo del bucle para que no ataque el personaje 2 estando muerto
            }
            // Turno jugador 2:
            System.out.println("Turno  "+turno+". Va el jugador 2:");
            turno(this.personaje2);
            logger.escribirLog("["+ LocalDate.now()+"] INFO: Turno "+turno+" finalizado.");
            turno++;
        }
    }

    private void turno(Personaje personaje) throws RecursoNoEncontradoException, DatoInvalidoException {

        // Si el turno corresponde al personaje 1:
        if (personaje.equals(this.personaje1)) {
            menus.mostrarEstadisticasCombate(this.personaje1,1,this.personaje2);
            // Escoger habilidades:
            Habilidad habilidad_escogida = this.menus.mostrarYEscogerHabilidad(pj1_Habilidades_usos_restantes,this.pj2_defensa); // Le paso las habilidades del personaje (clave) y sus usos restantes (valor), asi como la defensa del personaje contrario
            // Si la habilidad escogida es null (ataque básico):
            if (habilidad_escogida == null) {
                ataqueBasico(personaje);
                logger.escribirLog("["+ LocalDate.now()+"] INFO: El personaje 2 ha usado la habilidad ataque básico.");
            }
            // Si la habilidad seleccionada se puede usar y no es null:
            else if (habilidadSePuedeUsar(habilidad_escogida, 1)) {
                usarHabilidad(personaje, habilidad_escogida);
                logger.escribirLog("["+ LocalDate.now()+"] INFO: El personaje 1 ha usado la habilidad:"+habilidad_escogida.getNombre());
            }
            // Si no le quedan usos a la habilidad:
            else {
                // ataca por defecto:
                ataqueBasico(personaje);
                logger.escribirLog("["+ LocalDate.now()+"] INFO: El personaje 2 ha usado una habilidad sin usos restantes o ha elegido una habilidad que no tiene equipada.");
            }
        }
        // Sino pos el turno es del personaje 2:
        else {
            menus.mostrarEstadisticasCombate(this.personaje2,2,this.personaje1);
            // Escoger habilidades:
            Habilidad habilidad_escogida = this.menus.mostrarYEscogerHabilidad(pj2_Habilidades_usos_restantes,this.pj1_defensa); // Le paso las habilidades del personaje (clave) y sus usos restantes (valor), asi como la defensa del personaje contrario
            if (habilidad_escogida == null) {
                ataqueBasico(personaje);
                logger.escribirLog("["+ LocalDate.now()+"] INFO: El personaje 2 ha usado la habilidad ataque básico.");
            }
            // Si la habilidad seleccionada se puede usar y no es null:
            else if (habilidadSePuedeUsar(habilidad_escogida, 2)) {
                usarHabilidad(personaje, habilidad_escogida);
                logger.escribirLog("["+ LocalDate.now()+"] INFO: El personaje 2 ha usado la habilidad:"+habilidad_escogida.getNombre());
            }
            // Si no le quedan usos a la habilidad:
            else {
                // ataca por defecto:
                ataqueBasico(personaje);
                logger.escribirLog("["+ LocalDate.now()+"] INFO: El personaje 2 ha usado una habilidad sin usos restantes o ha elegido una habilidad que no tiene equipada.");
            }
        }
    }
}
