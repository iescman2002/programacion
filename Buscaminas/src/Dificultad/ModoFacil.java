package Dificultad;

import Vista.Escenario;

public class ModoFacil extends Modo {
    public ModoFacil () {
        super(8,10,10);
        new Escenario(getCasillas());
    }
}
