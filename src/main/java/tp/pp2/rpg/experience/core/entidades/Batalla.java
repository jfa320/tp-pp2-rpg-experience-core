package tp.pp2.rpg.experience.core.entidades;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.events.Turnero;

public class Batalla extends Observable {
	private Map<String,Properties> personajes;
	private List<Habilidad> habilidades;
	private String personajeActual;
	private EstadoBatalla estado;

	public Batalla(Map<String,Properties> personajes,List<Habilidad> habilidades) {
		this.personajes=personajes;
		this.habilidades = habilidades;
		this.estado = EstadoBatalla.INICIADA;
	}

	public void jugar(Habilidad habilidad) throws Exception {
		// realiza efecto habilidad
		habilidad.realizar(this);
		Turnero.cambiarTurno(this);
		//aca aviso a los observers de que se jugo asi cambian turno y validan victoria
		this.setChanged();
		this.notifyObservers(this);
	}

    public Map<String, Properties> getPersonajes() {
        return personajes;
    }

    public EstadoBatalla getEstado() {
        return estado;
    }

    public void setEstado(EstadoBatalla estado) {
        this.estado = estado;
    }

	public String getPersonajeActual() {
		return personajeActual;
	}

	public void setPersonajeActual(String personajeActual) {
		this.personajeActual = personajeActual;
	}

	@Override
	public String toString() {
		return "Batalla [personajes=" + personajes + ", personajeActual=" + personajeActual + ", estado=" + estado
				+ "]";
	}
	
	
	
}
