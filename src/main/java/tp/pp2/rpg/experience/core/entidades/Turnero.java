package tp.pp2.rpg.experience.core.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Turnero {
    
    private List<Personaje> orden;

    public Turnero(Set<Personaje> personajes){
        orden = new ArrayList<>();
        for (Personaje personaje : personajes) {
            orden.add(personaje);
        }
    }

    public void cambiaTurno(BatallaContexto contexto){
        Personaje aux = contexto.getTurno();
        int i = orden.indexOf(aux);
        if(i < orden.size()-1)
            contexto.setTurno(orden.get(i+1));
        else
            contexto.setTurno(orden.get(0));
    }
}
