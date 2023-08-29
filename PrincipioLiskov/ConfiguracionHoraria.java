public class ConfiguracionHoraria implements RecursoPersistente{
    
    public void load(){
        System.out.println("Configuracion horaria cargada");
    }
    public void save() {
        System.out.println("ERROR, la hora no se puede almacenar, es solo de lectura");
    }
}