import Bloques.*;

public class Main {
    public static void main(String[] args){
        System.out.println("----------------------------------");
        Bloque1 bloque1 = new Bloque1();
        bloque1.registroDeMuertes();
        bloque1.censoUnico();
        bloque1.bolsaDeOro();
        bloque1.limpiezaDelCalabozo();
        bloque1.mercadodeHechizos();
        bloque1.expulsionDelReino();
        System.out.println("----------------------------------");
        Bloque2 bloque2 = new Bloque2();
        bloque2.repositorioDeGremios();
        bloque2.sistemaDeLoot();
        bloque2.rastreadorEstadisticasComplejas();
        bloque2.buscadorDeTraidores();
        System.out.println("----------------------------------");
        Bloque3 bloque3 = new Bloque3();
        bloque3.sistemaDeComercioYPreciosDinamicos();
        bloque3.gestionArbolesdeHabilidades();
        bloque3.historialDeIncursiones();
        bloque3.sistemaDemensajeriaGlobal();
        bloque3.simuladorEconomiadeSubastas();
        System.out.println("----------------------------------");
    }
}
