package com.juego.clases;

import com.juego.habilidades.Cura;
import com.juego.habilidades.DanioCortaDistancia;
import com.juego.habilidades.DanioLargaDistancia;

public class Guerrero extends StatsClases {
    // Crear constructor guerrero
    public Guerrero () {
        super(120,3,2,0,0); // Solo se le da valor a los bonificadores que cambian, sino varian valen 0
    }
    // Crear habilidades del guerrero
    Cura h1 = new Cura("Tomar pocion","El jugador bebe una poción que le regenera vida"); // Crear habilidad de curación
    DanioCortaDistancia h2 = new DanioCortaDistancia("Espadazo","El jugador usa su espada para golpear al enemigo"); // Crear habilidad que golpea corta distancia
    DanioLargaDistancia h3 = new DanioLargaDistancia("Usar Arco","[REMATE] El jugador dispara multiples flechas para golpear al enemigo"); // Crear habilidad que golpea larga distancia
}