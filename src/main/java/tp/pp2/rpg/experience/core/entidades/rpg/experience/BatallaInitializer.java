package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;

public class BatallaInitializer {

	public BatallaInitializer(){}

    public Batalla generarBatalla(String pathConfigProperties){
    	CaracteristicasBuilder personajesBuilder = new CaracteristicasBuilder(pathConfigProperties.replace("\\", File.separator));
		Map<String,Properties> caracteristicas = personajesBuilder.buildAllCaracteristicas();
		HabilidadFinder habilidadFinder = new HabilidadFinder(pathConfigProperties.replace("\\", File.separator));
		List<Habilidad> habilidades = null;
		try {
			habilidades = habilidadFinder.findClasses("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> personajes = new ArrayList<>(caracteristicas.keySet());
		Batalla batalla = BatallaBuilder.build(personajes,caracteristicas,habilidades);		
        return batalla;
    }

}
