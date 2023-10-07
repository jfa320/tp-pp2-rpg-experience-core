package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;

public class BatallaInitializer {
    
    private Map<String,Properties> personajes;
    private List<Habilidad> habilidades;

    public Batalla generarBatalla(String pathConfigProperties){
        try{
			PersonajeBuilder personajesBuilder = new PersonajeBuilder(pathConfigProperties);
			personajes = personajesBuilder.buildAllPersonajes();
			HabilidadFinder habilidadFinder = new HabilidadFinder(pathConfigProperties);
			habilidades = habilidadFinder.findClasses("");
		}
		catch(Exception e){}

		Batalla batalla = BatallaBuilder.build(habilidades,personajes);
				
        return batalla;
    }

}
