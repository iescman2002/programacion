package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.exception.DatoInvalidoException;
import rpg.exception.LimiteHabilidadesException;
import rpg.exception.RecursoNoEncontradoException;
import rpg.model.Personaje;
import rpg.ui.Menus;

import java.sql.SQLException;
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
    }
}
