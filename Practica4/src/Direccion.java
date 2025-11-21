public class Direccion {
    // Crear atributos
    private String calle;
    private int numero;
    private String codPostal;
    private String localidad;
    private String provincias;

    // Crear constructor
    public Direccion (String calle, int num, String cp, String localidad, String provincias) {
        this.calle = calle;
        this.numero = num;
        this.codPostal = cp;
        this.localidad = localidad;
        this.provincias = provincias;
    }
    // Metodos Get y Set
}
