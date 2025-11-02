import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[][] array_bi = new int[4][5]; // Creacion array bidireccional 4 filas 5 columnas
        Scanner s = new Scanner(System.in);
        //ALMACENAR LOS DATOS EN EL ARRAY
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                System.out.print("Introduzca un número: ");
                array_bi[i][j] = s.nextInt();
            }
        }
        // SUMAR TODOS LOS VALORES DE UNA FILA Y MOSTRARLO.
        // OBTENER EL NUMERO MAYOR DE CADA COLUMNA.
        // OBTENER LA SUMA TOTAL.
        // MOSTRAR COMO TABLA, SUMA TOTAL ESQUINA INFERIOR DERECHA.

        // CALCULAR SUMATORIOS
        int[] sumatorios = new int[4];
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                sumatorios[i] += array_bi[i][j];
            }
        }
        // CALCULAR SUMA TOTAL
        int sumatorio_total = 0;
        for (int i = 0; i < sumatorios.length; i++) {
            sumatorio_total += sumatorios[i];
        }
        // IMPRIMIR TABLA PT1
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                System.out.printf("%5s | %9s", "", array_bi[i][j]);
            }
            System.out.print("     | "+sumatorios[i]+" fila "+i+"\n");
        }
        //CALCULAR MAXIMOS SEGUN COLUMNA
        int [] maximos = new int[5];
        for (int i = 0; i < array_bi[0].length; i++) {
            maximos[i] = array_bi[0][i];
            for (int j = 1; j < array_bi.length; j++) {
            if (maximos[i] < array_bi[j][i]) {
                    maximos[i] = array_bi[j][i];
                }
            }
        }
        // IMPRIMIR TABLA PT2 (ULTIMA FILA)
        System.out.printf("%5s","");
        for (int i = 0; i < maximos.length; i++) {
            System.out.printf(" | %4s Columna "+i,maximos[i]);
        }
        System.out.print("| "+sumatorio_total);
    }
}