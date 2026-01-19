package com.juego.clases;

import com.juego.habilidades.*;

import java.util.ArrayList;

public class Mago extends StatsClases {
    // Crear constructor Mago
    public Mago() {
        super(90, 0, -1, 3, 0); // Solo se le da valor a los bonificadores que cambian, sino varian valen 0
    }
    // Sobrescribir el metodo de obtener las habilidades creada en la clase padre vacía pero con los datos del array ya relleno.
    @Override
    public ArrayList<EstadisticasHabilidades> almacenarHabilidades() {
        // Crear arraylist que devuelve la funcion
        ArrayList<EstadisticasHabilidades> habilidades = new ArrayList<>();
        // Crear habilidades Mago
        Cura h10 = new Cura("Sanacion","El jugador realiza un hechizo para curarse."); // Crear habilidad de curación
        DanioCortaDistancia h11 = new DanioCortaDistancia("Espada mágica","El jugador golpea al rival con una espada envuelta en magia."); // Crear habilidad que golpea corta distancia
        DanioLargaDistancia h12 = new DanioLargaDistancia("Bola de fuego","[REMATE] El jugador lanza una bola de fuego abrasadora al rival."); // Crear habilidad que golpea larga distancia

        // Añadir habilidades al array
        habilidades.add(h10);
        habilidades.add(h11);
        habilidades.add(h12);
        return habilidades;
    }
}