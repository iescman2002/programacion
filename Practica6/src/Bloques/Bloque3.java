package Bloques;

import java.util.ArrayList;
import java.util.HashMap;

public class Bloque3 {
    // Ejericicio 11: Sistema de Comercio y Precios Dinámicos
    public void sistemaDeComercioYPreciosDinamicos() {
        // Crear hashmap con los precios (valores) de los items (clave)
        HashMap<String, Double> items = new HashMap<>();
        // Rellenar items
        items.put("Manzana", 1.25);
        items.put("Pan", 0.95);
        items.put("Leche", 1.10);
        items.put("Queso", 2.75);
        items.put("Cafe", 3.40);
        items.put("Huevos", 2.10);
        items.put("Arroz", 1.80);
        // Crear hashmap con ciudades (Claves) y los items en stock (valores)
        HashMap<String, ArrayList<String>> ciudades_stock = new HashMap<>();
        // Rellenar ciudades
        ArrayList<String> ciudad1= new ArrayList<>();
        ArrayList<String> ciudad2= new ArrayList<>();
        ArrayList<String> ciudad3= new ArrayList<>();

        ciudad1.add("Manzana");
        ciudad1.add("Pan");

        ciudad2.add("Pan");
        ciudad2.add("Leche");
        ciudad2.add("Leche");
        ciudad2.add("Leche");
        ciudad2.add("Cafe");
        ciudad2.add("Arroz");
        ciudad2.add("Huevos");

        ciudad3.add("Pan");
        ciudad3.add("Queso");
        ciudad3.add("Cafe");

        ciudades_stock.put("Jerez", ciudad1);
        ciudades_stock.put("Granada",ciudad2);
        ciudades_stock.put("Murcia",ciudad3);

        // comprobar si tiene la ciudad un stock > 5
        for () {

        }
    }
        // Ejercicio 11 pt2 (Reto): Aplicar impuesto de lujo
        private void impuestoDeLujo(ArrayList<String> ciudad) {
                // Aplicar un impuesto del 10% a los items
                for (String item : ciudad) {

                }
        }
        private boolean tieneQueSubirImpuestos() {
        return false;
        }
}