import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
    /*
    Escribe un programa que, dada una posición en un tablero de ajedrez,
    nos diga a qué casillas podría saltar un caballo que se encuentra en esa posición.
    Como se indica en la figura, el caballo se mueve siempre en forma de L.
    El tablero cuenta con 64 casillas. Las columnas se indican con las letras de la “a” a la “h”
    y las filas se indican del 1 al 8.
     */
        Scanner s = new Scanner(System.in);
    // CREACION TABLERO AJEDREZ
        String[][] tablero =
                {{"a1","b1","c1","d1","e1","f1","g1","h1"},
                 {"a2","b2","c2","d2","e2","f2","g2","h2"},
                 {"a3","b3","c3","d3","e3","f3","g3","h3"},
                 {"a4","b4","c4","d4","e4","f4","g4","h4"},
                 {"a5","b5","c5","d5","e5","f5","g5","h5"},
                 {"a6","b6","c6","d6","e6","f6","g6","h6"},
                 {"a7","b7","c7","d7","e7","f7","g7","h7"},
                 {"a8","b8","c8","d8","e8","f8","g8","h8"}};
        // PEDIR AL USUARIO LA UBICACIÓN DEL CABALLO
        System.out.println("Introduzca aquí la posición del caballo: ");
        //String posicion_caballo = s.next();
        String posicion_caballo = "d5";
        // POSICIONES POSIBLES:
        System.out.println("El caballo puede moverse a las siguientes posiciones: ");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (posicion_caballo.equals(tablero[i][j]))  {    // identificar posicion del caballo en el array
                    //System.out.print("El caballo está en la posicion: "+tablero[i][j]);
                System.out.print(tablero[i-2][j+1]+" , "+tablero[i+2][j+1]+" , "+tablero[i-1][j+2]+" , "+tablero[i+1][j+2]); // posibles movimientos a la derecha
                System.out.print(" , "+tablero[i-2][j-1]+" , "+tablero[i+2][j-1]+" , "+tablero[i-1][j-2]+" , "+tablero[i-2][j-2]); // posibles movimientos a la izquierda
                }
            }
        }
    }
}
