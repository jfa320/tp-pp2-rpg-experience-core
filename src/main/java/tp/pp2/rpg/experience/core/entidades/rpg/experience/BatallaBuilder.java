package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class BatallaBuilder {
    
    public static Batalla build(Map<String,Properties> caracteristicas,List<Habilidad> habilidades){
        List<String> personajes = new ArrayList<>(caracteristicas.keySet());
        return new Batalla(personajes,caracteristicas,habilidades);	
    }

}
