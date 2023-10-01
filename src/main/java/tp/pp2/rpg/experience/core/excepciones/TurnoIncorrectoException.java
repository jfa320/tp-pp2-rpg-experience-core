package tp.pp2.rpg.experience.core.excepciones;

public class TurnoIncorrectoException extends Exception {
    
    public TurnoIncorrectoException(String mensaje){
        super(mensaje);
    }

    public TurnoIncorrectoException(){}
}
