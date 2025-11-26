import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {} {
        Direccion d1 = new Direccion("C/ Larga", 7, 11500,"Jerez","Cádiz");
        Hospital h1 = new Hospital("Madre de Dios","B12345678");
        Area a1 = new Area ("Urgencias","7f",6, h1); // Todavia no se suman los medicos porque no hay medicos creados para agregarlos al area
        Area a2 = new Area("Radiografia", "3d", 5, h1);
        h1.agregarArea(a1);     // Se llama a la funcion agregarArea para insertar en h1 area a1
        h1.agregarArea(a2);
        Medico m1 = new Medico("32906291C","Manuel",26,"Masculino",1960.32,2019, a1);
        Medico m2 = new Medico("46938468X","Laura",24,"Femenino",2055.16,2016, a1);
        Medico m3 = new Medico("35483659V","Juan",48,"Masculino",2600.21,1998, a2);
        a1.agregarMedico(m1);   // Se llama a la funcion agregarMedico en Area
        a1.IncrementarMedico(); // Suma +1 a numMedicos en area 1
        a1.agregarMedico(m2);
        a1.IncrementarMedico();
        a2.agregarMedico(m3);
        a2.IncrementarMedico();
        m1.cambiarArea(a2); // Pasa medico m1 que esta en area a1 a area a2
        // FALTA numMedicos HACERLO
        Contrato c1 = new Contrato(m1.getAnoInicio(),m1,h1);
        Contrato c2 = new Contrato(m2.getAnoInicio(),m2,h1);
        Contrato c3 = new Contrato(m3.getAnoInicio(),m3,h1);
        a1.compararMedicos(a2); // Compara los medicos de a1 con los medicos a2
        a2.calcularCapacidadRestante(5); // Calcula la cantidad max de medicos que puedo meter en el area antes del limite
        h1.getNumeroTotalMedicos(); // Suma todos los medicos de todas las areas
        h1.getProporcionMedicosArea("3d");
    }
}