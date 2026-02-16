public class Actuador {
    // Crear atributos
    private String numeroSerie;
    private String estado;
    private String tipo;
    // Crear constructor
    public Actuador(String numeroSerie, String estado, String tipo) {
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.tipo = tipo;
    }
    // Crear metodo
    public Sensor ejecutarDiagnostico(Sensor sensor) {
        int random = (int)(Math.random() * 3) + 1; // numero random del 1 al 3
        switch (random) {
            case 1:
                sensor.setEstado("Apagado");
                sensor.setTipo("A");
            case 2:
                sensor.setEstado("Encendido");
                sensor.setTipo("E");
            case 3:
                sensor.setEstado("Suspension");
                sensor.setTipo("S");
        }
        return sensor;
    }
}