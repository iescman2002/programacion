package com.juego.modelo;

import com.juego.habilidades.Habilidades;

import java.util.ArrayList;

public class VistaCombate {

    // Metodo de los turnos del jugador (INCOMPLETO)
    public void turno(Personaje pj1, Personaje pj2) {
        System.out.println("Jugador 1, es tu turno: ");
        mostrarEstadoActual(pj1,pj2);
        System.out.println("Eliga una habilidad: ");
        mostrarHabilidades(pj1);
    }

    // Metodo que muestra el estado actual de ambos personajes.
    public void mostrarEstadoActual(Personaje pj1, Personaje pj2) {
        System.out.println("----------------------");

        System.out.println("----------------------");
    }

    // Metodo para mostrar las habilidades en el turno correspondiente
    public void mostrarHabilidades(Personaje pj) {
        ArrayList<Habilidades> habilidades = new ArrayList<>(pj.getHabilidades());
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i <habilidades.size();i++) {
            System.out.println((i+1)+". "+ habilidades.get(i).infoHabilidad()); // infoHabilidad es un metodo creado en la interfaz de habilidades
        }
        System.out.println("------------------------------------------------------------------");
    }
}
