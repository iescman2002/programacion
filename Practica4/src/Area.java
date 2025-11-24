public class Area {
    // Crear atributos
    private String nombre;
    private int identificador;
    private String planta;
    private String hospitales; // -> Referencia a hospital
    private int numMedicos; // contador de medicos por area
    // Crear constructor
    public Area(String nombre, int id, String planta,String hospital) {
        this.nombre = nombre;
        this.identificador = id;
        this.planta = planta;
        this.hospitales = hospital;
        this.numMedicos = 0;
    }
    // Metodos Get y Set
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return this.identificador;
    }
    public void setIdentificador(int id) {
        this.identificador = id;
    }

    public String getPlanta() {
        return this.planta;
    }
    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String hospitales(){
        return this.hospitales;
    }
    public void setHospitales(String hospital) {
        this.hospitales = hospital;
    }
}
