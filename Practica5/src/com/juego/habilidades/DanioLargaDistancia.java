package com.juego.habilidades;

import com.juego.modelo.Personaje;

public class DanioLargaDistancia extends EstadisticasHabilidades {

    public DanioLargaDistancia(String nombre, String desc) {
        super(nombre,desc,1); // Se fijan ya los usos que tendrán las habilidades que sean de tipo larga distancia
    }
    // Crear metodo para usar los ataques de larga distancia
    public int atacarLargaDistancia(Personaje pj) {
        int dmg = pj.getFuerza()*4;
        setUsosActuales(0); // Cuando se usa la habilidad, no se podrá usar más, los usos restantes se quedan a 0
        return dmg; // Devuelve el daño que hará la habilidad, que será igual que la suma del daño de la raza y del daño de la clase (que son los valores de fuerza del personaje)
    }
}