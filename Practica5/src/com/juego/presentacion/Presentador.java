package com.juego.presentacion;

import com.juego.modelo.Combate;
import com.juego.modelo.GestorPersonajes;

import java.util.Scanner;

public class Presentador {
    Scanner s = new Scanner (System.in);
    public Presentador(){
        inicio();
    }
    // Crear metodo menu principal
    public void inicio() {
        System.out.print(
                "1. Jugar"+"\n" +
                "2. Crear personaje"+"\n" +
                "3. Salir"+
                "\nIntroduzca a continuación su opción: ");
        int opcion = s.nextInt();
        switch (opcion) {
            case 1:
                new Combate();
                break;
            case 2:
                new GestorPersonajes();
                break;
            case 3:
                System.out.print("Saliendo...");
                break;
        }
    }
}
