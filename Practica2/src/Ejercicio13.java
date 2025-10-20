import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio13 {
    public static void main() {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> Lista_dinamica = new ArrayList<>();
        int suma = 0;
        while (true) {
            System.out.print("Introduzca un número: ");
            int num = s.nextInt();
            Lista_dinamica.add(num);
            if (num<0) {
                Lista_dinamica.removeLast();
                break;
            }
            suma += num;
        }
        System.out.println("Los números de la lista son: ");
        for (int i = 0; i < Lista_dinamica.size(); i++) {
            System.out.print(Lista_dinamica.get(i)+" ");
        }
        System.out.println("Y la suma de esos números es: "+suma);
    }
}
