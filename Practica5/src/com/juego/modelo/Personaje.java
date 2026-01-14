package com.juego.modelo;

import com.juego.razas.ModificadoresRazas;

public class Personaje {

    // Crear atributos por defecto del personaje
    private String nombre;
    private int vida;
    private int fuerza;
    private int defensa;
    private int inteligencia;
    private int destreza;
    private ModificadoresRazas raza; // Atributo para indicar la raza, se crea una variable (raza) de tipo ModificadoresRaza (que será el padre de los tipos de raza)

    // Crear constructor personaje con los valores por defecto del Personaje
    public Personaje(String nombre, ModificadoresRazas raza) {
        this.nombre = nombre;
        this.vida = 0;
        this.fuerza = 0;
        this.defensa = 0;
        this.inteligencia = 0;
        this.destreza = 0;
        this.raza = raza;
    }
    // Crear Getter y Setter
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public ModificadoresRazas getRaza() {
        return this.raza;
    }
    public void setDestreza(ModificadoresRazas raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", fuerza=" + fuerza +
                ", defensa=" + defensa +
                ", inteligencia=" + inteligencia +
                ", destreza=" + destreza +
                ", raza=" + raza +
                '}';
    }
}