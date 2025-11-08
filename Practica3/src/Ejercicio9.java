import java.util.Scanner;

public class Ejercicio9 {
    public static boolean DentroDelrango(int[][] tablero,int posicion1, int posicion2) {    // FUNCION PARA COMPROBAR SI LA POSICION A LA QUE EL CABALLO PUEDE MOVERSE ESTÁ DENTRO DEL TABLERO O NO
        if ((posicion1 >= 0) && (posicion1 < tablero.length) && (posicion2 >= 0) && (posicion2 < tablero[0].length)) { // Se comprueba que posicion1 y posicion2 (que serán [i][j]) son >= que 0 y < la longitud del tablero es decir la maxima posicion
            return true; // devuelve verdadero si se cumple
        }
        else {
            return false; // si sobrepasa devuelve false
        }
    }
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
        System.out.print("Introduzca aquí la posición del caballo: ");
        String posicion_caballo = s.next();
        //String[] posible_posicion = new int[8]; // 8 pq es el maximo de posiciones que puede moverse el caballo estando en una posicion
        //String posicion_caballo = "d5";
        // POSICIONES POSIBLES:
        System.out.println("El caballo puede moverse a las siguientes posiciones: ");
        //String[] posibles_posiciones = new String[8];
        int[] posiciones_filas = {1,2,-1,-2};       // VARIACIONES DE POSICION FILA i-2 i+2 i-1 i+1
        int[] posiciones_columnas = {1,2,-1,-2};    // VARIACIONES DE POSICION COLUMNA j-2 j+2 j-1 j+1
        // RELLENAR ARRAY POSICIONES DEL CABALLO:
        /*for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                posible_posicion[i] = tablero[i]
            }
        }*/
        int posicion_caballo1 = 0;
        int posicion_caballo2 = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (posicion_caballo.equals(tablero[i][j])) { // Busca la posicion donde se encuentra el caballo
                    System.out.print("El caballo se encuentra en la posicion :"+tablero[i][j]);
                    posicion_caballo1 = i;
                    posicion_caballo2 = j;
                }
            }
        }
        /*for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (posicion_caballo.equals(tablero[i][j]))  {    // identificar posicion del caballo en el array
                    //System.out.print("El caballo está en la posicion: "+tablero[i][j]);
                    posibles_posiciones[0] = tablero[i-2][j+1];
                    posibles_posiciones[1] = tablero[i+2][j+1];
                    posibles_posiciones[2] = tablero[i-1][j+2];
                    posibles_posiciones[3] = tablero[i+1][j+2];
                    posibles_posiciones[4] = tablero[i-2][j-1];
                    posibles_posiciones[5] = tablero[i+2][j-1];
                    posibles_posiciones[6] = tablero[i-1][j-2];
                    posibles_posiciones[7] = tablero[i-2][j-2];
                    System.out.print(tablero[i-2][j+1]+" , "+tablero[i+2][j+1]+" , "+tablero[i-1][j+2]+" , "+tablero[i+1][j+2]); // posibles movimientos a la derecha
                    System.out.print(" , "+tablero[i-2][j-1]+" , "+tablero[i+2][j-1]+" , "+tablero[i-1][j-2]+" , "+tablero[i-2][j-2]); // posibles movimientos a la izquierda
                }
            }
        }*/
    }
}
