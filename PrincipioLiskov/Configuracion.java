import java.util.Iterator;
import java.util.Vector;

public class Configuracion {

    static void cargarConfiguracion(Vector<RecursoPersistente> recursos){
    
        recursos
            .ForEach(r => r.save());

    }

    static Vector<RecursoCargar> salvarConfiguracion(){
        
        var allRecusos = new List<RecursoCargar>{
            new ConfiguracionSistema(),
            new ConfiguracionUsuario(),
            new ConfiguracionHoraria()
        };

        allRecusos.ForEach(r => r.load());
        return allRecusos;
    }
}

/** 1 .Crea un programa principal que ejecute los métodos de la clase Configuración.
 Se crea la clase Main.Java que hace el llamado de los métodos de la clase Configuración


2. Cumple la clase Configuracion en Principio OCP. Justifica la respuesta.

En parte lo cumple porque en el principio OCP las clases o métodos
deben estar abiertas para la extensión pero cerradas para la modificación. 

Es decir, que en este ejercicio, la clase Configuracion tiene 
un vector de RecursoPersistente que almacena diferentes configuraciones. 
Esta tiene dos métodos, cargarConfiguracion() y salvarConfiguracion() 
y no cumplen con el Principio OCP porque si se quiere agregar un nuevo tipo
 de configuración se tiene que modificar la clase Configuracion para agregarlo al vector.

Sin embargo, se cumple en la forma en que se utilizan las 
interfaces y las implementaciones de RecursoPersistente. 
Dado que ConfiguracionSistema, ConfiguracionUsuario y ConfiguracionHoraria
están abiertas para extensión y se pueden crear nuevas clases que 
implementen la interfaz sin modificar las clases que ya se crearon.


3. Cumple la clase Configuracion el Principio de Liskov. Justifica la respuesta.

Lo cumple porque la definición dice que en el principio Liskov
los objetos de una clase derivada deben poder ser sustituidos 
por objetos de la clase base sin afectar la corrección del programa
y en este ejercicio las subclases ConfiguracionSistema, 
ConfiguracionUsuario y ConfiguracionHoraria pueden ser sustituidas 
por la clase base sin afectar la corrección del programa. 
Esto se debe a que las subclases respetan el contrato definido 
por la interfaz RecursoPersistente al implementar sus métodos 
load() y save() de acuerdo con su comportamiento específico.

Pero la clase ConfiguracionHoraria tiene un ajuste en la implementación 
del método save() da un mensaje de error en lugar de realmente guardar 
la configuración horaria. Si bien esto no afecta directamente a la corrección 
del programa, puede considerarse una violación del principio de sustitución de Liskov, 
porque las subclases deberían comportarse de manera coherente con 
la clase base y cumplir con las expectativas del contrato.


4. Refactoriza la aplicación para que cumpla el principio de Liskov. La solución a

este ejercicio lo puedes encontrar en: https://lassala.net/2010/11/04/a-good-
example-of-liskov-substitution-principle/

5. Explica de forma general (independientemente del ejemplo) cual es el
problema y la solución propuesta.

La solución está en que en la clase RecursoPersistente separemos cada método.
Separamos save() para RecursoPersistente y load() para RecursoCargar
con esto aseguramos que cada uno se ocupe de su método independiente sin preocuparse del otro

Ya dentro del archivo configuración ajustamos para que simplemente cargarConfiguracion se ocupe
de load() y salvarConfiguracion de load(), así cumplimos y damos solución al problema.
*/