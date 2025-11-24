public class Area {
    // Crear atributos
    private String nombre;
    private int identificador;
    private int planta;
    private Hospital hospitales; // -> Referencia a hospital
    private Medico medicos;
    private int numMedicos; // contador de medicos por area
    // Crear constructor
    public Area(String nombre, int id, int planta,Hospital hospital) {
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

    public int getPlanta() {
        return this.planta;
    }
    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public Hospital hospitales(){
        return this.hospitales;
    }
    public void setHospitales(Hospital hospital) {
        this.hospitales = hospital;
    }
    public int getNumMedicos() {
        return this.getNumMedicos();
    }
    public void setNumMedicos(int i) {
        this.numMedicos = i;
    }

    public void agregarMedico(Medico medicos) { // METODO AGREGAR MEDICO AL AREA
        this.medicos = medicos;
    }
    public void IncrementarMedico() {   // Metodo que Incrementa numMedicos +1
        this.numMedicos++;
    }
}
