import com.rpg.model.Ciudades;
import com.rpg.model.Items;
import com.rpg.model.Personajes;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /* Leer fichero txt de forma temporal*/
        TxtHelper txthelper = new TxtHelper();
        txthelper.leerLineas();

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