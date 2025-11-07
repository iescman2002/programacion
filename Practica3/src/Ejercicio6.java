public class Ejercicio6 {
    public static void main() {
        int[][] array_bi = new int[6][10]; // Crar array bidireccional
        // RELLENAR DATOS ARRAY CON ALEATORIO ENTRE 20 Y 40
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                array_bi[i][j] = (int) (Math.random() * 41);
                if (array_bi[i][j] < 20) {
                    array_bi[i][j] += 20;
                }
            }
        }
        // COMPARAR VALORES ENTEROS DEL ARRAY_BI
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                for (int k = 0; k < array_bi.length; k++) {
                    for (int l = (k == i ? j + 1 : 0); l < array_bi[k].length; l++) { // El valor de l será j+1 si k es igual a i, y si no es igual el resultado es 0. Así no comparamos el mismo valor consigo mismo.
                        if (array_bi[i][j] == array_bi[k][l]) {
                            array_bi[i][j] = 0;
                        }
                    }
                }
            }
        }

        /* array_bi[i][j] donde se compara con unas posiciones inventadas [k][l]
           k hace como si fuera la i, mientras que l hace de j en el array_bi
                * */
        // NUMERO MAXIMO Y MINIMO: CALCULARLOS Y OBTENER POSICION
        // CALCULAR MAXIMOS Y MINIMOS
        int max = array_bi[0][0];
        int min = 40;
        int columna = 0;
        int fila = 0;
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                // EXCLUYE LOS NUMEROS REPETIDOS (LOS Q VALEN 0)
                if ((array_bi[i][j] >= max)&&(array_bi[i][j]!=0)) {
                    max = array_bi[i][j];
                    columna = j;
                    fila = i;
                }
            }
        }
        System.out.println("El valor maximo es: " + max + " y esta en la fila " + fila + " y columna " + columna);


        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                if (array_bi[i][j] < min) {
                    // EXCLUYE LOS NUMEROS REPETIDOS (LOS QUE VALEN 0)
                    if (array_bi[i][j]!=0) {
                    min = array_bi[i][j];
                    columna = j;
                    fila = i;
                    }
                }
            }
        }
        System.out.println("El valor minimo es: " + min + " y esta en la fila " + fila + " y columna " + columna);
        // OBTENER SUMA DE TODAS LAS FILAS Y COLUMNAS:
        int suma_total = 0;
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                suma_total += array_bi[i][j];
            }
        }
        System.out.println("La suma total será: " + suma_total);
        // OBTENER SUMA DE FILAS
        int[] suma_filas = new int[array_bi.length];
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                suma_filas[i] += array_bi[i][j];
            }
        }
        for (int i = 0; i < suma_filas.length; i++) {
            System.out.println("La suma de la fila " + i + " es : " + suma_filas[i]);
        }
        // OBTENER SUMA DE COLUMNAS
        int[] suma_columnas = new int[array_bi[0].length];
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                suma_columnas[j] += array_bi[i][j];
            }
        }
        for (int i = 0; i < suma_columnas.length; i++) {
            System.out.println("La suma de la columna " + i + " es: " + suma_columnas[i]);
        }
    }
}