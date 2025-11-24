import java.util.ArrayList;

public class Medico {
    // Crar atributos
    private String dni;
    private String nombre;
    private int edad;
    private String sexo;
    private double sueldoBruto;
    private int anoInicio;
    private ArrayList<Area> areas; // -> Referencia area donde trabaja, es el array list que creamos en hospital porque si no hay hospital no hay areas

    // Crear constructor
    public Medico(String dni, String nombre, int edad, String sexo, double sueldo, int fechaInicio, ArrayList<Area> area) {
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
        this.sueldoBruto = sueldo;
        this.anoInicio = fechaInicio;
        this.areas = area;
    }

    // Metodos Get y Set
    public String getDni() {
        return this.dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getnombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return this.sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSueldoBruto() {
        return this.sueldoBruto;
    }
    public void setSueldoBruto(double sueldo) {
        this.sueldoBruto = sueldo;
    }

    public int getAnoInicio() {
        return this.anoInicio;
    }
    public void setAnoInicio(int fechaInicio) {
        this.anoInicio = fechaInicio;
    }

    public ArrayList<Area> getAreas() {
        return this.areas;
    }
    public void setAreas(ArrayList<Area> area) {
        this.areas = area;
    }
}