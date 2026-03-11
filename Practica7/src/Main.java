import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.services.GestionMundo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RecursoNoEncontradoException, DatoInvalidoException {
        GestionMundo gm = new GestionMundo();

        // Probar que se pueden agregar personajes
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca el nombre del personaje: ");
        String no = s.next();
        System.out.print("Introduzca la raza del personaje: ");
        String r = s.next();
        System.out.print("Introduzca el nivel del personaje: ");
        Integer ni = s.nextInt();
        System.out.print("Introduzca el id del equipo del personaje: ");
        List<String> id = new ArrayList<>();
        id.add(s.next());
        gm.crearPersonaje(no,r,ni,id);
        gm.guardarCambios();
        gm.informeFinal();
    }
}