import java.util.Date;

public class Factura {
    public String codigo;
    public Date fechaEmision;
    public float importeFactura;
    public float importeIVA;
    public float importeDeduccion;
    public float importeTotal;
    public int porcentajeDeduccion;
    
    // Método que calcula el total de la factura
    public void calcularTotal() {
        // Calculamos la deducción
        importeDeduccion = (importeFactura * porcentajeDeduccion) / 100;
        // Calculamos el IVA
        importeIVA = (float) (importeFactura * 0.16);
        // Calculamos el total
        importeTotal = (importeFactura - importeDeduccion) + importeIVA;
    }
}
/** Ejercicio propuesto:
1. Refactoriza la aplicación para que cada responsabilidad quede aislada en una clase.
Indica qué cambios tendrías que realizar si el importeDeduccion se calculase en base al
importe de la factura:
Si (importeFactura>10000)
importeDeduccion = (importeFactura * porcentajeDeduccion+3) / 100;
sino importeDeduccion = (importeFactura * porcentajeDeduccion) / 100;

2. Indica los cambios que tendrías que realizar si el IVA cambiase del 16 al 18%.
3. Indica los cambios que tendrías que realizar si a las facturas de código 0, no se le
aplicase el IVA.*/