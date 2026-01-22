package com.juego.razas;

public class Enano extends ModificadoresRazas {
    // Crear constructor con los atributos ya hechos
    public Enano() {
        super(110, 7, 3, 4, 4);
    }
    // Crear toString que muestre el nombre de la raza para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return "Enano";
    }
}