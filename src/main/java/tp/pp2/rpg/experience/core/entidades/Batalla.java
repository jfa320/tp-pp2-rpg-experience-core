package tp.pp2.rpg.experience.core.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.events.BatallaEnProgresoEvent;
import tp.pp2.rpg.experience.core.events.BatallaEvent;
import tp.pp2.rpg.experience.core.events.BatallaFinalizadaEvent;

public class Batalla extends Observable {
	private Map<String, Properties> personajes;
	private List<Habilidad> habilidades;
	private String personajeActual;
	private EstadoBatalla estado;
	private ActualizadorTurno actualizadorTurno;
	private List<BatallaEvent> eventListeners;

	public Batalla(Map<String, Properties> personajes, List<Habilidad> habilidades) {
		this.personajes = personajes;
		this.habilidades = habilidades;
		this.estado = EstadoBatalla.INICIADA;
		this.actualizadorTurno = new ActualizadorTurno(this);
		this.eventListeners=new ArrayList<BatallaEvent>();
		this.eventListeners.add(new BatallaEnProgresoEvent());
		this.eventListeners.add(new BatallaFinalizadaEvent());
	}

	public void jugar(Habilidad habilidad) throws Exception {
		habilidad.realizar(this);
		this.notificarEvento();
		actualizadorTurno.cambiarTurno(this);
		// aviso a los observers
		this.setChanged();
		this.notifyObservers(this);
	}

	private void notificarEvento() {
		for (BatallaEvent listener : eventListeners) {
            listener.onJugar(this);
        }
	}

	public Map<String, Properties> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Map<String, Properties> personajes) {
		this.personajes = personajes;
	}

	public String getPersonajeNombre(int index) {
		List<String> nombresPersonajes = new ArrayList<String>(this.getPersonajes().keySet());
		return nombresPersonajes.get(index);
	}

	public Integer getPersonajeVida(int index) {
		List<String> nombresPersonajes = new ArrayList<String>(this.getPersonajes().keySet());
		String personajeKey = nombresPersonajes.get(index);
		Properties propiedadesPersonajeElegido = this.getPersonajes().get(personajeKey);
		return Integer.valueOf(propiedadesPersonajeElegido.getProperty("vida"));
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

	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

	@Override
	public String toString() {
		return "Batalla [personajes=" + personajes + ", habilidades=" + habilidades + ", personajeActual="
				+ personajeActual + ", estado=" + estado + "]";
	}

}
