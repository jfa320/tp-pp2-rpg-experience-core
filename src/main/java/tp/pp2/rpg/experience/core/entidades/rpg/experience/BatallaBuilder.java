package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class BatallaBuilder {
    
    public static Batalla build(List<Habilidad> habilidades, ArrayList<Properties> personajes){
    
        return new Batalla(personajes,habilidades);
    }

}
