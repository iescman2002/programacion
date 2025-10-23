import java.util.Scanner;

public class Ejercicio1 {
    public static void main (String[]ars) {
        Scanner s = new Scanner (System.in);

        int[] arrayInt = new int[10];
        for (int i=0;i<10;i++) {
            System.out.print("Introduce el siguiente valor: ");
            arrayInt[i] = s.nextInt();
        }
        for (int i=0;i< arrayInt.length;i++) {
            System.out.println("Posición "+i+": "+arrayInt[i]);
        }
    }
}
