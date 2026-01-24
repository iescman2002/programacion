package com.juego.modelo;

import com.juego.clases.StatsClases;
import com.juego.habilidades.EstadisticasHabilidades;
import com.juego.razas.ModificadoresRazas;

import java.util.ArrayList;

public class Personaje {

    // Crear atributos por defecto del personaje
    private String nombre;
    private int vida;
    private int vidaActual;
    private int fuerza;
    private int defensa;
    private int inteligencia;
    private int destreza;
    private ModificadoresRazas raza; // Atributo para indicar la raza, se crea una variable (raza) de tipo ModificadoresRaza (que será el padre de los tipos de raza)
    private StatsClases clase;  // Atributo para indicar la clase, se crea una variable (raza) de tipo StatsClase (que será el padre de los tipos de clase)
    private ArrayList<EstadisticasHabilidades> habilidades; // Crear lista del padre habilidades para guardar las habilidades que tiene el personaje

    // Crear constructor personaje con los valores por defecto del Personaje
    public Personaje(String nombre, ModificadoresRazas raza, StatsClases clase) {
        this.nombre = nombre;
        this.vida = 0;
        this.vidaActual = this.vida;
        this.fuerza = 0;
        this.defensa = 0;
        this.inteligencia = 0;
        this.destreza = 0;
        this.raza = raza;
        this.clase = clase;
        this.habilidades = new ArrayList<>();
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

    public int getVidaActual(){
        return this.vidaActual;
    }
    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
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
    public void setRaza(ModificadoresRazas raza) {
        this.raza = raza;
    }

    public StatsClases getClase() {
        return this.clase;
    }
    public void setClase(StatsClases clase) {
        this.clase = clase;
    }

    public ArrayList<EstadisticasHabilidades> getHabilidades() {
        return this.habilidades;
    }
    public void setHabilidades(ArrayList<EstadisticasHabilidades> habilidades) {
        this.habilidades = habilidades;
    }

    // Metodo para sumar las bonificaciones de Razas al personaje
    public void actualizarStatsSegunRaza() {
        setVida(raza.getVida());
        setFuerza(raza.getFuerza());
        setDefensa(raza.getDefensa());
        setInteligencia(raza.getInteligencia());
        setDestreza(raza.getDestreza());
        setVidaActual(raza.getVida());
    }
    // Metodo para sumar las bonificaciones de las clases a las stats del personaje una vez actualizado los de la raza
    public void anadirStatsClase() {
        setVida(getVida()+clase.getVida());
        setFuerza(getFuerza()+clase.getFuerza());
        setDefensa(getDefensa()+clase.getDefensa());
        setInteligencia(getInteligencia()+clase.getInteligencia());
        setDestreza(getDestreza()+clase.getDestreza());
        setVidaActual(getVidaActual()+clase.getVida());
    }
    // Metodo para agregar las habilidades de la clase a la lista de habilidades en personaje
    public void agregarHabilidad() {
        for (EstadisticasHabilidades habilidad : clase.almacenarHabilidades()) { // Bucle for each que recorre cada habilidad guardada en el array de la clase asignada al personaje
            this.habilidades.add(habilidad); // Relleno el arraylist habilidades de personaje con los objetos habilidades de las clases.
        }
    }

    @Override
    public String toString() {
        return
                this.nombre+
                       "\n╠═════════════════════════════════════╣\n"+
                "║ " +"Vida: "+this.vida+
                " ║ " +"Fuerza: "+this.fuerza+
                " ║ " +"Defensa: "+this.defensa +"  ║\n"+
                "║ " +"Inteli: "+this.inteligencia+
                " ║ " +"Destre: "+ this.destreza +" ║"+
                "\n║ " +"Raza: "+ this.getRaza()+
                "\n║ " +"Clase: " + this.getClase()+
                        "\n╠═════════════════════════════════════╣\n"+
                "║ " + "Habilidad 1: "+this.habilidades.get(0)+
                "\n║ " +"Habilidad 2: "+this.habilidades.get(1)+
                "\n║ " +"Habilidad 3: "+this.habilidades.get(2);
    }
}