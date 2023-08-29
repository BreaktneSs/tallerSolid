public class Calculadoradeduccion {
    public float calcularDeduccion(float importeFactura, int porcentajeDeduccion) {
        if (importeFactura > 10000) {
            return (importeFactura * (porcentajeDeduccion + 3)) / 100;
        } else {
            return (importeFactura * porcentajeDeduccion) / 100;
        }
    }
}