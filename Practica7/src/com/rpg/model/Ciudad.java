package com.rpg.model;

public class Ciudad {
    // Crear atributos
    private String nombre;
    private String poblacion;
    private String clima;
    private String riesgo;
    // Crear constructor
    public Ciudad(String nombre, String poblacion, String clima, String riesgo) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.clima = clima;
        this.riesgo = riesgo;
    }
    // Metodos Getter y Setter
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return this.poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getClima() {
        return this.clima;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getRiesgo() {
        return this.riesgo;
    }
    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }
}
