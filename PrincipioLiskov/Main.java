import java.util.Iterator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Configuracion configuracion = new Configuracion();

        System.out.println("Cargando configuraciones:");
        configuracion.cargarConfiguracion();

        System.out.println("\nGuardando configuraciones:");
        configuracion.salvarConfiguracion();
    }
}