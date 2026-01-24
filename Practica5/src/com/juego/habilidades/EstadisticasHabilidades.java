package com.juego.habilidades;

import com.juego.modelo.Personaje;

public class EstadisticasHabilidades implements Habilidades {
    // Crear atributos de las habilidades
    private String nombre;
    private String descripcion;
    private int danio;
    private int inteligencia;
    private int usosPorDefecto;
    private int usosActuales;

    // Crear constructor de las habilidades
    public EstadisticasHabilidades(String nombre, String desc, int usos) {
        this.nombre = nombre;
        this.descripcion = desc;
        this.danio = 0; // todas las habilidades empiezan quitando 0, el daño se modificará después según el personaje
        this.inteligencia = 0;
        this.usosPorDefecto = usos;
        this.usosActuales = this.usosPorDefecto;
    }

    // Crear getter y setter


    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDanio() {
        return this.danio;
    }
    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getInteligencia() {return this.inteligencia;}
    public void setInteligencia(int inteligencia) {this.inteligencia = inteligencia;}

    public int getUsosPorDefecto() {
        return this.usosPorDefecto;
    }
    public void setUsosPorDefecto(int usosPorDefecto) {
        this.usosPorDefecto = usosPorDefecto;
    }

    public int getUsosActuales() {
        return this.usosActuales;
    }
    public void setUsosActuales(int usosActuales) {
        this.usosActuales = usosActuales;
    }

    // Crear metodo para ajustar el daño en funcion de la fuerza del personaje
    @Override
    public void actualizarDanioHabilidad(Personaje pj) {
        setDanio(pj.getFuerza()); // Se actualiza el daño de la habilidad al daño de la fuerza del personaje.
        setInteligencia(pj.getInteligencia()); // Se actualiza la inteligencia de la habilidad a la que tiene el personaje (es el modificador de curacion).
    }

    // Metodo de la interfaz que indica si se puede usar o no la habilidad (si quedan usos restantes o no)
    @Override
    public Boolean puedeAtacar(){
        if (this.getUsosActuales()>0) {
            return true;
        }
        return false;
    }

    // Metodo de la interfaz Habilidad vacio por defecto que despues se sobrescribe según el tipo de habilidad. Muestra la informacion de la habilidad.
    @Override
    public String infoHabilidad() {
        return "";
    }

    // Metodo interfaz Habilidades
    @Override
    public void golpear(Personaje pj) {
        pj.setVidaActual(pj.getVidaActual()-this.getDanio());
        System.out.print("Has inflingido un total de: "+this.getDanio()+" daño.");
    }

    @Override
    public void atacar(Personaje pj) {
    }
}