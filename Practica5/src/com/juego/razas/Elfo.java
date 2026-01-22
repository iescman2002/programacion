package com.juego.razas;

public class Elfo extends ModificadoresRazas {
    // Crear constructor con los atributos ya hechos
    public Elfo() {
        super(90, 4, 3, 6, 7);
    }
    // Crear toString que muestre el nombre de la raza para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return "Elfo";
    }
}