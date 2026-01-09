package com.juego.razas;

public class EstadisticasBase {

    // CREACION ATRIBUTOS EN COMUN DE LAS RAZAS
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vida;

    // CONSTRUCTOR
    public EstadisticasBase (int str, int intel, int destr, int hp) {
        this.fuerza = str;
        this.inteligencia = intel;
        this.destreza = destr;
        this.vida = hp;
    }

    // GETTER Y SETTER DE LAS ESTADISTICAS
    public int getInteligencia() {
        return this.inteligencia;
    }
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getFuerza() {
        return this.fuerza;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDestreza() {
        return this.destreza;
    }
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getVida() {
        return this.vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
}