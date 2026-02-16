public class Main {
    // Crear clases
    public static void main(String[] args) {
        Sensor s1 = new Sensor("5212", "Activo", "A");
        Sensor s2 = new Sensor("354e", "Suspenso", "S");
        Actuador a1 = new Actuador("3eaf5", "xEn espera", "Electrico");
        Actuador a2 = new Actuador("3eaf5", "En espera", "Robotico");
        Bioma bioma = new Bioma("Sabana", 30.8, 2.2, 51, s1, s2, a1, a2);
        Base base = new Base("Base de hierro", bioma, bioma);
        a1.ejecutarDiagnostico(s1);
        a2.ejecutarDiagnostico(s2);
        s1.registrarDato(bioma);
        base.ejecutarDiagnostico(s1);
        base.buscarEquipo(s2);
    }
}