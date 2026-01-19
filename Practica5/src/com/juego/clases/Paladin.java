package com.juego.clases;

import com.juego.habilidades.*;

import java.util.ArrayList;

public class Paladin extends StatsClases {
    // Crear constructor Paladin
    public Paladin () {
        super(115,2,0,1,0); // Solo se le da valor a los bonificadores que cambian, sino varian valen 0
    }
    // Sobrescribir el metodo de obtener las habilidades creada en la clase padre vacía pero con los datos del array ya relleno.
    @Override
    public ArrayList<EstadisticasHabilidades> almacenarHabilidades() {
        // Crear arraylist que devuelve la funcion
        ArrayList<EstadisticasHabilidades> habilidades = new ArrayList<>();
        // Crear habilidades Paladin
        Cura h22 = new Cura("Auxilio","El jugador llama a sus sirvientes, que se encagarán de curarle."); // Crear habilidad de curación
        DanioCortaDistancia h23 = new DanioCortaDistancia("Embestida real","El jugador embiste con su caballo ferozmente sobre el rival."); // Crear habilidad que golpea corta distancia
        DanioLargaDistancia h24 = new DanioLargaDistancia("Condena final","[REMATE] El jugador condena frente al pueblo al rival, siendo golpeado por todos los miembros de la realeza."); // Crear habilidad que golpea larga distancia

        // Añadir habilidades al array
        habilidades.add(h22);
        habilidades.add(h23);
        habilidades.add(h24);
        return habilidades;
    }
}
