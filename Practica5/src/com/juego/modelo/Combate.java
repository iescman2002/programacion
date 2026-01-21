package com.juego.modelo;

public class Combate {

    // Crear constructor combate
    public Combate(){
        inicioCombate();
    }

    // Iniciar combate
    public void inicioCombate(){
        GestorPersonajes g = new GestorPersonajes();
        System.out.println("Jugador 1, elige tu personaje: ");
        g.mostrarPersonajes();
    }
}
