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
        // NUMERO MAXIMO Y MINIMO: CALCULARLOS Y OBTENER POSICION --->>>> INTUYO DE USAR ARRAY AUXILIAR BIDIRECCIONAL PARA ALMACENAR POSICIONES DEL VALOR MAXIMO Y ARRAY NORMAL PARA EL VALOR
        /*for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                int max= array_bi[i][j];
                int min= array_bi[i][j];
            }
        }*/
        // OBTENER SUMA DE TODAS LAS FILAS Y COLUMNAS:
        int suma_total = 0;
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                suma_total += array_bi[i][j];
            }
        }
        System.out.println("La suma total será: "+suma_total);
        // OBTENER SUMA DE FILAS
        int[] suma_filas = new int[array_bi.length];
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                suma_filas[i] += array_bi[i][j];
            }
        }
        for (int i = 0; i < suma_filas.length; i++) {
            System.out.println("La suma de la fila "+i+" es : "+suma_filas[i]);
        }
        // OBTENER SUMA DE COLUMNAS
        int[] suma_columnas = new int[array_bi[0].length];
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                suma_columnas[j] += array_bi[i][j];
            }
        }
        for (int i = 0; i < suma_columnas.length; i++) {
            System.out.println("La suma de la columna "+i+" es: "+suma_columnas[i]);
        }
    }
}

// SI VALOR INTRODUCIDO >= 0 && <= 1000 ENTONCES
// ARRRAY_BI[i][j] = VALOR INTRODUCIDO