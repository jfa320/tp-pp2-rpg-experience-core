package tp.pp2.rpg.generator.core.entidades.rpg.generator;

import java.util.List;
import java.util.Observable;

import tp.pp2.rpg.generator.core.entidades.Batalla;
import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.generator.core.extensible.HabilidadFinder;
import tp.pp2.rpg.generator.core.utils.ParserJSON;

public class RpgBattleGenerator extends Observable {
	private Batalla batalla;
	private List<Habilidad> habilidades;
	private List<Personaje> personajes;
	private String ganador;
	private HabilidadFinder habilidadFinder;

	public RpgBattleGenerator() {};
	
	public RpgBattleGenerator(String datos) {
		this.personajes=ParserJSON.parsearPersonajesJSON(datos);
		this.batalla=ParserJSON.parsearBatallaJSON(datos); //la batalla ahora viene por JSON
		this.ganador="";
		try {
			this.setHabilidades("src.test.resources.plugins");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void jugar(Habilidad habilidad, Personaje personajeAtacante, Personaje personajeAtacado) {
		batalla.calcularDanio(habilidad, personajeAtacante, personajeAtacado);
		setChanged();
		notifyObservers(batalla);
	}
	
	public void setHabilidades(String path) throws Exception {
		this.habilidadFinder=new HabilidadFinder();
		this.habilidades=(List<Habilidad>) habilidadFinder.findClasses(path);
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

	public String getGanador() {
		return ganador;
	}

	public void setBatalla(Batalla batalla) {
		this.batalla = batalla;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	
	
}
