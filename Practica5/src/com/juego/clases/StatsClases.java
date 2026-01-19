package com.juego.clases;
import com.juego.habilidades.EstadisticasHabilidades;
import java.util.ArrayList;

public class StatsClases {
    // Atributos y sus modificadores que tendrán en común cada clase.
    private int vida;
    private int fuerza;
    private int defensa;
    private int inteligencia;
    private int destreza;

    // Crear constructor de las stats de las clases
    public StatsClases(int vida, int fuerza, int defensa, int inteligencia, int destreza) {
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.inteligencia = inteligencia;
        this.destreza = destreza;
    }

    // Crear metodos Get y Set
    public int getVida() {
        return this.vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return this.fuerza;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return this.defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getInteligencia() {
        return this.inteligencia;
    }
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDestreza() {
        return this.destreza;
    }
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    // Metodo que devuelve un arrayList con las habilidades de la clase
    public ArrayList<EstadisticasHabilidades> almacenarHabilidades() {
        return new ArrayList<EstadisticasHabilidades>(); // Devuelve el arraylist de las habilidades para la clase, y en dependiendo de la clase se sobrescribe.
    }
}
