package Dificultad;

import Utils.Casilla;

import java.util.List;

public class Modo {
    // Cada 1*1 es una casilla
    private int altura;
    private int anchura;
    private Casilla[][] casillas;
    private int banderas;
    private int bombas;

    public Modo(int altura, int anchura,int bombas) {
        this.altura = altura;
        this.anchura = anchura;
        this.casillas = new Casilla[altura][anchura];
        this.bombas = bombas;
        this.banderas = this.bombas;
    }
}