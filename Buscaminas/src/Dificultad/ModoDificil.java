package Dificultad;

import Vista.Escenario;

public class ModoDificil extends Modo {
    public ModoDificil() {
        super(20,24,99);
        new Escenario(getCasillas());
    }
}
