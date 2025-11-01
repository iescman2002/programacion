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

        // IMPRIMIR VALORES COMO TABLA:


        // SIMPLIFICAR ESTO CON UN BUCLE, MODIFICAR SUMARIO PARA QUE SUMEN LOS VALORES QUE SON

        // CALCULAR SUMATORIOS
        int[] sumatorios = new int[4];
        for (int i = 0; i < sumatorios.length; i++) {
            for (int j = 0; j < array_bi.length; j++) {
                for (int k = 0; k < array_bi[k].length; k++) {
                    sumatorios[i] += array_bi[j][k];
                }
            }
        }
        for (int i = 0; i < sumatorios.length; i++) {
            System.out.println(sumatorios[i]);
        }
        /*int sumatorio0 = 0;
        int sumatorio1 = 0;
        int sumatorio2 = 0;
        int sumatorio3 = 0;

        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                sumatorio0 += array_bi[0][j];
                sumatorio1 += array_bi[1][j];
                sumatorio2 += array_bi[2][j];
                sumatorio3 += array_bi[3][j];
            }
        }

        // CALCULAR SUMA TOTAL
        int sumatorio_total = 0;
        for (int i = 0; i < sumatorios.length; i++) {
            sumatorio_total = sumatorios[i];
        }
        //int sumatorio_total = sumatorio0+sumatorio1+sumatorio2+sumatorio3;
        // FILA 0:
        for (int i = 0; i < array_bi[0].length; i++) {
            System.out.print(array_bi[0][i]);
        }
        System.out.print(sumatorio0+" fila 0\n");
        //FILA 1:

        for (int i = 0; i < array_bi[1].length; i++) {
            System.out.print(array_bi[1][i]);
        }
        System.out.print(sumatorio1+" fila 1\n");
        //FILA 2:
        for (int i = 0; i < array_bi[2].length; i++) {
            System.out.print(array_bi[2][i]);
        }
        System.out.print(sumatorio2+" fila 2\n");
        //FILA 3:
        for (int i = 0; i < array_bi[3].length; i++) {
            System.out.print(array_bi[3][i]);
        }
        System.out.print(sumatorio3+" fila 3\n");
        // CREACION FILAS EN BUCLE:
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                System.out.print(array_bi[i][j]+sumatorio0 +" fila ");
            }
        }
         */
    }
}