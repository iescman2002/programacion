package com.juego.habilidades;

public class DanioLargaDistancia extends EstadisticasHabilidades {

    public DanioLargaDistancia(String nombre, String desc) {
        super(nombre,desc,1); // Se fijan ya los usos que tendrán las habilidades que sean de tipo larga distancia
    }

    // Crear metodo para usar los ataques de larga distancia
    public int atacarLargaDistancia() {
        int dmg = getDanio()*6;
        setUsosActuales(0); // Cuando se usa la habilidad, no se podrá usar más, los usos restantes se quedan a 0
        return dmg;
    }

    // Crear toString que muestre el nombre de la habilidad para verse bien desde el toString de personajes
    @Override
    public String toString() {
        return this.getNombre();
    }
    // Sobrescribir el metodo de la interfaz habilidades para que muestre la información de la habilidad siguiendo la siguiente estructura:
    @Override
    public String infoHabilidad() {
        return this.getNombre() +": "+ this.getDescripcion() +".\n   Realiza: "+ this.getDanio()*6 +" de daño. Usos restantes: "+ this.getUsosActuales() +" / "+ this.getUsosPorDefecto();
    }
}