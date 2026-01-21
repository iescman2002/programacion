package com.juego.presentacion;

import com.juego.modelo.Combate;
import com.juego.modelo.GestorPersonajes;
import com.juego.modelo.PrecargaDatos;

public class Presentador {
    public Presentador(){
        new PrecargaDatos(); // Precargar los datos al iniciar el presentador
        inicio();
    }
    // Crear metodo menu principal
    public void inicio() {
        System.out.print(
                "1. Jugar"+"\n" +
                "2. Crear personaje"+"\n" +
                "3. Salir"+
                "\nIntroduzca a continuación su opción: ");
        int opcion = PrecargaDatos.s.nextInt(); // Se llama al Scanner creado en precarga datos
        switch (opcion) {
            case 1:
                new Combate();
                break;
            case 2:
                new GestorPersonajes().menuCrearPersonaje();
                break;
            case 3:
                System.out.print("Saliendo...");
                break;
        }
    }
}
