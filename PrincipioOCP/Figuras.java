package PrincipioOCP;
import java.util.Vector;

public class Figuras {

    Vector<Figura> figuras = new Vector<Figura>();

    public void addFigura(Figura figura) {
        figuras.add(figura);
    }

    public void dibujarFiguras() {
        for (Figura figura : figuras) {
            figura.dibujar();
        }
    }
}