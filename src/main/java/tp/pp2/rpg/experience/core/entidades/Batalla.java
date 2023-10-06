package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;
import java.util.Observable;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.events.Turnero;

public class Batalla extends Observable {
	private Map<String,Properties> personajes;
	private String personajeActual;
	private EstadoBatalla estado;
	
	public Batalla() {
		
	}
	public Batalla(Map<String,Properties> personajes,String personajeActual) {
		this.personajes=personajes;
		this.estado = EstadoBatalla.INICIADA;
		this.personajeActual=personajeActual;
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

    public void setPersonajes(Map<String, Properties> personajes) {
        this.personajes = personajes;
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
