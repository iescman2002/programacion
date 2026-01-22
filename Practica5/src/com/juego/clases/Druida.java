package com.juego.clases;

import com.juego.habilidades.*;

import java.util.ArrayList;

public class Druida extends StatsClases {
    // Crear constructor Druida
    public Druida () {
        super(100, 2, 0, 1, 0); // Solo se le da valor a los bonificadores que cambian, sino varian valen 0
    }
    // Sobrescribir el metodo de obtener las habilidades creada en la clase padre vacía pero con los datos del array ya relleno.
    @Override
    public ArrayList<EstadisticasHabilidades> almacenarHabilidades() {
        // Crear arraylist que devuelve la funcion
        ArrayList<EstadisticasHabilidades> habilidades = new ArrayList<>();

        // Crear habilidades Druida
        Cura h4 = new Cura("Consumir seta alucinogena","El jugador consume una seta con efectos curativos."); // Crear habilidad de curación
        DanioCortaDistancia h5 = new DanioCortaDistancia("Bastonazo","El jugador golpea con su baston al enemigo."); // Crear habilidad que golpea corta distancia
        DanioLargaDistancia h6 = new DanioLargaDistancia("Transformacion letal","[REMATE] El jugador convierte al rival en gato y le arroja puas, provocando multiples daños."); // Crear habilidad que golpea larga distancia

        // Añadir habilidades al array
        habilidades.add(h4);
        habilidades.add(h5);
        habilidades.add(h6);
        return habilidades;
    }
    // Crear toString que muestre el nombre de la Clase para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return "Druida";
    }
}
