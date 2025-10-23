import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> Lista_nombres = new ArrayList<>();
        while (true) {
            System.out.print("Introduzca un nombre: ");
            String nombre = (s.next());
            if (nombre.equals("fin")) {
                break;
            }
            Lista_nombres.add(nombre);  // Añade a la lista dinamica el nombre introducido en el while
        }
        System.out.print("Introduzca un nombre para buscar: ");
        String nombre_introducido = s.next();
        boolean Esta_en_lista = false;  // Define Esta_en_lista como boolean q es verdadero o falso
        for (int i = 0; i < Lista_nombres.size(); i++) {
            if (nombre_introducido.equals(Lista_nombres.get(i))) { // Si nombre_introducido == la posicion i de Lista_nombres, Esta_en_lista lo hace true, entonces no se cumple el siguiente if, y se imprime el nombre y la posicion
            Esta_en_lista = true;
            System.out.print("El nombre: " + nombre_introducido + " se encuentra en la lista y está en la posición " + i);
            }
        }
        if (!Esta_en_lista) {   // Si Esta_en_lista es falso entonces imprime:
            System.out.print("El nombre introducido no se encuentra en la lista.");
        }
    }
}
/*
    Si nombre_introducido == Nombre_en_lista Entonces {
    Imprime "El nombre_introducido Esta en la lista"
    }
    Si nombre_introducido != Nombre_en_lista Entonces {
    Imprime "El nombre_introducido NO Esta en la lista"
    }
 */