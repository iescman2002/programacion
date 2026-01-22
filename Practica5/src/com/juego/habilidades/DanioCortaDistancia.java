package com.juego.habilidades;

import com.juego.modelo.Personaje;

public class DanioCortaDistancia extends EstadisticasHabilidades {

    public DanioCortaDistancia(String nombre, String desc) {
        super(nombre,desc,5); // Se fijan ya los usos que tendrán las habilidades que sean de tipo corta distancia
    }

    // Crear metodo para usar los ataques de corta distancia
    public int atacarCortaDistancia(Personaje pj) {
        int dmg = pj.getFuerza();
        setUsosActuales(getUsosActuales()-1); // Cuando se usa la habilidad, se resta 1 a los usos actuales que tiene la habilidad
        return dmg; // Devuelve el daño que hará la habilidad, que será igual que la suma del daño de la raza y del daño de la clase (que son los valores de fuerza del personaje)
    }
    // Crear toString que muestre el nombre de la habilidad para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return this.getNombre();
    }
}