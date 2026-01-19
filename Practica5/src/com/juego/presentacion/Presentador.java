package com.juego.presentacion;

import java.util.Scanner;

public class Presentador {
    Scanner s = new Scanner (System.in);
    public Presentador(){
    }
    // Crear metodo menu principal
    public void inicio() {
        System.out.print(
                "1. JUGAR"+"\n" +
                "2. Crear personaje"+"\n" +
                "3. Salir"+
                "\nIntroduzca a continuación su opción: ");
    }
}
