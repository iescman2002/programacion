package com.juego.clases;

import com.juego.habilidades.*;

import java.util.ArrayList;

public class Sacerdote extends StatsClases {
    // Crear constructor Sacerdote
    public Sacerdote () {
        super(95,0,0,3,0); // Solo se le da valor a los bonificadores que cambian, sino varian valen 0
    }
    // Sobrescribir el metodo de obtener las habilidades creada en la clase padre vacía pero con los datos del array ya relleno.
    @Override
    public ArrayList<EstadisticasHabilidades> almacenarHabilidades() {
        // Crear arraylist que devuelve la funcion
        ArrayList<EstadisticasHabilidades> habilidades = new ArrayList<>();
        // Crear habilidades Sacerdote
        Cura h19 = new Cura("Gracia divina","El jugador consume agua bendita."); // Crear habilidad de curación
        DanioCortaDistancia h20 = new DanioCortaDistancia("Ayuda de padre","El jugador reza a dios, dandole poder divino y otorgandole un puñetazo sagrado. "); // Crear habilidad que golpea corta distancia
        DanioLargaDistancia h21 = new DanioLargaDistancia("Confeso de pecados","[REMATE] El jugador devuelve todos los pecados recibidos en la iglesia sobre su rival."); // Crear habilidad que golpea larga distancia

        // Añadir habilidades al array
        habilidades.add(h19);
        habilidades.add(h20);
        habilidades.add(h21);
        return habilidades;
    }
}