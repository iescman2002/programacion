public class Area {
    // Crear atributos
    private String nombre;
    private String identificador;
    private int planta;
    private Hospital hospitales; // -> Referencia a hospital
    private Medico medicos;
    private int numMedicos; // contador de medicos por area

    // Crear constructor
    public Area(String nombre, String id, int planta, Hospital hospital) {
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

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String id) {
        this.identificador = id;
    }

    public int getPlanta() {
        return this.planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public Hospital hospitales() {
        return this.hospitales;
    }

    public void setHospitales(Hospital hospital) {
        this.hospitales = hospital;
    }

    public int getNumMedicos() {
        return this.numMedicos;
    }

    public void setNumMedicos(int i) {
        this.numMedicos = i;
    }

    public void agregarMedico(Medico medicos) { // METODO AGREGAR MEDICO AL AREA
        this.medicos = medicos;
    }

    public void incrementarMedico() {   // Metodo que Incrementa numMedicos +1
        this.numMedicos++;
    }

    public String compararMedicos(Area otraArea) { // Metodo que indica que area tiene mas medicos
        if (this.numMedicos > (otraArea.numMedicos)) {
            return "La area " + this.nombre + "es mayor que " + otraArea.getNombre();
        } else if (this.numMedicos < (otraArea.numMedicos)) {
            return "La area " + otraArea.getNombre() + " es mayor que "+this.nombre;
        }
        else {
            return "El area "+this.nombre+" y el area "+otraArea.getNombre()+" tienen los mismos médicos.";
        }
    }
    public int calcularCapacidadRestante(int capacidadMaxima) { // Devuelve la cantidad de medicos que se pueden añadir antes de llegar al max
        return capacidadMaxima-this.numMedicos;
    }
}
