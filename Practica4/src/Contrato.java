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

    public boolean esDeAnio(int Anio) {
        return this.fechaCreacion == Anio; // Si la fechaCreacion es igual a la fecha Anio devuelve true sino false
    }

    public int diasDesdeCreacion() { // Devuelve los dias transcurridos desde la creacion del contrato
        int AniosDesdeElContrato = java.time.Year.now().getValue()-this.fechaCreacion; // Primero calculo los años que han pasado desde el contrato
        int diasDesdeElContrato = (int) (AniosDesdeElContrato*365.25); // Y los años desde el contrato lo paso a días multiplicando los años por 365 que es los dias que tiene un año y 0.25 por los años bisiestos.
        return diasDesdeElContrato;
    }
}