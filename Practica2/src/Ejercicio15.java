import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> Lista_enteros = new ArrayList<>();

        // INTRODUCIR ENTEROS AL ARRAY DINAMICO
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduzca un numero: ");
            Lista_enteros.add(s.nextInt());
        }
        // PRUEBA: Imprimir datos del array
        for (int i = 0; i < Lista_enteros.size(); i++) {
            System.out.println("Cifra: "+Lista_enteros.get(i));
        }
        // ORDEN DE MAYOR A MENOR
        int min= 0;
        int max = min;
        for (int i = 1; i < Lista_enteros.size(); i++) {
            if (Lista_enteros.get(i)>=max) {
                max = Lista_enteros.get(i);
            }
            else {
                min = Lista_enteros.get(i);
            }
        }
        System.out.println("El valor min es: "+min+" y el maximo es: "+max);
    }
}