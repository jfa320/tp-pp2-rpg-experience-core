package tp.pp2.rpg.generator.core.excepciones;

public class HabilidadInexistenteException extends Exception {
    
    public HabilidadInexistenteException(String mensaje){
        super(mensaje);
    }

    public HabilidadInexistenteException(){}
}
