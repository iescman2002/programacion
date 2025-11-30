public class MenuGestor {
    public static void elegirSeccion(int seccion) { // Mostramos las posibles operaciones en funcion a la seleccion elegida i
        System.out.println("A continuación, eliga la operación a realizar: ");
        switch (seccion) {
            case 1:
                System.out.println("1. Crear Hospital");
                System.out.println("2. Crear Área");
                System.out.println("3. Crear Médico");
                break;
            case 2:
                System.out.println("1. Modificar Médico");
                System.out.println("2. Modificar Hospital");
                break;
            case 3:
                System.out.println("1. Calcular Antigüedad");
                System.out.println("2. Calcular Sueldo Neto");
                System.out.println("3. Comprobar Edad");
                System.out.println("4. Proporción de Médicos");
                System.out.println("5. Capacidad de Área");
                System.out.println("6. Comparar Áreas");
                System.out.println("7. Contratos por Año");
                break;
        }
        System.out.print("Indicar aquí: ");
    }
    public static void elegirOperacion(int seccion, int operacion) {
        if (seccion == 1) { // Operaciones posibles eligiendo Creación
            switch (operacion) {
                case 1: // Crear Hospital: Pedir datos y Direccion
                    System.out.println("Introduzca a continuación los datos del hospital y su dirección: ");
                    break;
                case 2: // Crear Area : Pedir datos y asociar a Hospital
                    System.out.println("Introduzca a continuación los datos del Area y su hospital correspondiente: ");
                    break;
                case 3: // Crear Médico: Pedir datos, asociar a Area y crear su contrato
                    System.out.println("Introduzca a continuación los datos del Médico, el área al que pertenece y su contrato");
                    break;
            }
        }
        else if (seccion == 2) { // Operaciones posibles eligiendo Modificación
            switch (operacion) {
                case 1: // Modificar Médico: Pedir DNI del médico.
                    System.out.println("Introduzca a continuación el dato que desee modificar y posteriormente el DNI del médico:");
                    System.out.println("A. Sueldo Bruto");
                    System.out.println("B. Dirección");
                    System.out.println("C. Área de trabajo");
                    break;
                case 2: // Modificar Hospital: Pedir Nombre Hospital.
                    System.out.println("Introduzca a continuación el dato que desee modificar y posteriormente el nombre del hospital:");
                    System.out.println("A. Nombre");
                    System.out.println("B. Dirección");
                    break;
            }
        }
        else { // Operaciones posibles eligiendo Cálculos
            switch (operacion) {
                case 1: // Calcular Antigüedad: Muestra antiguedad del medico del siguiente DNI
                    System.out.println("Introduzca el DNI: ");
                    break;
                case 2: // Calcular Sueldo Neto: Pide el DNI y retencion % para calcular el sueldo neto
                    System.out.println("Introduzca el DNI y el % de retención para saber el sueldo neto: ");
                    break;
                case 3: // Comprobar Edad: Pide DNI y la edad mínima para saber si es mayor de edad
                    System.out.println("Introduzca el DNI y la edad mínima para saber si es mayor de edad o no: ");
                    break;
                case 4: // Proporción de Médicos: Muestra la proporcion de medicos que hay en un area
                    System.out.println("Introduzca el hospital y el Id del Area para conocer su proporcion: ");
                    break;
                case 5: // Capacidad de Área: Muestra la capacidad restante de medicos en un area
                    System.out.println("Introduzca el Id del Area y su limite de Aforo para saber la capacidad restante de médicos posibles: ");
                    break;
                case 6: // Comparar Áreas: Compara la cantidad de médicos que hay en 1 área frente a otra
                    break;
                case 7: // Contratos por Año: te dice los años que lleva el contrato presente.
                    System.out.println("Introduzca un año para saber cuantos años lleva en vigor: ");
                    break;
            }
        }
    }
}