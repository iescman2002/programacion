package com.juego.modelo;

public class Combate {

    // Crear constructor combate
    public Combate(){
        inicioCombate();
    }

    // Iniciar combate
    public void inicioCombate(){
        GestorPersonajes g = new GestorPersonajes();
        g.elegirPersonajes();
    }
}