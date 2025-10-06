import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] ars) {
        Scanner s = new Scanner(System.in);

        int[] arrayInt = new int[10];
        int cantidadpositivos = 0;
        int cantidadnegativos = 0;
        int positivos = 0;
        int negativos= 0;


        for (int i=0;i<10;i++) {
            System.out.print("Introduzca el numero: ");
            arrayInt[i] = s.nextInt();
            if (arrayInt[i]>=0) {
                cantidadpositivos++;
            }
            else {
                cantidadnegativos++;
            }
        }
        System.out.println("La media de los positivos son: ");
        System.out.println("La media de los negativos son: ");
        System.out.println("Positivos: "+positivos);
        System.out.println("Negativos: "+negativos);
    }
}