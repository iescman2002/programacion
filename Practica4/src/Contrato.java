public class Contrato {
    // Crear atributos
    private int fechaCreacion;
    private Medico medico; // Referencia a medico
    private Hospital hospital; // Referencia a hospital involucrado
    // Crear constructor
    public Contrato(int fechaCreacion, Medico medico, Hospital hospital) {
        this.fechaCreacion = fechaCreacion;
        this.medico = medico;
        this.hospital = hospital;
    }
    // Metodos Get y Set
    public int getFechaCreacion() {
        return this.fechaCreacion;
    }
    public void setFechaCreacion(int fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Medico getMedico() {
        return this.medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Hospital getHospital() {
        return hospital;
    }
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}