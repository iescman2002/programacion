import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hospital {
    // Crear atributos
    private String nombre;
    private String cif;
    private ArrayList<Area> areas;  // El tipo del ArrayList es del objeto Area
    // Crear constructor;
    public Hospital (String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.areas = new ArrayList<>(); // Creacion ArrayList para guardar las areas.
    }
    // Metodos Get y Set
}