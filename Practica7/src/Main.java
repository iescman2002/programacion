import com.rpg.model.Ciudades;
import com.rpg.model.Items;
import com.rpg.model.Personajes;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /* Leer fichero txt de forma temporal*/
        TxtHelper txthelper = new TxtHelper();
        txthelper.leerLineas();

        /* Obtener los datos del txt !!!! ESTO HAY QUE METERLO PARA SUSTITUIR AL METODO ACTUAL EN EL TXTHELPER*/
        List<Ciudades> ciudades = new ArrayList<>(); /* Se crea una lista que contendra las ciudades*/
        List<String> lineas = Files.readAllLines(Paths.get("Practica7/Ficheros/ciudades.txt")); /* Se crea una lista donde se guarda el contenido del fichero*/
        for (String linea : lineas) {
            String[] s = linea.split(";"); /* Indicamos el separador de los campos que es ; y guardamos los correspondientes atributos en el array */
            Ciudades c = new Ciudades( /* Creamos una nueva ciudad para cada linea del fichero*/
                        s[0],                       /* Atributo nombre */
                        Integer.parseInt(s[1]),     /* Atributo poblacion (pasamos el dato String que es como lo teniamos guardado a Integer) */
                        s[2],                       /* Atributo clima */
                        Integer.parseInt(s[3])      /* Atributo riesgo (pasamos el dato String que es como lo teniamos guardado a Integer)*/
                    );
            ciudades.add(c); /* Añadimos la ciudad a la lista de ciudades*/
        }

        /* Leer archivos json de forma temporal*/
        JsonHelper jsonHelper = new JsonHelper();
        List<Personajes> personajes= jsonHelper.readList("Practica7/Ficheros/personajes.json", Personajes.class);
        for (Personajes personaje : personajes) {
            System.out.println(personaje);
        }

        List<Items> items = jsonHelper.readList("Practica7/Ficheros/Items.json", Items.class);
        for (Items item : items) {
            System.out.println(item);
        }

        /*Escribir datos en el json
        jsonHelper.writeList("Practica7/Ficheros/personajes.json",personajes);
    */}
}