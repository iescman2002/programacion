public class Base {
    // Crear atributos
    private String nombre;
    public Bioma selva;
    public Bioma desierto;
    // Constructor
    public Base(String nombre, Bioma selva, Bioma desierto) {
        this.nombre = nombre;
        this.selva = selva;
        this. desierto = desierto;
    }
    // Crear metodos
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
    public String buscarEquipo(Sensor sensor) {
        String numeroSerie = sensor.getNumeroSerie();
        String equipo = "";
        return equipo;
    }
}