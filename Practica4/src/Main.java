import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        precargaDatos();
        ejecutarMenuPrincipal();
        int seccion = s.nextInt(); // Insertamos la seccion a la que queremos acceder
        if ((seccion != 1)&&(seccion != 2)&&(seccion != 3)) { // Si elige 4 del MenuPrincipal devuelve void finalizando ahí el codigo o si devuelve un numero incorrecto igual
            System.out.print("Va a salir.");
            return;
        };
        MenuGestor.elegirSeccion(seccion);
        int operacion = s.nextInt(); // Insertamos la operacion que queremos realizar
        MenuGestor.elegirOperacion(seccion, operacion);
        /*for (int i = 1; i < 3; i++) { // 3 porque es el maximo de secciones que hay
            for (int j = 1; j < 12; j++) { // 12 porque es el maximo de operadores que hay
                if (i == 1) {
                    if (j == 1) {
                        System.out.print("Formato: NombreHospital -> CifHospital \n Direccion: calle num cp localidad provincia");
                        Hospital h3 = new Hospital(s.next(), s.next()); // Creo nuevo hospital
                        hospitales.add(h3);
                        Direccion d3 = new Direccion(s.next(), s.nextInt(), s.nextInt(), s.next(), s.next());
                        direcciones.add(d3);
                    }
                    else if (j == 2) {
                        System.out.print("Formato: -> NombreArea idArea NºPlanta Hospital");
                        ArrayList<Hospital> h3
                        Area a6 = new Area(s.next(),s.next(),s.nextInt(), h1);
                    }
                    else if (j == 3) {

                    }
                    else break;
                }
            }
        */
    }
    // Precarga de datos -> Tener los minimos de datos para que funcione.
    public static void precargaDatos() {
        // Crear los arrays donde se almacenaran los objetos
        ArrayList<Direccion> direcciones = new ArrayList<>();
        ArrayList<Hospital> hospitales = new ArrayList<>();
        ArrayList<Area> areas = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Contrato> contratos = new ArrayList<>();
        // Orden: Direccion -> Hospital -> Area(s) -> Médicos -> Contratos
        // Creacion Direccion
        Direccion d1 = new Direccion("C/ Corredera", 5,11500,"Jerez de la frontera","Cadiz");
        Direccion d2 = new Direccion("Avd Hospitalet", 23, 501, "Hospitalet de Llobregat", "Barcelona");
        // Añadir al ArrayList
        direcciones.add(d1);
        direcciones.add(d2);
        // Creacion Hospitales
        Hospital h1 = new Hospital("La Salvacion","B12345678");
        Hospital h2 = new Hospital("La Mala Suerte","D87654321");
        // Añadir al ArrayList
        hospitales.add(h1);
        hospitales.add(h2);
        // Creacion Areas
        Area a1 = new Area("Urgencias","U1",5,h1);
        Area a2 = new Area("Pediatria", "P1", 3,h1);
        Area a3 = new Area("Sala de Descanso", "SD1", 0,h1);

        Area a4 = new Area("Urgencias", "U2", 0,h2);
        Area a5 = new Area("Sala Materna", "M1", 2,h2);
        // Añadir al ArrayList y a los Hospitales
        areas.add(a1); h1.agregarArea(a1);
        areas.add(a2); h1.agregarArea(a2);
        areas.add(a3); h1.agregarArea(a3);

        areas.add(a4); h2.agregarArea(a4);
        areas.add(a5); h2.agregarArea(a5);
        // Creacion Medicos
        Medico m1 = new Medico("12345678A","Carlos",32,"Masculino",2100.50,2020, a1);
        Medico m2 = new Medico("87654321B","María",29,"Femenino",2250.75,2018, a1);

        Medico m3 = new Medico("11223344C","Roberto",51,"Masculino",2750.90,1995, a2);
        Medico m4 = new Medico("44332211D","Elena",34,"Femenino",1980.40,2021, a2);

        Medico m5 = new Medico("55667788E","Lucía",27,"Femenino",2300.10,2017, a3);

        Medico m6 = new Medico("99887766F","Miguel",45,"Masculino",2890.30,2000, a4);
        Medico m7 = new Medico("66778899G","Ana",31,"Femenino",2055.80,2019, a4);
        Medico m8 = new Medico("11112222H","Sergio",38,"Masculino",2400.00,2015, a4);

        Medico m9 = new Medico("22223333J","Patricia",42,"Femenino",2550.60,2003, a5);
        // Añadir al ArrayList y a las areas y a +1 numMedicos
        medicos.add(m1); a1.agregarMedico(m1); a1.incrementarMedico();
        medicos.add(m2); a1.agregarMedico(m2); a1.incrementarMedico();

        medicos.add(m3); a2.agregarMedico(m3); a2.incrementarMedico();
        medicos.add(m4); a2.agregarMedico(m4); a2.incrementarMedico();

        medicos.add(m5); a3.agregarMedico(m5); a3.incrementarMedico();

        medicos.add(m6); a4.agregarMedico(m6); a4.incrementarMedico();
        medicos.add(m7); a4.agregarMedico(m7); a4.incrementarMedico();
        medicos.add(m8); a4.agregarMedico(m8); a4.incrementarMedico();

        medicos.add(m9); a5.agregarMedico(m9); a5.incrementarMedico();
        // Creacion Contratos
        Contrato c1 = new Contrato(2020, m1, h1);
        Contrato c2 = new Contrato(2018, m2, h1);

        Contrato c3 = new Contrato(1995, m3, h1);
        Contrato c4 = new Contrato(2021, m4, h1);

        Contrato c5 = new Contrato(2017, m5, h1);

        Contrato c6 = new Contrato(2000, m6, h2);
        Contrato c7 = new Contrato(2019, m7, h2);
        Contrato c8 = new Contrato(2015, m8, h2);

        Contrato c9 = new Contrato(2003, m9, h2);
        // Añadir al ArrayList
        contratos.add(c1);
        contratos.add(c2);
        contratos.add(c3);
        contratos.add(c4);
        contratos.add(c5);
        contratos.add(c6);
        contratos.add(c7);
        contratos.add(c8);
        contratos.add(c9);
    }
    public static void ejecutarMenuPrincipal() {
        System.out.println("Bienvenido al Sistema de Gestion Hospitalaria. A continuación, indique que desea hacer:");
        System.out.println("1. Creación.");
        System.out.println("2. Modificación.");
        System.out.println("3. Calculos.");
        System.out.println("Otro: Salir.");
        System.out.print("Indicar Aquí: ");
    }
}