public class Ejercicio4 {
    public static void main(String[] args) throws InterruptedException {    // SE AÑADE throws InterruptedException PARA PODER USAR Thread.sleep que es como un delay
        int[][] array_bi = new int[4][5]; // Creacion array bidireccional 4 filas 5 columnas
        // GENERAR LOS DATOS EN EL ARRAY DE FORMA ALEATORIA (ENTRE 1 Y 1999)
        for (int i = 0; i < array_bi.length; i++) {
            for (int j = 0; j < array_bi[i].length; j++) {
                array_bi[i][j] = (int) (Math.random() * 1999 + 1);   // Se castea a entero porque el valor que devuelve math random es double
            }
        }
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
            Thread.sleep(1000); // RETRASO DE 1S PARA LAS SUMAS PARCIALES
            System.out.print("     | "+sumatorios[i] + " fila " + i + "\n");
        }
        //CALCULAR MAXIMOS SEGUN COLUMNA
        int[] maximos = new int[5];
        for (int i = 0; i < array_bi[0].length; i++) {
            maximos[i] = array_bi[0][i];
            for (int j = 1; j < array_bi.length; j++) {
                if (maximos[i] < array_bi[j][i]) {
                    maximos[i] = array_bi[j][i];
                }
            }
        }
        // IMPRIMIR TABLA PT2 (ULTIMA FILA)
        System.out.printf("%5s", "");
        for (int i = 0; i < maximos.length; i++) {
            System.out.printf(" | %4s Columna " + i, maximos[i]);
        }
        Thread.sleep(1000); // RETRASO DE 1S PARA LA SUMA TOTAL
        System.out.print("| " + sumatorio_total);
    }
}