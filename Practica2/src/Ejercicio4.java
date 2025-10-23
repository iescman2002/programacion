public class Ejercicio4 {
    public static void main(String[] ars) {
        int[] arrayInt = new int[100];
        int suma = 0;
        for (int i = 0; i < 100; i++) {
            arrayInt[i] = i + 1;
            suma = arrayInt[i]+suma;
        }
        double media = (double) suma /arrayInt.length;
        System.out.println("La suma del 1 al 100 incrementalmente es: "+suma);
        System.out.println("Y la media será: "+media);
    }
}