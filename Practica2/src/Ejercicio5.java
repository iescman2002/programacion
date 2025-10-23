import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] ars) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca la longitud de su array: ");
        int[] arrayInt = new int[s.nextInt()];
        int suma = 0;

        for (int i=0;i< arrayInt.length;i++) {
            arrayInt[i] = (int)(Math.random()*10);
            suma = arrayInt[i]+suma;
        }
        System.out.println("El valor generado para las siguientes posiciones son: ");
        for (int i=0;i<arrayInt.length;i++) {
            System.out.println("Posicion: "+i+" vale: "+arrayInt[i]);
        }
        System.out.print("Y la suma de todos los valores es: "+suma);
    }
}