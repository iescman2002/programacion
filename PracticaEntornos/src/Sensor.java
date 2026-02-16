public class Sensor {
    // Crear atributos
    private String numeroSerie;
    private String estado;
    private String tipo;
    // Crear constructor
    public Sensor(String numeroSerie, String estado, String tipo) {
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.tipo = tipo;
    }

    // Getter y Setter
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Crear metodo
    public double registrarDato(Bioma bioma) {
        return bioma.getHumedad()+bioma.getTemperatura()+bioma.getOxigeno();
    }
}
