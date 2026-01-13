package com.juego.razas;

public class ModificadoresRazas {
    // Atributos y sus modificadores que tendrán en común cada raza.
    private int vida;
    private int fuerza;
    private int defensa;
    private int inteligencia;
    private int destreza;

    // Crear Constructor
    public ModificadoresRazas(int vida, int fuerza, int defensa, int inteligencia, int destreza) {
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.inteligencia = inteligencia;
        this.destreza = destreza;
    }

    // Construir Getter y Setter
    public int getVida() {
        return this.vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return this.fuerza;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return this.defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getInteligencia() {
        return this.inteligencia;
    }
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDestreza() {
        return this.destreza;
    }
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
}