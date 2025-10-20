import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio14 {
    public static void main() {
        Scanner s= new Scanner(System.in);
        ArrayList<String> Lista_nombres= new ArrayList<>();
        while (true) {
            System.out.println("Introduzca un nombre: ");
            String nombre = (s.next());
            if (nombre == "fin"){
                break;
            }
            Lista_nombres.add(nombre);
        }
        System.out.println("Introduzca un nombre para buscar: ");
        String entrada_nombre = s.next();
        // Revisar, probablemente cambiar y nueva variable if nombres iguales true else no
        for (int i = 0; i < Lista_nombres.size(); i++) {
            if (entrada_nombre == Lista_nombres.get(i)) {
                System.out.print("El nombre: "+entrada_nombre+" está en la lista en la posición "+Lista_nombres.);
            }
        }
    }
}