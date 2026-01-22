package com.juego.clases;

import com.juego.habilidades.*;

import java.util.ArrayList;

public class Monje extends StatsClases {
    // Crear constructor Monje
    public Monje () {
        super(110,2,1,0,1); // Solo se le da valor a los bonificadores que cambian, sino varian valen 0
    }
    // Sobrescribir el metodo de obtener las habilidades creada en la clase padre vacía pero con los datos del array ya relleno.
    @Override
    public ArrayList<EstadisticasHabilidades> almacenarHabilidades() {
        // Crear arraylist que devuelve la funcion
        ArrayList<EstadisticasHabilidades> habilidades = new ArrayList<>();
        // Crear habilidades Monje
        Cura h13 = new Cura("Meditación","El jugador se pone a meditar, alcanzando tanta concentración que se acaba curando."); // Crear habilidad de curación
        DanioCortaDistancia h14 = new DanioCortaDistancia("Puñetazo mistico","El jugador golpea al enemigo con un puñetazo fuerte."); // Crear habilidad que golpea corta distancia
        DanioLargaDistancia h15 = new DanioLargaDistancia("Concentracion astral","[REMATE] El jugador golpea al rival desde el cielo mediante su meditacion."); // Crear habilidad que golpea larga distancia

        // Añadir habilidades al array
        habilidades.add(h13);
        habilidades.add(h14);
        habilidades.add(h15);
        return habilidades;
    }
    // Crear toString que muestre el nombre de la Clase para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return "Monje";
    }
}