package com.juego.habilidades;

public class DanioCortaDistancia extends EstadisticasHabilidades {

    public DanioCortaDistancia(String nombre, String desc) {
        super(nombre,desc,5); // Se fijan ya los usos que tendrán las habilidades que sean de tipo corta distancia
    }

    // Crear metodo para usar los ataques de corta distancia -> Devuelve la vida que quita
    public int atacarCortaDistancia() {
        int dmg = getDanio()*3;
        setUsosActuales(getUsosActuales()-1); // Cuando se usa la habilidad, se resta 1 a los usos actuales que tiene la habilidad
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
        return this.getNombre() +": "+ this.getDescripcion() +".\n   Realiza: "+ this.getDanio()*3 +" de daño. Usos restantes: "+ this.getUsosActuales() +" / "+ this.getUsosPorDefecto();
    }
}