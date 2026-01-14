package com.juego.modelo;

import com.juego.clases.StatsClases;
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
    private StatsClases clase;

    // Crear constructor personaje con los valores por defecto del Personaje
    public Personaje(String nombre, ModificadoresRazas raza, StatsClases clase) {
        this.nombre = nombre;
        this.vida = 0;
        this.fuerza = 0;
        this.defensa = 0;
        this.inteligencia = 0;
        this.destreza = 0;
        this.raza = raza;
        this.clase = clase;
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

    public StatsClases getClase() {
        return this.clase;
    }
    public void setClase(StatsClases clase) {
        this.clase = clase;
    }

    // Metodo para sumar las bonificaciones de Razas al personaje
    public void actualizarStatsSegunRaza() {
        setVida(raza.getVida());
        setFuerza(raza.getFuerza());
        setDefensa(raza.getDefensa());
        setInteligencia(raza.getInteligencia());
        setDestreza(raza.getDestreza());
    }
    // Metodo para sumar las bonificaciones de las clases a las stats del personaje una vez actualizado los de la raza
    public void AnadirStatsClase() {
        setVida(getVida()+clase.getVida());
        setFuerza(getFuerza()+clase.getFuerza());
        setDefensa(getDefensa()+clase.getDefensa());
        setInteligencia(getInteligencia()+clase.getInteligencia());
        setDestreza(getDestreza()+clase.getDestreza());
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
                ", clase=" + clase +
                '}';
    }
}