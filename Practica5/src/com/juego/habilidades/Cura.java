package com.juego.habilidades;

import com.juego.modelo.Personaje;

public class Cura extends EstadisticasHabilidades {

    // Crear constructor curacion
    public Cura(String nombre, String desc) {
        super(nombre,desc,3); // Se fijan ya los usos que tendrán las habilidades que sean de tipo larga distancia
    }

    // Crear metodo para usar la curacion
    @Override
    public void atacar(Personaje pj) {                  // En la entrada de pj en Cura se introduce el personaje como si mismo.
        int cura = getInteligencia()*4;
        setUsosActuales(getUsosActuales()-1);           // Cuando se usa la habilidad, se resta 1 a los usos actuales que tiene la habilidad
        pj.setVidaActual(pj.getVidaActual()+cura);      // Se establece lo que se cura el jugador - el daño infligido
        if (pj.getVidaActual()>pj.getVida()) {          // Si al curarse, la vida actual supera la vida maxima, se establece la vida actual igual a la vida maxima
            pj.setVidaActual(pj.getVida());
        }
        System.out.println("Te has curado: "+cura+" de vida. Tu vida actual ahora es de: "+pj.getVidaActual());
    }

    // Crear toString que muestre el nombre de la habilidad para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return this.getNombre();
    }
    // Sobrescribir el metodo de la interfaz habilidades para que muestre la información de la habilidad siguiendo la siguiente estructura:
    @Override
    public String infoHabilidad(){
        return this.getNombre() +": "+ this.getDescripcion() +"\n║   Realiza: "+ this.getInteligencia()*4 +" de curación. Usos restantes: "+ this.getUsosActuales() +" / "+ this.getUsosPorDefecto();
    }
}
