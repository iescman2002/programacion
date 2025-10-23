import java.util.Scanner;

public class Ejercicio3 {
    public static void main (String[]ars) {
        Scanner s = new Scanner(System.in);
        int[] arrayInt = new int[5];
        for (int i=0;i<arrayInt.length;i++) {
            System.out.print("Introduzca el numero: ");
            arrayInt[i] = s.nextInt();
        }
        /*
        if ((arrayInt[0]<arrayInt[1])&&(arrayInt[0]<arrayInt[2])&&(arrayInt[0]<arrayInt[3])&&(arrayInt[0]<arrayInt[4])) {
            System.out.print("El numero mas pequeño es: "+arrayInt[0]);
        }
        else if ((arrayInt[1]<arrayInt[0])&&(arrayInt[1]<arrayInt[2])&&(arrayInt[1]<arrayInt[3])&&(arrayInt[1]<arrayInt[4])) {
            System.out.print("El numero mas pequeño es: "+arrayInt[1]);
        }
        else if ((arrayInt[2]<arrayInt[0])&&(arrayInt[2]<arrayInt[1])&&(arrayInt[2]<arrayInt[3])&&(arrayInt[2]<arrayInt[4])) {
            System.out.print("El numero mas pequeño es: "+arrayInt[2]);
        }
        else if ((arrayInt[3]<arrayInt[0])&&(arrayInt[3]<arrayInt[1])&&(arrayInt[3]<arrayInt[2])&&(arrayInt[3]<arrayInt[4])) {
            System.out.print("El numero mas pequeño es: "+arrayInt[3]);
        }
        else if ((arrayInt[4]<arrayInt[0])&&(arrayInt[4]<arrayInt[1])&&(arrayInt[4]<arrayInt[2])&&(arrayInt[4]<arrayInt[3])) {
            System.out.print("El numero mas pequeño es: "+arrayInt[4]);
        }*/
        int min = arrayInt[0];
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] <= min) {
                min = arrayInt[i];
            }
        }
        System.out.print("El valor más pequeño será: "+min);
    }
}
