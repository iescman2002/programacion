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
        // Empezar el combate entre los personajes seleccionados
        empezarPelea();
        // Muestra el resultado de la batalla
        new VistaCombate().resultado(this,pj1, pj2);
    }

    // Metodo que ejecuta el principio y el fin del combate.
    public void empezarPelea() {
            VistaCombate vc = new VistaCombate();
        while ((pj1.getVidaActual()>0) && (pj2.getVidaActual()>0)) { // Se ejecuta el bucle constantemente hasta que la vida de uno baje a 0.
            vc.turno_pj1(pj1,pj2); // Inicia los turnos de cada personaje (Siempre empieza pj1).
            // Comprobar si ha perdido jugador2.
            if (esPerdedor(pj2)) {
                break;
            }
            vc.turno_pj2(pj1,pj2);
        }
    }

    // Metodo para saber si ha perdido un jugador
    public Boolean esPerdedor(Personaje pj) {
        return pj.getVidaActual()<=0; // Devuelve true (que si es el perdedor) si la vida del personaje es menos o igual que 0
    }
}