import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] ars) {
        Scanner s = new Scanner(System.in);
        int[] arrayInt = new int[10];
        int posicion_max = 0;
        int posicion_min = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduzca el numero: ");
            arrayInt[i] = s.nextInt();
        }

        int max = arrayInt[0];
        int min = max;

        for (int i=0;i < 10; i++) {
//            System.out.println("posicion: "+i+" valor: "+arrayInt[i]);
            if (arrayInt[i]>max) {
                max = arrayInt[i];
                posicion_max = i;
            }
            if (arrayInt[i]<min) {
                min = arrayInt[i];
                posicion_min = i;
            }
        }
        System.out.println("Valor máximo: "+max+" en la posición "+posicion_max);
        System.out.println("Valor mínimo: "+min+" en la posición "+posicion_min);
    }
}