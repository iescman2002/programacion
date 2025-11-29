import java.util.ArrayList;
import java.util.IdentityHashMap;

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
    public double getProporcionMedicosArea(String idArea) { // Calcula la proporcion de medicos en un area respecto el max de medicos en el hospital         // Bucle que recorre todas las areas buscando que area tiene el mismo id que el idArea introducido
        int i; // i es la posicion del area en el array, lo defino fuera del for para poder trabajar fuera del bucle despues con la i
        for(i = 0; i < areas.size();i++) {  // Recorre todo el array hasta encontrar un area que tenga el identificador igual que el IdArea
            if (areas.get(i).getIdentificador().equals(idArea)) {
                break; // Si lo encuentra se sale del bucle, haciendo que la ultima posicion de i guardada sea donde el area actual donde esta el id que hemos introducido
            }
        }
        // La operacion es: El NumMedicos del area donde se encuentra el IdArea introducido / Total de medicos del hospital. Da 0,algo porque es el % pero sin multiplicar *100
        return (double) areas.get(i).getNumMedicos() /getNumeroTotalMedicos(); // Casteo el resultado a double porque estoy diviendo enteros y sino lo que haria seria convertir
    }
    public boolean existeArea(String idArea) { // Devuelve true si hospital ya tiene un area con el idArea insertado.
        // Mismo bucle que antes para recorrer el array
        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i).getIdentificador().equals(idArea)) {
                return true; // Devuelve true solo si ya ha encontrado idArea y se detiene
            }
        }
        return false; // Sino devuelve falso
    }
}