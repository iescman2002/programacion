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
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return this.cif = cif;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }
    public ArrayList<Area> getAreas() {
        return this.areas;
    }
    public void setAreas(ArrayList<Area>areas) {
        this.areas = areas;
    }
    public void agregarArea(Area area) {    // CREAR METODO PARA AGREGAR AREAS AL HOSPITAL
        this.areas.add(area);
    }
}