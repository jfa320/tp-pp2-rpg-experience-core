package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;
import java.util.Set;

import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import java.util.Observable;
import java.util.Properties;

public class Batalla extends Observable {
	private Map<Habilidad,Set<String>> habilidadesDePjs;
	private Map<String,Properties> personajes;
	private EstadoBatalla estado;

	public Batalla() {}

	public Batalla(Map<Habilidad, Set<String>> habilidadesDePjs, Map<String,Properties> personajes) {
		this.habilidadesDePjs = habilidadesDePjs;
		this.personajes=personajes;
		this.estado = EstadoBatalla.INICIADA;
	}

	public void jugar(Habilidad habilidad) throws Exception {
		if (habilidad == null)
			throw new Exception("Habilidad Inexistente");
		// realiza efecto habilidad
		habilidad.realizar(this);
		//aca aviso a los observers de que se jugo asi cambian turno y validan victoria
		this.setChanged();
		this.notifyObservers(this);
	}

	public Map<Habilidad, Set<String>> getHabilidadesDePjs() {
        return habilidadesDePjs;
    }

    public void setHabilidadesDePjs(Map<Habilidad, Set<String>> habilidadesDePjs) {
        this.habilidadesDePjs = habilidadesDePjs;
    }

    public Map<String, Properties> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Map<String, Properties> personajes) {
        this.personajes = personajes;
    }

    public EstadoBatalla getEstado() {
        return estado;
    }

    public void setEstado(EstadoBatalla estado) {
        this.estado = estado;
    }
	@Override
	public String toString() {
		return "Batalla [habilidadesDePjs=" + habilidadesDePjs + ", personajes=" + personajes + ", estadoBatalla="
				+ estado +"]";
	}
	
	
}
