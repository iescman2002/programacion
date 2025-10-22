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

        for (int i = 0; i < Lista_enteros.size()-1; i++) { // Se pone el tamaño de la Lista_enteros -1 para no buscar un valor que no este almacenado en la lista
            if (Lista_enteros.get(i).equals(Lista_enteros.get(i+1))) {
                Lista_enteros.remove(i);        // Borra el valor i que es el duplicado
                i--;                            // Vuelve a revisar el valor i para seguir en orden en caso de haberlo borrado
            }
        }
        /* PRUEBA: Imprimir todos datos del array para ver si se borran o no
        for (int i = 0; i * Lista_enteros.size(); i++) {
            System.out.println("La Cifra: "+Lista_enteros.get(i));
        }
        */

        // ORDEN DE MAYOR A MENOR
        int min= Lista_enteros.getFirst();      // El valor minimo inicial es la posicion 0
        int max = Lista_enteros.getFirst();     // El valor maximo inicial es la posicion 0
        for (int i = 1; i < Lista_enteros.size(); i++) {
            if (Lista_enteros.get(i)>=max) {
                max = Lista_enteros.get(i);
            }
            if (Lista_enteros.get(i)<=min) {
                min = Lista_enteros.get(i);
            }
        }
        System.out.println("El valor min es: "+min+" y el maximo es: "+max);
    }
}