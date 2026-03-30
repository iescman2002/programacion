package Vista;

import Utils.Casilla;

public class Escenario {

    public Escenario(Casilla[][] tablero) {
        mostrarTablero(tablero);
    }

    public void mostrarTablero(Casilla[][] tablero) {
        for (int i=0;i < tablero.length ;i++) {
            System.out.print("|");
            for (int j=0; j < tablero[i].length;j++) {
                System.out.print("\uD83D\uDCD7"+"|");
            }
            System.out.println();
        }
    }
}
