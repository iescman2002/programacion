public class Direccion {
    // Crear atributos
    private String calle;
    private int numero;
    private int codPostal;
    private String localidad;
    private String provincia;

    // Crear constructor
    public Direccion (String calle, int num, int cp, String localidad, String provincia) {
        this.calle = calle;
        this.numero = num;
        this.codPostal = cp;
        this.localidad = localidad;
        this.provincia = provincia;
    }
    // Metodos Get y Set
    public String getCalle () {
        return this.calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int num) {
        this.numero = num;
    }

    public int getCodPostal() {
        return this.codPostal;
    }
    public void setCodPostal(int cp) {
        this.codPostal = cp;
    }

    public String getLocalidad() {
        return this.localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return this.provincia;
    }
    public void setProvincias(String provincia) {
        this.provincia = provincia;
    }
}
