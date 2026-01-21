package com.juego.modelo;

import java.util.Scanner;

public class Combate {

    // Crear constructor combate
    public Combate(){
        inicioCombate();
    }

    // Iniciar combate
    public void inicioCombate(){
        GestorPersonajes g = new GestorPersonajes();
        System.out.print("Jugador 1, elige tu personaje: ");
        g.mostrarPersonajes();
    }
}
