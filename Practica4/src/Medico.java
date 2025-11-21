public class Medico {
    // Crar atributos
    private String dni;
    private String nombre;
    private int edad;
    private String sexo;
    private String sueldoBruto;
    private int anoInicio;
    private String ; // -> Referencia area donde trabaja
    // Crear constructor
    public Medico(String dni, String nombre, int edad, String sexo, String sueldo, int fechaInicio) {
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
        this.sueldoBruto = sueldo;
        this.anoInicio = fechaInicio;
    }
    // Metodos Get y Set
}