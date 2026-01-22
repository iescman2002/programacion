package com.juego.clases;

import com.juego.habilidades.*;

import java.util.ArrayList;

public class Guerrero extends StatsClases {
    // Crear constructor guerrero
    public Guerrero () {
        super(120,3,2,0,0); // Solo se le da valor a los bonificadores que cambian, sino varian valen 0
    }
    // Sobrescribir el metodo de obtener las habilidades creada en la clase padre vacía pero con los datos del array ya relleno.
    @Override
    public ArrayList<EstadisticasHabilidades> almacenarHabilidades() {
        // Crear arraylist que devuelve la funcion
        ArrayList<EstadisticasHabilidades> habilidades = new ArrayList<>();

        // Crear habilidades guerrero
        Cura h1 = new Cura("Tomar pocion","El jugador bebe una poción que le regenera vida"); // Crear habilidad de curación
        DanioCortaDistancia h2 = new DanioCortaDistancia("Espadazo","El jugador usa su espada para golpear al enemigo"); // Crear habilidad que golpea corta distancia
        DanioLargaDistancia h3 = new DanioLargaDistancia("Usar Arco","[REMATE] El jugador dispara multiples flechas para golpear al enemigo"); // Crear habilidad que golpea larga distancia

        // Añadir habilidades al array
        habilidades.add(h1);
        habilidades.add(h2);
        habilidades.add(h3);
        return habilidades;
    }
    // Crear toString que muestre el nombre de la Clase para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return "Guerrero";
    }
}