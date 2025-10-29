public class Ejercicio1 {
    public static void main(String[] args) {
        // ASIGNAR VALORES ARRAY BIDIRECCIONAL
        double[][] doub = new double[3][7];
        doub[0][0] = 0;
        doub[0][1] = 30;
        doub[0][2] = 2;
        doub[0][5] = 5;
        doub[1][0] = 75;
        doub[1][4] = 0;
        doub[2][2] = -2;
        doub[2][3] = 9;
        doub[2][5] = 11;

        System.out.println("Array num"+" Columna 0"+" Columna 1"+" Columna 2"+" Columna 3"+" Columna 4"+" Columna 5");
        // BUCLE IMPRIME LAS FILAS
        for (int i = 0; i < doub.length; i++) {
            System.out.print("Fila "+i);
            // BUCLE PARA FORMAR LA TABLA
            for (int j = 0; j < doub[i].length; j++) {
                if(doub[i][j] == 0.0 && !(i == 0 && j==0)||(i==1 && j==4)){ // SI EL VALOR NO ESTA DEFINIDO EN EL ARRAY (es decir que da 0.0) IMPRIME ESTO
                    System.out.print(" | nada  ");                            // EXCEPCIONA LOS VALORES QUE SI TIENEN QUE IMPRIMIRSE Y VALE 0
                }
                else {  // Estructurar La tabla.
                    System.out.printf(" %s "+doub[i][j]," | ");    // %s para reemplazar con texto
                }
            }
            System.out.println();
        }
    }
}
