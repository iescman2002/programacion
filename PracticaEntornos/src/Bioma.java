public class Bioma {
    // Crear atributos
    private String nombre;
    private double temperatura;
    private double humedad;
    private double oxigeno;
    private Sensor sensorTemp;
    private Sensor sensorOxi;
    private Actuador actuador1;
    private Actuador actuador2;
    // Crear constructor
    public Bioma(String nombre, double temperatura, double humedad, double oxigeno, Sensor sensorTemp, Sensor sensorOxi, Actuador actuador1, Actuador actuador2) {
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.oxigeno = oxigeno;
        this.sensorTemp = sensorTemp;
        this.sensorOxi = sensorOxi;
        this.actuador1 = actuador1;
        this.actuador2 = actuador2;
    }
    // Getter y Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    public double getHumedad() {
        return humedad;
    }
    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }
    public double getOxigeno() {
        return oxigeno;
    }
    public void setOxigeno(double oxigeno) {
        this.oxigeno = oxigeno;
    }
    public Sensor getSensorTemp() {
        return sensorTemp;
    }
    public void setSensorTemp(Sensor sensorTemp) {
        this.sensorTemp = sensorTemp;
    }
    public Sensor getSensorOxi() {
        return sensorOxi;
    }
    public void setSensorOxi(Sensor sensorOxi) {
        this.sensorOxi = sensorOxi;
    }
    public Actuador getActuador1() {
        return actuador1;
    }
    public void setActuador1(Actuador actuador1) {
        this.actuador1 = actuador1;
    }
    public Actuador getActuador2() {
        return actuador2;
    }
    public void setActuador2(Actuador actuador2) {
        this.actuador2 = actuador2;
    }
}