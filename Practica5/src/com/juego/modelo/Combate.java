package com.juego.modelo;

public class Combate {
    private Personaje pj1;
    private Personaje pj2;
    // Crear constructor combate
    public Combate(){
        inicioCombate();
    }
    // Establecer getter y setter de los personajes que juegan el combate
    public Personaje getPj1() {
        return this.pj1;
    }
    public Personaje getPj2() {
        return this.pj2;
    }

    public void setPj1(Personaje pj1) {
        this.pj1 = pj1;
    }
    public void setPj2(Personaje pj2) {
        this.pj2 = pj2;
    }

    // Iniciar combate
    public void inicioCombate(){
        GestorPersonajes g = new GestorPersonajes();
        Personaje[] personajesJuegan = g.elegirPersonajes(); // Llamar a la funcion para elegir los personajes que lucharan y asignarlos a un array para poder acceder a ellos
        // Asignar los personajes elegidos a los personajes de combate
        setPj1(personajesJuegan[0]);
        setPj2(personajesJuegan[1]);
    }
}