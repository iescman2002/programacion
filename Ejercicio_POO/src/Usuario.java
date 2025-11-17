public class Usuario { // Crear clase
    // Parametros Atributos locales de la clase (son privados, no se puede llamar desde main)

    private String nombre;
    private String apellidos;
    private String codigoPostal;
    private String direccion;
    private String email;
    private String contrasena;
    // Constructor
    public Usuario(String n, String a, String cp, String d, String e, String c) { // mismo nombre que la clase -> public Usuario. Los parametros que recibimos lo igualamos a la variable. This hace referencia a los atributos y  metodos de dentro de la clase
        this.nombre = n;
        this.apellidos = a;
        this.codigoPostal = cp;
        this.direccion = d;
        this.email = e;
        this.contrasena = c;
    }
    // Metodo Get y Set
    public String getNombre(){  // Consulta el nombre
        return this.nombre;
    }
    public void setNombre(String n){  // No devuelve nada. Metodo modificador. Modifica
        this.nombre = n;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public void setApellidos(String a){
        this.apellidos = a;
    }
    public String getCodigoPostal(){
        return this.codigoPostal;
    }
    public void setCodigoPostal(String cp){
        this.codigoPostal = cp;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public void setDireccion(String d){
        this.direccion = d;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String nuevoEmail) {
        if (nuevoEmail.contains("@")) {
            this.email = nuevoEmail;
        }
        else {
            System.out.println("Error:");
        }
    }
    public String getContrasena(){  // Consulta el nombre
        return this.contrasena;
    }
    public void setContrasena(String c){  // No devuelve nada. Metodo modificador.
        this.contrasena = c;
    }
    public Boolean checkUsuario(String email, String contrasena) {              // Verifica si el email y password coincide con el valor interno de los objetos
        return this.email.equals(email) && this.contrasena.equals(contrasena);  // Si el valor actual de email es igual que email y el valor actual de contrasena es igual a contrasena, devuelve true. Si algun dato ha sido modificado devuelve false.
    }
    // Metodo ToString
    public String toString(){   // Siempre es public String porque por algo se llama ToString el metodo
        return "El nombre completo es: "+nombre+" "+apellidos+" El codigo postal es "+codigoPostal+" Y su direccion es "+direccion+". El email es: "+email+"Y la contraseña es: "+contrasena; // devuelve todos los valores definidos en el constructor
    }
}