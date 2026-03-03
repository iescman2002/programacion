package com.rpg.model;

public class Ciudades {
    // Crear atributos
    private String nombre;
    private Integer poblacion;
    private String clima;
    private Integer riesgo;
    // Crear constructor
    public Ciudades(String nombre, Integer poblacion, String clima, Integer riesgo) {
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

    public Integer getPoblacion() {
        return this.poblacion;
    }
    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    public String getClima() {
        return this.clima;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }

    public Integer getRiesgo() {
        return this.riesgo;
    }
    public void setRiesgo(Integer riesgo) {
        this.riesgo = riesgo;
    }
}
