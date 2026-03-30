package Dificultad;

import Vista.Escenario;

public class ModoIntermedio extends Modo {
    public ModoIntermedio () {
        super(14,18,99);
        new Escenario(getCasillas());
    }
}
