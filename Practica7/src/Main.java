import com.rpg.services.GestionMundo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        GestionMundo gm = new GestionMundo();

        // Probar que se pueden agregar personajes
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca el nombre del personaje: ");
        String n = s.next();
        System.out.print("Introduzca la raza del personaje: ");
        String r = s.next();
        System.out.print("Introduzca el id del equipo del personaje: ");
        List<String> id = new ArrayList<>();
        id.add(s.next());
        gm.crearPersonaje(n,r,id);
        gm.guardarCambios();
    }
}