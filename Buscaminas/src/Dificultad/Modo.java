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

    public int getAltura() {
        return this.altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAnchura() {
        return this.anchura;
    }
    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public Casilla[][] getCasillas() {
        return this.casillas;
    }
    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public int getBanderas() {
        return this.banderas;
    }
    public void setBanderas(int banderas) {
        this.banderas = banderas;
    }

    public int getBombas() {
        return this.bombas;
    }
    public void setBombas(int bombas) {
        this.bombas = bombas;
    }
}