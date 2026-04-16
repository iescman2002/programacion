import rpg.dao.*;

import rpg.exception.DatoInvalidoException;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.LimiteHabilidadesException;
import rpg.exception.RecursoNoEncontradoException;
import rpg.model.*;
import rpg.ui.Menus;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, FondosInsuficientesException, RecursoNoEncontradoException, DatoInvalidoException, LimiteHabilidadesException {

        Menus menu = new Menus();
        menu.cargarMenuPrincipal();
    }
}