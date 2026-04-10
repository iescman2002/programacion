package rpg.ui;

import java.util.Scanner;

public class Menus {

    Scanner s = new Scanner(System.in);
    public Menus() {
        cargarMenuPrincipal();
    }

    private void cargarMenuPrincipal(){
        System.out.println("¡Bienvenido al XPG Guild Master!");
        System.out.println("A continuación, indique que opción deseas acceder:");
        System.out.println("1. Crear personaje.");
        System.out.println("2. [SOON].");
        System.out.println("3. [SOON].");
        System.out.println("--------------------------------");

        int opcion = s.nextInt();
        switch (opcion) {
            case 1:
                //new crearPersonaje();
                break;
            default:
                System.out.print("Saliendo...");
                break;
        }
    }
}