package InversionDependencia;
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
Deduccion d=new Deduccion();
importeDeduccion = d.calculaDeduccion(importeFactura, porcentajeDeduccion);
Iva iva=new Iva();
// Calculamos el IVA
importeIVA = iva.calculaIva(importeFactura);
// Calculamos el total
importeTotal = (importeFactura - importeDeduccion) + importeIVA;
}
}

/**1.Cumple el principio de Inversión de dependencia. Justifica la respuesta.
2. En caso negativo, refactoriza el código par que cumpla el principio. */

/**
1.Si, cumple con el principio de dependencia de acuerdo a que Este diseño permite una mayor flexibilidad,
de acuerdo con que si en el futuro se  necesita cambiar cómo se calcula la deducción o el IVA, 
solo necesitaria cambiar la implementación en las clases Deduccion e Iva sin afectar la clase Factura. 
Por lo anterior, se puede decir que este diseño respeta el
2. No se requiere de refactorizar
el codigo de acuerdo a que cumple con el principio   */