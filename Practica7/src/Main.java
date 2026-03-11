import com.rpg.handler.*;
import com.rpg.services.GestionMundo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RecursoNoEncontradoException, DatoInvalidoException, FormatoInvalidoException {
        GestionMundo gm = new GestionMundo();
        gm.guardarCambios();
        gm.informeFinal();
    }
}