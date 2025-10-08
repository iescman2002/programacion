import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] ars) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca la cantidad de personas que hay: ");
        int[] n= new int[s.nextInt()];
        int altura = 0;
        int persona_mayor_media = 0;
        int persona_menor_media = 0;

        for (int i=0;i< n.length;i++) {
            System.out.print("Introduzca la altura de ellos en cm: ");
            n[i] = s.nextInt();
            altura +=n[i];
        }
        int alturamedia = altura/n.length;
        for (int i=0;i< n.length;i++) {
            if (n[i]>alturamedia) {
                persona_mayor_media++;
            }
            else if (n[i]<alturamedia) {
                persona_menor_media++;
            }
        }
        System.out.println("La altura media es: "+alturamedia+"cm");
        System.out.println("Las personas que miden mas que la media son: "+persona_mayor_media);
        System.out.println("Las personas que miden menos que la media son: "+persona_menor_media);
    }
}