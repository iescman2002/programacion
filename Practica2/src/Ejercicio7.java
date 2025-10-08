import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] ars) {
        Scanner s = new Scanner(System.in);

        int[] arrayInt = new int[10];
        int positivo = 0;
        int negativo = 0;
        int CantPositivos = 0;
        int CantNegativos = 0;

        for (int i=0;i<10;i++) {
            System.out.print("Introduzca el numero: ");
            arrayInt[i] = s.nextInt();
            if (arrayInt[i]>=0) {
                positivo += arrayInt[i];
                CantPositivos++;
            }
            else {
                negativo += arrayInt[i];
                CantNegativos++;
            }
        }
        System.out.println("Media de los Numeros positivos: "+(positivo/CantPositivos));
        System.out.println("Media de los numeros negativos: "+(negativo/CantNegativos));
    }
}