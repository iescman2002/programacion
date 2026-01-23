package com.juego.modelo;

import com.juego.habilidades.Habilidades;

import java.util.ArrayList;

public class VistaCombate {
    // Crear atributo VistaCombate
    public int contador;

    // Crear constructor VistaCombate
    public VistaCombate() {
        this.contador = 0;
    }

    // Get y set
    public int getContador() {
        return this.contador;
    }
    public void setContador(int contador) {
        this.contador = contador;
    }

    // Metodo de los turnos del jugador (INCOMPLETO)
    public void turno_pj1(Personaje pj1, Personaje pj2) {
        setContador(this.contador+1); // Autoincremento de contador por turnos
        System.out.printf("%1sTurno "+this.contador+"%1s\n","----------------------","----------------------");
        System.out.println("Jugador 1"+ " ("+pj1.getNombre()+") " +"es tu turno: ");
        mostrarEstadoActual(pj1,pj2);
        System.out.println("Habilidades disponibles: ");
        mostrarHabilidades(pj1);
        if (escogerHabilidad(pj1).puedeAtacar() == ) {
            //usarhabilidad
        }
        else {
            System.out.println("No le quedan usos disponibles, use otra habilidad: ");
            escogerHabilidad(pj1);
        }
    }

    // Metodo que muestra el estado actual de ambos personajes.
    public void mostrarEstadoActual(Personaje pj1, Personaje pj2) {
        System.out.printf(pj1.getNombre()+".%2s--->%2s Vida Restante: "+pj1.getVida()+" hp\n","","");
        System.out.printf(pj2.getNombre()+".%2s--->%2s Vida Restante: "+pj2.getVida()+" hp\n","","");
        System.out.println("---------------------------------------------------");
    }

    // Metodo para mostrar las habilidades en el turno correspondiente
    public void mostrarHabilidades(Personaje pj) {
        ArrayList<Habilidades> habilidades = new ArrayList<>(pj.getHabilidades());
        System.out.println("-----------------------");
        for (int i = 0; i <habilidades.size();i++) {
            System.out.println((i+1)+". "+ habilidades.get(i).infoHabilidad()); // infoHabilidad es un metodo creado en la interfaz de habilidades
        }
        System.out.println("------------------------------------------------------------------");
    }

    // Metodo para escoger la habilidad que se va a usar
    public Habilidades escogerHabilidad(Personaje pj) {
        System.out.print("Introduzca la habilidad a usar: ");
        int habilidad = PrecargaDatos.s.nextInt();
        switch (habilidad) {
            case 1:
                return pj.getHabilidades().get(0);  // Si la habilidad introducida es 1, se escoge la habilidad de la posicion 0 de la lista de habilidades (Curar)
            case 2:
                return pj.getHabilidades().get(1);  // Si la habilidad introducida es 2, se escoge la habilidad de la posicion 1 de la lista de habilidades (Daño a corta distancia)
            case 3:
                return pj.getHabilidades().get(2); // Si la habilidad introducida es 3, se escoge la habilidad de la posicion 2 de la lista de habilidades (Daño a larga distancia)
            default:
                return null;
        }
    }
}
