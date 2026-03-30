package Vista;

import Utils.Casilla;

public class Escenario {

    private String[] anchura;
    private Integer[] altura;

    public Escenario(Casilla[][] tablero) {
        this.anchura = new String[]{
                "A","B","C","D","E","F","G","H","I","J",
                "K","L","M","N","O","P","Q","R","S","T"
        };
        this.altura = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        mostrarTablero(tablero);
    }

    public void mostrarTablero(Casilla[][] tablero) {
        System.out.print("  |");
        for (int i=0;i < tablero.length ;i++){
            System.out.printf(" %-3s  |", anchura[i]);
        }
        System.out.println();
        for (int i=0;i < tablero.length ;i++) {
            if (i <9) {
                System.out.print(altura[i]);
                System.out.print(" |");
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.printf("%-3s |", "📗");
                }
                System.out.println();
            }
            else {
                System.out.print(altura[i]);
                System.out.print("|");
                for (int j = 0; j < tablero[i].length; j++) {
                    System.out.printf("%-2s |", "📗");
                }
                System.out.println();
            }
        }
    }

    public void empezarPartida() {
        System.out.println("Indica la casilla en la que quieres empezar: ");
    }
}
