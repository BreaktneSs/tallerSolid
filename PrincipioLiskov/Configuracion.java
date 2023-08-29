import java.util.Iterator;
import java.util.Vector;

public class Configuracion {

Vector<RecursoPersistente> conf=new Vector<RecursoPersistente>();

public void cargarConfiguracion(){
    
    conf.add(new ConfiguracionUsuario());
    conf.add(new ConfiguracionUsuario());
    conf.add(new ConfiguracionHoraria());

    for (Iterator<RecursoPersistente> i = conf.iterator(); i.hasNext(); )
        i.next().load();

}

public void salvarConfiguracion(){
    for (Iterator<RecursoPersistente> i = conf.iterator(); i.hasNext(); )
        i.next().save();

}
}

/** Crea un programa principal que ejecute los métodos de la clase Configuración.
2. Cumple la clase Configuracion en Principio OCP. Justifica la respuesta.
3. Cumple la clase Configuracion el Principio de Liskov. Justifica la respuesta.
4. Refactoriza la aplicación para que cumpla el principio de Liskov. La solución a

este ejercicio lo puedes encontrar en: https://lassala.net/2010/11/04/a-good-
example-of-liskov-substitution-principle/

5. Explica de forma general (independientemente del ejemplo) cual es el
problema y la solución propuesta.*/