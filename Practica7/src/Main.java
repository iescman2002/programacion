import com.rpg.handler.*;
import com.rpg.services.GestionMundo;

public class Main {
    public static void main(String[] args) throws RecursoNoEncontradoException, DatoInvalidoException, ValidadorDeBiomasException {
        GestionMundo gm = new GestionMundo();
        gm.crearPersonaje();
        gm.guardarCambios();
        gm.informeFinal();
    }
}