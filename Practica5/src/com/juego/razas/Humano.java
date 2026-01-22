package com.juego.razas;

public class Humano extends ModificadoresRazas {
    // Crear constructor con los atributos ya hechos
    public Humano() {
        super(100, 5, 2, 5, 5);
    }
    // Crear toString que muestre el nombre de la raza para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return "Humano";
    }
}