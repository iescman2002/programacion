package Bloques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

        // Imprimir ciudades y el precio de los items
        System.out.println("Bloque 3 Ejercicio 11:");
        System.out.println("Ciudades: \n"+ciudades_stock);
        System.out.println("Precios sin aumentar impuestos:\n"+items);
        // comprobar si tiene la ciudad un stock > 5
        for (ArrayList<String> ciudad : ciudades_stock.values()) {
            if (tieneQueSubirImpuestos(ciudad)) { // Si la ciudad tiene que subir los impuestos:
                items = aplicarImpuestoDeLujo(items,ciudad); // Sobrescribimos en la lista de items-precio con los precios actuales
            }
        }
        System.out.println("Precio tras los impuestos: "+items);
    }
        // Ejercicio 11 pt2 (Reto): Aplicar impuesto de lujo
        private HashMap<String, Double> aplicarImpuestoDeLujo(HashMap<String,Double> items, ArrayList<String> ciudad_que_aplica) { // Se le pasa la información de los items y la ciudad a la que tendremos que aplicar el descuento
            // Creamos hashmap vacio para devolver despues el hashmap de los items tras el impuesto
            HashMap<String, Double> objetos_actualizados = new HashMap<>(items);
            // Recorremos todas las claves de los items (nombres)
                for (String claveItem : items.keySet()) {
                    // y recorremos para cada clave un item diferente del array para comprobar si ese item es uno de los que hay que subirles el impuesto o no
                    for (String itemDeLaCiudad : ciudad_que_aplica) {
                        // Si está la clave del item en la lista de los items de la ciudad:
                        if (claveItem.equals(itemDeLaCiudad)) {
                            // Cambiamos el valor correspondiente a la clave (precio) a un 10% más del valor actual.
                            double precio_actualizado = items.get(claveItem)*1.10;
                            objetos_actualizados.put(claveItem,precio_actualizado);
                        }
                    }
                }
                // Devolvemos el HashMap objetos_actualizados; Por defecto devuelve la misma lista pero si se modifica algun precio se devolverá la lista con el precio actualizado
                return objetos_actualizados;
        }
        // Ejercicio 11 pt2: Funcion de ayuda para comprobar si se sube o no los impuestos en la ciudad
        private boolean tieneQueSubirImpuestos(ArrayList<String> ciudad) {
            // Si la ciudad tiene mas de 5 items devolvemos que si tiene q subir los impuestos.
            if (ciudad.size()>5) {
                return true;
            }
            else {
                return false;
            }
        }
    // Ejercicio 12: Gestión de Árboles de Habilidades
    public void gestionArbolesdeHabilidades() {
        System.out.println("Bloque 3: Ejercicio 12: ");
        // Crear Hashmap de las clases y Hashmap de habilidades y estado
        HashMap<String, HashMap<String, Boolean>> clases = new HashMap<>();
        HashMap<String, Boolean> habilidadesSacerdote = new HashMap<>();
        HashMap<String, Boolean> habilidadesPaladin = new HashMap<>();
        HashMap<String, Boolean> habilidadesDruida = new HashMap<>();
        // Rellenar HashMap de habilidades
        habilidadesSacerdote.put("Golpe Divino",true);
        habilidadesSacerdote.put("Enfoque",false);
        habilidadesSacerdote.put("Escudo de Luz", false);
        habilidadesPaladin.put("Sigilo", false);
        habilidadesPaladin.put("Grito de Guerra", false);
        habilidadesPaladin.put("Espadazo", true);
        habilidadesDruida.put("Curación",true);
        habilidadesDruida.put("Llamarada", true);
        habilidadesDruida.put("Veneno", false);

        // Asignar habilidades a la clase
        clases.put("Sacerdote",habilidadesSacerdote);
        clases.put("Paladin",habilidadesPaladin);
        clases.put("Druida", habilidadesDruida);
        // LLamar a la funcion que verifica si tiene desbloqueada la Habilidad Enfoque al desbloquear Golpe Divino
        verificarHabilidadDesbloqueada(habilidadesSacerdote);
    }
        // Ejercicio 12 Reto:
        private void verificarHabilidadDesbloqueada(HashMap<String, Boolean> habilidades) {
            // Cuando se desbloquee la habilidad
            if (habilidades.get("Golpe Divino").equals(true)) { // Si golpe divino pasa a ser true (desbloqueada):
                // verificamos si el jugador tiene desbloqueado enfoque
                if (habilidades.get("Enfoque").equals(true)) { // Si está desbloqueada ("Enfoque",true):
                    System.out.println("El jugador tiene la habilidad Enfoque desbloqueada.");
                }
                else {System.out.println("Error: Enfoque no ha sido aprendido.");} // Si tiene desbloqueado Golpe Divino pero Enfoque no, imprime
            }
        }
    // Ejercicio 13: Historial de Incursiones
    public void historialDeIncursiones() {
        System.out.println("Bloque 3 Ejercicio 13:");
        // Crear hashmap de mazmorra con lista de total de inclusiones realizadas
        HashMap<String, List<HashSet<String>>> mazmorrasCompletadas = new HashMap<>();
        // Crear listas (raids) que contienen los nombres de la gente que ha participado en la mazmorra:
        List<HashSet<String>> raid1 = new ArrayList<>();
        List<HashSet<String>> raid2 = new ArrayList<>();
        List<HashSet<String>> raid3 = new ArrayList<>();
        // Rellenar los participantes de la lista
        HashSet<String> participantes_raid1 = new HashSet<>();
        participantes_raid1.add("Juan");
        participantes_raid1.add("Alicia");
        participantes_raid1.add("Manuel");

        HashSet<String> participantes_raid2 = new HashSet<>();
        participantes_raid1.add("Manuel");
        participantes_raid1.add("Raul");
        participantes_raid1.add("Jose");

        HashSet<String> participantes_raid3 = new HashSet<>();
        participantes_raid1.add("Manuel");
        participantes_raid1.add("Alicia");
        participantes_raid1.add("Elena");

        // Añadir participantes a la raid
        raid1.add(participantes_raid1);
        raid2.add(participantes_raid2);
        raid3.add(participantes_raid3);
        // Crear mazmorra y asignarles raids
        mazmorrasCompletadas.put("Mazmorra del duende", raid1);
        mazmorrasCompletadas.put("Mazmorra infernal", raid2);
        mazmorrasCompletadas.put("Mazmorra de los lamentos", raid3);
    }
}