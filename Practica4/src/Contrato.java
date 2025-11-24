public class Contrato {
    // Crear atributos
    private int fechaCreacion;
    private String dni_medico; // Referencia a medico
    private String hospital; // Referencia a hospital involucrado
    // Crear constructor
    public Contrato(int fechaCreacion, String medico, String hospital) {
        this.fechaCreacion = fechaCreacion;
        this.dni_medico = medico;
        this.hospital = hospital;
    }
    // Metodos Get y Set
    public int getFechaCreacion() {
        return this.fechaCreacion;
    }
    public void setFechaCreacion(int fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDni_medico() {
        return this.dni_medico;
    }
    public void setDni_medico(String dni_medico) {
        this.dni_medico = dni_medico;
    }

    public String getHospital() {
        return hospital;
    }
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}