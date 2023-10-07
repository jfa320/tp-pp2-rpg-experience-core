package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class BatallaBuilder {
    
    public static Batalla build(List<Habilidad> habilidades, Map<String,Properties> personajes){
    
        return new Batalla(personajes,habilidades);
    }

}
