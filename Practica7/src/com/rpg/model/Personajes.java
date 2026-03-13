package com.rpg.model;

import java.util.List;

public class Personajes {
    private String nombre;
    private String raza;
    private Integer nivel;
    private List<String> equipoIds;
    private String nombreCiudad;

    public Personajes(String nombre, String raza, Integer nivel, List<String> equipoIds, String nombreCiudad) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel= nivel;
        this.equipoIds = equipoIds;
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return this.raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getNivel() {
        return this.nivel;
    }
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public List<String> getEquipoIds() {
        return this.equipoIds;
    }
    public void setEquipoIds(List<String> equipoIds) {
        this.equipoIds = equipoIds;
    }

    public String getNombreCiudad() {
        return this.nombreCiudad;
    }
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public String toString() {
        return
                "{ nombre='" + this.nombre + '\'' +
                ", raza='" + this.raza + '\'' +
                ", nivel='" + this.nivel + '\'' +
                ", equipoIds=" + this.equipoIds +
                ", nombreCiudad=" + this.nombreCiudad +
                '}';
    }
}
