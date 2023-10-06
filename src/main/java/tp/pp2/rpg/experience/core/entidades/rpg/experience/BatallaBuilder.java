package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class BatallaBuilder {
    
    public static Batalla build(List<Habilidad> habilidades, Map<String,Properties> personajes){
        
        Map<Habilidad,Set<String>> habilidadDePjs = new HashMap<>();
        habilidades.forEach(h -> habilidadDePjs.put(h, personajes.keySet()));
        String personajeInicial=new ArrayList<>(personajes.keySet()).get(0);
        return new Batalla(personajes,personajeInicial);
    }

}
