package com.juego.habilidades;

public class EstadisticasHabilidades implements Habilidades {
    // Crear atributos de las habilidades
    private String nombre;
    private String descripcion;
    private int danio;
    private int usosPorDefecto;
    private int usosActuales;

    // Crear constructor de las habilidades
    public EstadisticasHabilidades(String nombre, String desc, int dmg, int usos) {
        this.nombre = nombre;
        this.descripcion = desc;
        this.danio = dmg;
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

    public int GetDanio() {
        return this.danio;
    }
    public void setDanio(int danio) {
        this.danio = danio;
    }

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

    // Metodo interfaz Habilidades
    @Override
    public String infoHabilidad(){ // Devuelve si se usa ahora o no la habilidad
        String info = this.nombre+": "+this.descripcion+".\nRealiza "+this.danio+"de danio, y lo puedes usar hasta un máximo de"+this.usosPorDefecto+" veces en toda la partida.";
        return info;
    }
    public void golpear() {
    }
}