import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[][] array_bi = new int[2][3]; // Crar array bidireccional
        Scanner s = new Scanner(System.in);
        // RELLENAR DATOS ARRAY
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                while (true) {
                    System.out.print("Introduzca un numero entre 0 y 1000: ");
                    int numero = s.nextInt();
                    if ((numero>= 0) && (numero<= 1000)) {
                        array_bi[i][j] = numero;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                System.out.println("El valor introducido es: "+array_bi[i][j]);
            }
        }
        // NUMERO MAXIMO Y MINIMO: CALCULARLOS Y OBTENER POSICION
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                int max= array_bi[i][j];
                int min= array_bi[i][j];

            }
        }
    }
}

// SI VALOR INTRODUCIDO >= 0 && <= 1000 ENTONCES
// ARRRAY_BI[i][j] = VALOR INTRODUCIDO