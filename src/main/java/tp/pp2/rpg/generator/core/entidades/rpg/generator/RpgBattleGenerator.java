package tp.pp2.rpg.generator.core.entidades.rpg.generator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Properties;

import tp.pp2.rpg.generator.core.entidades.Batalla;
import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.generator.core.extensible.HabilidadFinder;
import tp.pp2.rpg.generator.core.utils.ParserJSON;

public class RpgBattleGenerator extends Observable {
	private Batalla batalla;
	private List<Habilidad> habilidades;
	private List<Personaje> personajes;
	private String nombreGanador;
	private HabilidadFinder habilidadFinder;
	private Properties configProperties = new Properties();

	public RpgBattleGenerator() {
	};

	public RpgBattleGenerator(String pathConfigProperties) {
		try {
			configProperties.load(new FileInputStream(pathConfigProperties));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String datosBatalla = configProperties.getProperty("datos.batalla");
		this.personajes = ParserJSON.parsearPersonajesJSON(datosBatalla);
		this.batalla = ParserJSON.parsearBatallaJSON(datosBatalla); // la batalla ahora viene por JSON
		this.nombreGanador = "";
		try {
			this.setHabilidades(configProperties.getProperty("path.habilidades"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jugar(Habilidad habilidad, Personaje personajeAtacante, Personaje personajeAtacado) throws Exception {
		batalla.jugar(habilidad, personajeAtacante, personajeAtacado);
		setChanged();
		notifyObservers(batalla);
	}

	public void setHabilidades(String path) throws Exception {
		this.habilidadFinder = new HabilidadFinder();
		this.habilidades = habilidadFinder.findClasses(path);
	}

	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

	public Batalla getBatalla() {
		return batalla;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public String getNombreGanador() {
		String nombre = this.personajes.stream()
				.filter(personaje -> personaje.getId() == batalla.getPersonajeGanadorId()).findFirst().get()
				.getNombre();
		return nombre != null ? nombre : "";
	}

	public void setBatalla(Batalla batalla) {
		this.batalla = batalla;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public void setNombreGanador(String ganador) {
		this.nombreGanador = ganador;
	}

}
