package com.rpg.model;

public class Item {
    private String id;
    private String nombre;
    private String tipo;
    private Integer valor;

    public Item(String id, String nombre, String tipo, Integer valor) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValor() {
        return this.valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
}