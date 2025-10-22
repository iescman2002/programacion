import java.util.Scanner;

public class Ejercicio12 {
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca su número de DNI: ");
        int DNI = s.nextInt();
        String[] abecedario= {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        int resto = DNI % 23;
        System.out.print("La letra del DNI es: "+abecedario[resto]);
    }
}
