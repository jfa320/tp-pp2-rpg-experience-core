package tp.pp2.rpg.experience.core.excepciones;

public class HabilidadInexistenteException extends Exception {
    
    public HabilidadInexistenteException(String mensaje){
        super(mensaje);
    }

    public HabilidadInexistenteException(){}
}
