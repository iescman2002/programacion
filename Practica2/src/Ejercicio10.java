import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] ars) {
        Scanner s = new Scanner(System.in);
        /* CON 2 ARRAYS
        String[] arrayNombres = new String[3];
        int[] arrayNotas = new int[arrayNombres.length];

        for (int i = 0; i < arrayNombres.length; i++) {
            System.out.print("Introduzca el nombre del alumno: ");
            arrayNombres[i] = s.next();
            System.out.print("Introduzca a continuación su nota: ");
            arrayNotas[i] = s.nextInt();
        }
        for (int i = 0; i < arrayNombres.length; i++) {
            System.out.println("El alumno " + arrayNombres[i] + " tiene de nota un: " + arrayNotas[i]);
        }
    }
}       */

        //Con 1 array bidireccional
        String[][] array_bi = new String[3][4];           // 3 filas, 4 columnas. int i 0 0 es la columna y int n = 0 es la fila.
        // RELLENAR ARRAY
        for (int i = 0; i < array_bi.length; i++) {      // int i = 0 es la columna; Bucle para guardar los nombres en la fila 0.
            int n = 0;
            System.out.print("Introduzca el nombre del alumno: ");
            array_bi[n][i] = s.next();                  // Entrada de los alumnos, fila posicion 0.
        }
        for (int i = 0; i < array_bi.length; i++) { // Bucle para guardar las notas de la fila 1.
            int n = 1;
            System.out.print("Introduzca la nota del alumno " + array_bi[0][i] + ": "); // array_bi[0][1] es la fila donde estan los nombres
            array_bi[n][i] = s.next();
        }
        for (int i = 0; i < array_bi.length; i++) { // Bucle para guardar las notas de la fila 2.
            int n = 2;
            System.out.print("Introduzca la nota del alumno " + array_bi[0][i] + ": ");
            array_bi[n][i] = s.next();
        }
        // IMPRIMIR NOTAS DE LOS ALUMNOS
        for (int i = 0; i < array_bi.length; i++) {
            System.out.println("El alumno: "+array_bi[0][i]+" tiene las siguientes notas: "+array_bi[1][i]+" y "+array_bi[2][i]);
        }
    }
}