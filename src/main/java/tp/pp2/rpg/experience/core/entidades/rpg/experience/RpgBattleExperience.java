package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;


public class RpgBattleExperience extends Observable {
	private Batalla batalla;

	public RpgBattleExperience() {
	};

	public RpgBattleExperience(String pathConfigProperties) {
		try{
			PersonajeBuilder pjBuilder = new PersonajeBuilder(pathConfigProperties);
			Map<String,Properties> personajes = pjBuilder.buildAllPersonajes();
			
			HabilidadFinder habilidadFinder = new HabilidadFinder();
			List<Habilidad> habilidades = habilidadFinder.findClasses(getHabilidadPath(pathConfigProperties));

			batalla = BatallaBuilder.build();
		}
		catch(Exception e){}
		/* 
		try {
			configProperties.load(new FileInputStream(pathConfigProperties));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String datosBatalla = configProperties.getProperty("datos.batalla");
		//this.personajes = ParserJSON.parsearPersonajesJSON(datosBatalla);
		this.batalla = ParserJSON.parsearBatallaJSON(datosBatalla); // la batalla ahora viene por JSON
		try {
			this.setHabilidades(configProperties.getProperty("path.habilidades"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void jugar(Habilidad habilidad) throws Exception {
		batalla.jugar(habilidad);
		setChanged();
		notifyObservers(batalla);
	}

	public Batalla getBatalla() {
		return batalla;
	}

	public void setBatalla(Batalla batalla) {
		this.batalla = batalla;
	}

	private String getHabilidadPath(String pathConfigProperties){
			Properties p = new Properties();
			try {
				p.load(new FileInputStream(pathConfigProperties));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return p.getProperty("path.habilidades");
	}

}
