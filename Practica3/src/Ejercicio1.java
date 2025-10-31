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

        //System.out.println("Array num"+" Columna 0"+" Columna 1"+" Columna 2"+" Columna 3"+" Columna 4"+" Columna 5");
        // ALINEAR LA FILA DE COLUMNAS, %2s y %1s indica los espacios reservados que hay entre medio, y "" es para definir el contenido del %s
        System.out.printf("Array num %2s Columna 0 %1s Columna 1 %1s Columna 2 %1s Columna 3 %1s Columna 4 %1s Columna 5","","","","","","");
        System.out.println();
        // BUCLE IMPRIME LAS FILAS
        for (int i = 0; i < doub.length; i++) {
            System.out.print("Fila "+i);
            // BUCLE PARA FORMAR LA TABLA
            for (int j = 0; j < doub[i].length; j++) {
                if(doub[i][j] == 0.0 && !(i == 0 && j==0)||(i==1 && j==4)){ // SI EL VALOR NO ESTA DEFINIDO EN EL ARRAY (es decir que da 0.0) IMPRIME ESTO
                    System.out.printf("%5s|%5s ", "","");                       // EXCEPCIONA LOS VALORES QUE SI TIENEN QUE IMPRIMIRSE Y VALE 0.
                }                                                           // %5s es para rellenar con 5 espacios, y la s para indicar que se reemplace con el caracter "" que es vacio
                else {  // Estructurar La tabla.
                    System.out.printf("%5s|%5.0f ","",doub[i][j]);    // %5.0f es para ocupar 5 espacios y el .0 es para que se muestren 0 decimales, la f indica que son numeros con decimales
                }
            }
            System.out.println();
        }
    }
}