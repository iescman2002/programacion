public class Ejercicio5 {
    public static void main(String[] args) {
        int[][] array_bi = new int[6][10]; // Crar array bidireccional
        // RELLENAR DATOS ARRAY CON ALEATORIO
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                array_bi[i][j] = (int)(Math.random()*1001);
            }
        }
        /* RELLENAR DATOS A MANO.... for (int i = 0; i < array_bi.length; i++) {
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
        }*/
        // NUMERO MAXIMO Y MINIMO: CALCULARLOS Y OBTENER POSICION
        // CALCULAR MAXIMOS Y MINIMOS
        int max = array_bi[0][0];
        int min = array_bi[0][0];
        int columna = 0;
        int fila = 0;
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                if (array_bi[i][j] >= max) {
                    max = array_bi[i][j];
                    columna = j;
                    fila = i;
                }
            }
        }
        System.out.println("El valor maximo es: " + max + " y esta en la fila " + fila + " y columna " + columna);


        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                if (array_bi[i][j]<min) {
                    min = array_bi[i][j];
                    columna = j;
                    fila = i;
                }
            }
        }
        System.out.println("El valor minimo es: "+min+" y esta en la fila "+fila+" y columna "+columna);
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