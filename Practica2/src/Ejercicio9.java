import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] ars) {
        Scanner s = new Scanner(System.in);
        int[] arrayInt = new int[10];
        String valor = "";
        int[] posicion = new int[arrayInt.length];

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduzca el numero: ");
            arrayInt[i] = s.nextInt();
            valor += arrayInt[i];
        }
        System.out.print(valor);
    }
}
// valor ya almacenado, falta almacenar posicion, calcular valor maximo, calcular valor minimo, ver sus correspondientes posiciones