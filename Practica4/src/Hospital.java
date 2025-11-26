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
    public int getNumeroTotalMedicos() { // Devuelve el total de medicos que hay en las areas.
        int suma = 0;
        for (int i = 0; i < areas.size(); i++) {    // Recorre todas las areas del hospital
            suma += areas.get(i).getNumMedicos();   // Suma en areas los medicos de cada area (i)
        }
        return suma;
    }
    public double getProporcionMedicosArea(String idArea) { // Calcula la proporcion de medicos en un area respecto el max de medicos en el hospital
        // numMedicos del idArea * 100 (q es el total de % de proporcion) y el resultado / NumTotalMedicos
        getNumeroTotalMedicos();// Si en un hospital hay ej 15 personas entonces 15 personas es el 100%. -> Si en una hay 6 personas sabiendo que el max son 60, calcula la diferencia
    }
}