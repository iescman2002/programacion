public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario( // se llama a la clase Usuario y se introducen los valores.
                "Iker",
                "Esclasans Manzano",
                11404,
                "calle patata",
                "iker@gmail.com",
                "iker1234"
                );
    System.out.println(user.getNombre());   // Imprime iker
    System.out.println(user.getApellidos());// Imprime Esclasans Manzano
    user.setNombre("Pablo");                // Modifica el valor nombre Iker por Pablo
    System.out.println(user.getNombre());   // Imprime Pablo porque ha cambiado el valor
    System.out.println(user.getEmail());    // Imprime iker@gmail.com
    user.setEmail("pablo@gmail.com");       // Modifica el valor email iker@gmail.com por Pablo@gmail.com
    System.out.println(user.getEmail());    // imprime juan@gmail.com
    System.out.println(user.getCodigoPostal()); // imprime el codigo postal
    System.out.println(user.getContrasena()); // imprime la contrasena
    System.out.println(user.checkUsuario("iker@gmail.com","iker1234"));    // Comprueba si iker@gmail.com tiene de contraseña iker1234; Devuelve false porque iker@gmail.com se ha cambiado por pablo@gmail.com, entonces ya no son iguales
    System.out.println(user);   // Imprimir user imprime igual que si pusiera user.toString()
    }
}