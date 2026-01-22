package com.juego.clases;

import com.juego.habilidades.*;

import java.util.ArrayList;

public class Bardo extends StatsClases {
    // Crear constructor Bardo
    public Bardo () {
        super(90,0,0,3,0); // Solo se le da valor a los bonificadores que cambian, sino varian valen 0
    }
    // Sobrescribir el metodo de obtener las habilidades creada en la clase padre vacía pero con los datos del array ya relleno.
    @Override
    public ArrayList<EstadisticasHabilidades> almacenarHabilidades() {
        // Crear arraylist que devuelve la funcion
        ArrayList<EstadisticasHabilidades> habilidades = new ArrayList<>();

        // Crear habilidades Bardo
        Cura h7 = new Cura("Tocar Arpa","El jugador toca una melodia sanadora."); // Crear habilidad de curación
        DanioCortaDistancia h8 = new DanioCortaDistancia("Cuerda personal","El jugador golpea al enemigo simulando como si fueran las cuerdas su arpa."); // Crear habilidad que golpea corta distancia
        DanioLargaDistancia h9 = new DanioLargaDistancia("Melodia Siniestra","[REMATE] El jugador toca una melodia capaz de lastimar fuertemente al rival."); // Crear habilidad que golpea larga distancia

        // Añadir habilidades al array
        habilidades.add(h7);
        habilidades.add(h8);
        habilidades.add(h9);
        return habilidades;
    }
    // Crear toString que muestre el nombre de la Clase para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return "Bardo";
    }
}