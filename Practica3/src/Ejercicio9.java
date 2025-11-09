import java.util.Scanner;

public class Ejercicio9 {
    public static boolean DentroDelrango(String[][] tablero,int posicion1, int posicion2) {    // FUNCION PARA COMPROBAR SI LA POSICION A LA QUE EL CABALLO PUEDE MOVERSE ESTÁ DENTRO DEL TABLERO O NO
        if ((posicion1 >= 0) && (posicion1 < tablero.length) && (posicion2 >= 0) && (posicion2 < tablero[0].length)) { // Se comprueba que posicion1 y posicion2 (que serán [i][j]) son >= que 0 y < la longitud del tablero es decir la maxima posicion
            return true; // devuelve verdadero si se cumple
        }
        else {
            return false; // si sobrepasa devuelve false
        }
    }
    public static void main(String[] args) {
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
// 🔹 CAMBIO: Movimientos posibles del caballo
        int[][] Movimientos = { // Movimientos[i] sería las filas que sube o baja
                {-2,-1}, {-2,1},// Movimientos[j] sería las columnas que se mueve
                {-1,-2}, {-1,2},
                {1,-2},  {1,2},
                {2,-1},  {2,1}
        };
        int posicion_caballo1 = 0;
        int posicion_caballo2 = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (posicion_caballo.equals(tablero[i][j])) { // Busca la posicion donde se encuentra el caballo
                    System.out.print("El caballo se encuentra en la posicion: "+tablero[i][j]);
                    posicion_caballo1 = i; // Guarda fila DEL ARRAY del caballo
                    posicion_caballo2 = j; // Guarda columna DEL ARRAY del caballo
                    break; // Una vez ha obtenido el valor del caballo para de buscar
                }
            }
        }
        // IMPRIME LAS POSICIONES V2
        int[][] posicionesvalidas = new int [8][2]; // Cada fila es un movimiento posible y cada columna es igual a la fila y la columna
        int contar = 0;     // los movimientos que se pueden hacer
        System.out.println("\n"+"El caballo puede moverse a las siguientes posiciones: ");
        for (int i = 0; i < Movimientos.length; i++) {      // La parte donde trabajo con variables fila, columna, contar y posicionesvalidas me ha ayudado chatgpt
            int fila = posicion_caballo1+Movimientos[i][0];
            int columna = posicion_caballo2+Movimientos[i][1];
            if (DentroDelrango(tablero,fila,columna)) {     // Si la posicion está dentro del rango del tablero

                posicionesvalidas[contar][0] = fila;        // Se guarda la posicion en la ubicacion contar y el 0 es la fila
                posicionesvalidas[contar][1] = columna;     // Se guarda la posicion en la ubicacion contar y el 1 que es la columna
                contar++;
            }
        }
        // IMPRIMIR TABLERO
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                boolean movimientovalido = false;       // SE ESTABLECE SI ES VALIDA O NO UNA POSICION
                for (int k = 0; k < contar; k++) {
                    if ((i == posicionesvalidas[k][0])&&(j==posicionesvalidas[k][1])) {
                        movimientovalido = true;
                        break;
                    }
                }
                /*
                SI EL MOVIMIENTO ES VALIDO PONE X EN LA CELDA
                    SI NO ES VALIDO PERO VALE IGUAL QUE LA POSICION DEL CABALLO PONE SU POSICION
                        SI NO ES NADA PUES SE DEJA VACIO
                 */
                if (movimientovalido) {
                    System.out.printf("|%9s","X");
                }
                else if ((i==posicion_caballo1)&&(j==posicion_caballo2)) {
                    System.out.printf("|%9s","caballo");
                }
                else {
                    System.out.printf("|%9s", "");
                }
            }
            System.out.print("|");
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print("----------");
            }
            System.out.println();
        }
    }
}
