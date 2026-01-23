package com.juego.habilidades;

import com.juego.modelo.Personaje;

public interface Habilidades {
    String infoHabilidad (); // Muestra el contenido de la habilidad (similar a ToString)
    void golpear(); // Golpea al enemigo haciendo el daño minimo posible pero sin consumir usos
    void actualizarDanioHabilidad(Personaje pj);
    void atacar(Personaje pj); // Ataca al enemigo
    Boolean puedeAtacar(); // Si puede o no atacar (Si quedan usos restantes para usar la habilidad)
}
