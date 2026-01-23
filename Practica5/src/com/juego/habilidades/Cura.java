package com.juego.habilidades;

public class Cura extends EstadisticasHabilidades {

    // Crear constructor curacion
    public Cura(String nombre, String desc) {
        super(nombre,desc,3); // Se fijan ya los usos que tendrán las habilidades que sean de tipo larga distancia
    }

    // Crear metodo para usar la curacion
    /*@Override
    public int atacar() {           // En este metodo si hay que introducir personaje para poder acceder al atributo de inteligencia.
        int cura = getInteligencia()*4;
        setUsosActuales(getUsosActuales()-1);   // Cuando se usa la habilidad, se resta 1 a los usos actuales que tiene la habilidad
        return  cura;
    }*/

    // Crear toString que muestre el nombre de la habilidad para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return this.getNombre();
    }
    // Sobrescribir el metodo de la interfaz habilidades para que muestre la información de la habilidad siguiendo la siguiente estructura:
    @Override
    public String infoHabilidad(){
        return this.getNombre() +": "+ this.getDescripcion() +".\n   Realiza: "+ this.getInteligencia()*4 +" de curación. Usos restantes: "+ this.getUsosActuales() +" / "+ this.getUsosPorDefecto();
    }
}
