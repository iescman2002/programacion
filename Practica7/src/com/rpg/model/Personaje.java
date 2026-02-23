package com.rpg.model;

import java.util.List;

public class Personaje {
    private String nombre;
    private String raza;
    private String nivel;
    private List<String> equipoIds;

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

    public String getNivel() {
        return this.nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<String> getEquipoIds() {
        return this.equipoIds;
    }
    public void setEquipoIds(List<String> equipoIds) {
        this.equipoIds = equipoIds;
    }
}
