import java.util.Scanner;

public class Ejercicio7 {
    public static boolean EsPrimo (int num) { // FUNCION PARA SABER SI UN NUMERO ES PRIMO O NO
        if (num < 2) { // Si es 0 o 1 no es primo
            return false;
        }
        for (int i=2;i < num; i++) {    // i = 2 para saber probar los divisores uno por uno a partir del 2 (no antes pq todos los valores son divisibles entre 1 y 0).
            if (num % i == 0) {         // Si es divisible entre algun num mas pequeño que el num que comprueba (el resto 0)
                return false;           // Es falso (no es primo)
            }
        }
        return true;
    }
    public static void main() {
        int[][] array_bi = new int[6][10]; // Crar array bidireccional
        Scanner s = new Scanner(System.in);
        // RELLENAR DATOS ARRAY CON ALEATORIO ENTRE EL VALOR MINIMO QUE PONGA EL USUARIO Y EL VALOR MAXIMO
        System.out.print("Introduzca el valor mínimo del rango: ");
        int valor_minimo = s.nextInt();
        System.out.print("Introduzca ahora el valor máximo del rango: ");
        int valor_maximo = s.nextInt();
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                array_bi[i][j] = (int) (Math.random() * valor_maximo+1);
                if (array_bi[i][j] < valor_minimo) {
                    array_bi[i][j] += valor_minimo;
                }
            }
        }
        // HACER QUE LOS VALORES NO SE REPITAN:
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
        // IMPRIMIR MEDIA ARITMETICA DE TODOS LOS NUMEROS DEL ARRAY
        int suma = 0;
        int contar = 0;
        for (int i = 0; i < array_bi.length; i++) {
            for (int j= 0;j < array_bi[i].length;j++) {
                if (array_bi[i][j]!=0) {
                    suma += array_bi[i][j];
                    contar++;
                }
            }
        }
        double media = (double) suma / contar;
        // CALCULAR VALORES PROPORCIONALES DE UN RANGO PARA PONER *
        String[][] asterisco = new String[6][10];
        double[][] valor_proporcional = new double[6][10]; // Mismo tamaño q array_bi
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
            // Para calcularlo se resta el valor del array_bi[i][j] con el valor_minimo y obtenemos resultado1. Despues el valor maximo se resta con el valor_minimo para obtener el resultado2. Despues, dividimos el resultado1 entre el resultado2 y el resultado se multiplica entre el valor_minimo
                if (array_bi[i][j]!=0) {
                    valor_proporcional[i][j]= (double) (array_bi[i][j] - valor_minimo) / (valor_maximo - valor_minimo);
                    //System.out.println("Los valores proporcionales son: " + valor_proporcional[i][j]);
                }
            }
        }
        // TRANSFORMAR valor_proporcional a *:
        for (int i = 0; i < valor_proporcional.length; i++) {
            for (int j = 0; j < valor_proporcional[i].length; j++) {
                asterisco[i][j] = ""; // para rellenar los asteriscos y que no sean null
                for (int k = 0; k < valor_proporcional[i][j] * 10; k++) { // *10 porque los valores proporcionales son entre 0.0 y 1
                    asterisco[i][j] += "*";
                }
            }
        }

        // IMPRIMIR VALORES !!!!!! EL CODIGO DE FORMATO A TABLA ES RECICLADO DEL EJERCICIO 3 Y DEL 1 PERO MODIFICADO Y FALTA REPRESENTARLOS CON *
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                System.out.printf(" | %12s", asterisco[i][j]); // HAY QUE SUSTITUIR array_bi[i][j] por otra variable que sea string * y se repita tantas veces como el valor sea
            }
            System.out.print("     | "+" fila "+i+"\n");
        }
        for (int i = 0; i < 10; i++) {
            System.out.printf(" | %12s", "Columna " + i);
        }
        System.out.print("     | "+media+" (media aritmetica)"+"\n");
        /* TODO EL CONTENIDO DEL EJERCICIO 6 (QUE NO SE SI HAY QUE LLEGAR A MOSTRARLO O NO)
        array_bi[i][j] donde se compara con unas posiciones inventadas [k][l]
           k hace como si fuera la i, mientras que l hace de j en el array_bi

        // NUMERO MAXIMO Y MINIMO: CALCULARLOS Y OBTENER POSICION
        // CALCULAR MAXIMOS Y MINIMOS
        int max = array_bi[0][0];
        int min = valor_maximo;
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
        }*/
        // OBTENER POSICION DE LOS NUMEROS QUE SON PRIMOS
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                if (EsPrimo(array_bi[i][j])) {  // Si el valor de la posicion i,j es primo entonces:
                    System.out.println("El valor primo: "+array_bi[i][j]+" está en la fila "+i+" y a su vez está en la columna "+j);
                }
            }
        }
    }
}