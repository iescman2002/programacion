import java.util.ArrayList;

public class Medico {
    // Crar atributos
    private String dni;
    private String nombre;
    private int edad;
    private String sexo;
    private double sueldoBruto;
    private int anoInicio;
    private Area areas; // -> Referencia a las areas

    // Crear constructor
    public Medico(String dni, String nombre, int edad, String sexo, double sueldo, int fechaInicio, Area area) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.sueldoBruto = sueldo;
        this.anoInicio = fechaInicio;
        this.areas = area;
    }

    // Metodos Get y Set
    public String getDni() {
        return this.dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getnombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return this.sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSueldoBruto() {
        return this.sueldoBruto;
    }
    public void setSueldoBruto(double sueldo) {
        this.sueldoBruto = sueldo;
    }

    public int getAnoInicio() {
        return this.anoInicio;
    }
    public void setAnoInicio(int fechaInicio) {
        this.anoInicio = fechaInicio;
    }

    public Area getAreas() {
        return this.areas;
    }
    public void setAreas(Area area) {
        this.areas = area;
    }

    public double calcularSueldoNeto(double retencion) {    // Calcular Sueldo Neto -> Sueldo Bruto - (Sueldo Bruto * (retencion% /100))
        return this.sueldoBruto-(this.sueldoBruto*(retencion/100));
    }
    public int getAniosAntiguedad(){ // Calcular Años Antigüedad -> Año actual - fecha de inicio
        return java.time.Year.now().getValue()-this.anoInicio;
    }
    public double calcularImpuestosAnuales(double tasaImpositiva) { // Calcular Impuestos anuales -> (SalarioBruto*12)*tasaImpositiva
        return (this.sueldoBruto*12)*tasaImpositiva;
    }
    public boolean esMayorDeEdad(int mayoriaEdad) { // Calcular si es Mayor de Edad -> Si >= 18 true sino false
        return mayoriaEdad>=18;
    }
    public double proximoAumento(double porcentajeAumento, int aniosRequeridos) {   // Si Antigüedad cumple AniosRequeridos return sueldoBrutoAumentado; else sueldo_actual
        if (getAniosAntiguedad() >= aniosRequeridos) {
            return this.sueldoBruto * (1+(0.1*porcentajeAumento));
        } else {
            return this.sueldoBruto;
        }
    }
    public void cambiarArea(Area nuevaArea) { // Gestiona la transferencia de areas, decrementa el contador de area y aumenta area nueva
        // Restar 1 a NumMedicos del area donde estaba el medico, sumar 1 al NumMedicos del area nueva nuevaArea
        int NumMedicoArea1 = getAreas().getNumMedicos();  // Usa una variable temporal para guardar NumMedicos actual
        getAreas().setNumMedicos(NumMedicoArea1-1);       // Le resta 1 a numMedicos del area actual
        // entramos en la configuracion del area nueva
        setAreas(nuevaArea); // Cambia el area inicial con la que trabajamos por la nueva introducida
        int NumMedicoArea2 = getAreas().getNumMedicos(); // Almacena NumMedicos de AreaNueva
        getAreas().setNumMedicos(NumMedicoArea2+1); // Suma 1 al NumMedicos area nueva
    }
}