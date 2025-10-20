public class Ejercicio11 {
    public static void main(String[] ars) {
        int[] arrayInt = {1,2,3,4,5,6};
        String resultado = "";
        for (int i = 0; i < arrayInt.length; i++) {
            resultado = arrayInt[i] +" "+ resultado;
        }
        System.out.println("El orden de los valores del array invertidos serán: "+resultado);
    }
}
