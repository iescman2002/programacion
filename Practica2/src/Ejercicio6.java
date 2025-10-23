import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] ars) {
        Scanner s = new Scanner(System.in);

        int[] arrayInt= new int[10];
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;
        for (int i=0;i<10;i++) {
            System.out.print("Introduzca el numero: ");
            arrayInt[i] = s.nextInt();
            if (arrayInt[i]>0) {
               positivos++;
            }
            else if (arrayInt[i]<0) {
                negativos++;
            }
            else {
                ceros++;
            }
        }
        System.out.println("La cantidad de Nº positivos que hay son: "+positivos);
        System.out.println("La cantidad de Nº negativos que hay son: "+negativos);
        System.out.println("La cantidad de Nº ceros que hay son: "+ceros);
    }
}
