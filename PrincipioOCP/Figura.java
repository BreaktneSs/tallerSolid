package PrincipioOCP;

public abstract class Figura {

    public static void main(String[] args) {
        
    }
    
    public void dibujar(){}; 
}



/**1. ¿Cumple la clase Figuras el Principio OCP. Justifica tu respuesta.
2. En caso de que no lo cumpla, modifica las clase para cumpla este criterio.
3. ¿Consideras que la tarea realizada es una refactorización? Justifica tu respuesta. */

/**SOLUCION:
 * 1. No pues si quisieramos añadir una nueva figura como por ejemplo triangulo tendriamos que modificar la clase Figuras, y esto viola el principio OCP
 * 2. Se modificaron la clase Figura, y Figuras; La clase figura ahora es una clase abstracta, de la cual hay 2 suclases cuadrado y circulo que heredan su metodo y lo reescriben, por otra parte la clase Figuras
 * ahora mantiene una lista de objetos de tipo Figura y utiliza el polimorfismo para llamar al método dibujar() de cada figura, sin importar su tipo concreto. Esto permite agregar nuevos tipos de figuras sin modificar la clase Figuras.
 * 3. Si pues entendemos por refactorizacion de codigo como modificar el diseño interno de un sistema para mejorar su estructura, legibilidad o rendimiento, sin cambiar su comportamiento externo.
 */