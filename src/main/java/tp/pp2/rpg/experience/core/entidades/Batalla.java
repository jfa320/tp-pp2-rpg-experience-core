package tp.pp2.rpg.experience.core.entidades;

import java.util.List;
import java.util.Map;
import java.util.Set;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.excepciones.HabilidadInexistenteException;
import java.util.Observable;

public class Batalla extends Observable {
	private Map<Habilidad,Set<Personaje>> habilidades;
	private List<Personaje> personajes;
	private BatallaContexto contexto;

	public Batalla() {
	}

	public Batalla(Map<Habilidad, Set<Personaje>> habilidades, List<Personaje> personajes,
			BatallaContexto contexto) {
		this.habilidades = habilidades;
		this.contexto = contexto;
		this.personajes=personajes;
	}

	public void jugar(Habilidad habilidad) throws Exception {
		if (habilidad == null)
			throw new HabilidadInexistenteException();
		// realiza efecto habilidad
		habilidad.realizar(this.getContexto());
		//aca aviso a los observers de que se jugo asi cambian turno y validan victoria
		this.setChanged();
		this.notifyObservers(this.getContexto());
	}

	public Map<Habilidad, Set<Personaje>> getHabilidades() {
		return habilidades;
	}

	public BatallaContexto getContexto() {
		return contexto;
	}

	public void setHabilidades(Map<Habilidad, Set<Personaje>> habilidades) {
		this.habilidades = habilidades;
	}

	public void setContexto(BatallaContexto contexto) {
		this.contexto = contexto;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public int vida(Personaje p){
		return contexto.getVidas().get(p.getId());
	}


	public Personaje turno(){
		return contexto.getTurno();
	}

	@Override
	public String toString() {
		return "Batalla [habilidades=" + habilidades + ", personajes=" + personajes + ", validadorVictoria="
				+ ", contexto=" + contexto + "]";
	}
	
	
}
