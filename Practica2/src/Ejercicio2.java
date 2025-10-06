import java.util.Scanner;

public class Ejercicio2 {
    public static void main (String[]ars) {
        Scanner s = new Scanner(System.in);
        int[] arrayInt = new int[10];
        for (int i=0;i<arrayInt.length;i++) {
            System.out.print("Introduzca el numero: ");
            arrayInt[i] = s.nextInt();
        }
        System.out.print("El valor del array es: ");
        for (int i=0;i<arrayInt.length;i++) {
            System.out.print(arrayInt[i]+" ");
        }
    }
}
