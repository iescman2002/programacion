package com.juego.habilidades;

public class EstadisticasHabilidades implements Habilidades { // Estadisticas padre de las habilidades, atributos que tienen todos en conjunto

    // Crear atributos de las habilidades
    private int danio;
    private int usosPorDefecto;
    private int usosActuales;

    // Crear constructor de las habilidades
    public EstadisticasHabilidades (int dmg, int usos) {
        this.danio = dmg;
        this.usosPorDefecto = usos;
        this.usosActuales = this.usosPorDefecto;
    }

    // Crear getter y setter

    public int getDanio() {
        return this.danio;
    }
    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getUsos() {
        return this.usosPorDefecto;
    }
    public void setUsos(int usos) {
        this.usosPorDefecto = usos;
    }

    public int getUsosActuales() {
        return this.usosActuales;
    }
    public void setUsosActuales(int usosActuales) {
        this.usosActuales = usosActuales;
    }
}