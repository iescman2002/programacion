package Vista;

import Dificultad.*;

import java.util.Scanner;

public class MenuInicio {
    // Atrib
    // Constr
    Scanner s= new Scanner(System.in);
    public MenuInicio() {
        System.out.println("Eliga el modo de juego:");
        System.out.println("1: Fácil");
        System.out.println("2: Intermedio");
        System.out.println("3: Dificil");
        int eleccion = s.nextInt();
        switch(eleccion) {
            case 1:
                new ModoFacil();
            case 2:
                new ModoIntermedio();
            case 3:
                new ModoDificil();
            default: System.out.print("Saliendo...");
        }
    }
}
