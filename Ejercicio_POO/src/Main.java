public class Main {
    public static void main(String[] args) {
        // Creación y Almacenamiento Usuarios
        Usuario usuario1 = new Usuario( // se llama a la clase Usuario y se introducen los valores.
            "Iker",
            "Esclasans Manzano",
            "11404",
            "calle patata",
            "iker@gmail.com",
            "iker1234"
        );
        Usuario usuario2 = new Usuario(
            "Juan",
            "Rodriguez Pimenton",
            "11400",
            "Avd Lorenzo",
            "juan@gmail.com",
            "juan1234"
        );
        Usuario usuario3 = new Usuario(
        "Maria",
        "Jimenez Vias",
        "28055",
        "Calle bodegon",
        "maria@gmail.com",
        "maria1234"
        );
        Usuario[] Usuarios = {usuario1,usuario2,usuario3};// Usuario[] es la clase/objeto y Usuarios es el array
        // Simulación de Inicio de Sesión y Manejo de Errores
        if (usuario1.checkUsuario("iker@gmail.com","iker1234")){
            System.out.println("Acceso concedido a "+usuario1.getNombre());
        }
        if (usuario2.checkUsuario("juan@gmail.com","juanito")){
            System.out.println("Acceso concedido a "+usuario2.getNombre());
        } else {
            System.out.println("¡ERROR! Contraseña incorrecta para "+usuario2.getEmail()+". Acceso denegado.");
        }
        // Simulación de Registro de Usuarios
        validarRegistro(Usuarios); // Ejecuta la función de validacion de usuarios.
    }
    public static void validarRegistro(Usuario[] usuarios) {
        for (int i = 0; i < usuarios.length; i++) {
            if(!usuarios[i].getCodigoPostal().startsWith("28")) {
                System.out.println("ERROR: Usuario "+usuarios[i].getNombre()+" bloqueado. Código Postal no permitido");
            }
        }
        return;
    }
}