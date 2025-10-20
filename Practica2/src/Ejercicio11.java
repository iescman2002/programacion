public class Ejercicio11 {
    public static void main(String[] ars) {
        int[] arrayInt = {1,2,3,4,5,6};
        int[] ArrayInvertido = new int[arrayInt.length];    // NUevo array con las mismas posiciones que arrayInt
        for (int i = 0; i < arrayInt.length; i++) {
            ArrayInvertido[i] = arrayInt[arrayInt.length-1-i];     // ArrayInvertido[i] es igual que el valor del tamaño del  arrayInt - 1 (-1 porque así obtenemos la ultima posicion) y -i para ir obteniendo el valor inverso.
        }
        System.out.print("El orden de los valores del array pero invertido será: ");
        for (int i = 0; i < ArrayInvertido.length; i++) {
            System.out.print(ArrayInvertido[i]+" ");
        }
    }
}
