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
    Cura h1 = new Cura("Tomar pocion","El jugador bebe una poción que le regenera vida",15); // Los guerreros siempre se curaran 15 independientemente de la raza
    DanioCortaDistancia h2 = new DanioCortaDistancia("Espadazo","El jugador usa su espada para golpear al enemigo",getFuerza());
    DanioLargaDistancia h3 = new DanioLargaDistancia("Usar Arco","[REMATE] El jugador dispara multiples flechas para golpear al enemigo",getFuerza()*3);
}