public class Usuario { // Crear clase


    // Crear atributos de instancia
    private String nombre; // Private porque lo indica la practica
    private String apellidos;
    private String codigopostal;
    private String email;
    private String contrasena;

    // Constructor
    public Usuario(String no, String ap, String cp, String em, String co) {
        nombre = no;
        apellidos = ap;
        codigopostal = cp;
        email = em;
        contrasena = co;
    }
    // Encapsulamiento: Establecer datos de los atributos
    public String setNombre() {
        nombre = "juan";
        return nombre;
    }
    public String setApellidos() {
        apellidos = "Rodriguez Bernal";
        return apellidos;
    }
    public String setCodigopostal() {
        codigopostal = "11404";
        return codigopostal;
    }
    public String setEmail(String nuevoEmail) {
        email = "juan@gmail.com";
        if (!nuevoEmail.contains("@")) {    // Si NuevoEmail no contiene @ hace
            return "Error: Email inválido. No contiene @.";
        }
        else return email;
    }
    public String setContrasena() {
        contrasena = "juan1234";
        return contrasena;
    }
}