package com.juego.clases;

import com.juego.habilidades.*;

import java.util.ArrayList;

public class Picaro extends StatsClases {
    // Crear constructor Picaro
    public Picaro () {
        super(105,0,-1,0, 3); // Solo se le da valor a los bonificadores que cambian, sino varian valen 0
    }
    // Sobrescribir el metodo de obtener las habilidades creada en la clase padre vacía pero con los datos del array ya relleno.
    @Override
    public ArrayList<EstadisticasHabilidades> almacenarHabilidades() {
        // Crear arraylist que devuelve la funcion
        ArrayList<EstadisticasHabilidades> habilidades = new ArrayList<>();
        // Crear habilidades Picaro
        Cura h16 = new Cura("Pocion de bolsillo","El jugador consume una pequeña pocion curacion que tenia en el bolsillo."); // Crear habilidad de curación
        DanioCortaDistancia h17 = new DanioCortaDistancia("Dagas afiladas","El jugador golpea sigilosamente al enemigo con sus dagas."); // Crear habilidad que golpea corta distancia
        DanioLargaDistancia h18 = new DanioLargaDistancia("Humo toxico","[REMATE] El jugador arroja una bomba de humo, acercandose sigilosamente al personaje y arrojandole herridas."); // Crear habilidad que golpea larga distancia

        // Añadir habilidades al array
        habilidades.add(h16);
        habilidades.add(h17);
        habilidades.add(h18);
        return habilidades;
    }
    // Crear toString que muestre el nombre de la Clase para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return "Picaro";
    }
}