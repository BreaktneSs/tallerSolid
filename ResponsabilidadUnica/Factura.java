import java.util.Date;

public class Factura {
    public String codigo;
    public Date fechaEmision;
    public float importeFactura;
    public float importeDeduccion;
    public float importeTotal;
    public int porcentajeDeduccion;

    public Factura(String codigo, Date fechaEmision, float importeFactura, int porcentajeDeduccion) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.importeFactura = importeFactura;
        this.porcentajeDeduccion = porcentajeDeduccion;
    }

    public void calcularTotal(Calculadoradeduccion calculadoraDeduccion, Calculadoraiva calculadoraIva) {
        importeDeduccion = calculadoraDeduccion.calcularDeduccion(importeFactura, porcentajeDeduccion);

        if (codigo!="0") {
            importeTotal = (importeFactura - importeDeduccion) + calculadoraIva.calcularIVA(importeFactura);
        } else {
            importeTotal = importeFactura - importeDeduccion;
        }
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

/**SOLCUION:
 * 1. Se refactorizo la aplicacion creanfo nuevas clases para que estas se ocupen de las resposabilidades extra que tenia la clase Factura,
 * de esta manera Calculadoradeduccion y Calculadoraiva se encargaran de este tipo de procesos para que se cumpla con cabalidad el principio SRP.
 * 2. Cumpliendo el principio SRP solo se tuvo que cambiar la variable PORCENTAJE_IVA en la Calculadoraiva por un tipo de variable public static final a un valor de 0.18 en vez de 0.16.
 * 3. Para esta ultima funcionalidad se creo un if en factura que revisa el codigo de cada factura para verificar si su codigo es 0 y de esta manera no aplicarles iva.
 */