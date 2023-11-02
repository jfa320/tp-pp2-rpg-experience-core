package tp.pp2.rpg.experience.core.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.eventos.BatallaEnProgresoEvento;
import tp.pp2.rpg.experience.core.eventos.BatallaEvento;
import tp.pp2.rpg.experience.core.eventos.BatallaFinalizadaEvento;

public class Batalla extends Observable {
	private ArrayList<Properties> personajes;
	private List<Habilidad> habilidades;
	private int personajeActual;
	private EstadoBatalla estado;
	private ActualizadorTurno actualizadorTurno;
	private List<BatallaEvento> eventListeners;

	public Batalla(ArrayList<Properties> personajes, List<Habilidad> habilidades) {
		this.personajes = personajes;
		this.habilidades = habilidades;
		this.estado = EstadoBatalla.INICIADA;
		this.actualizadorTurno = new ActualizadorTurno(this);
		this.eventListeners=new ArrayList<BatallaEvento>();
		this.eventListeners.add(new BatallaEnProgresoEvento());
		this.eventListeners.add(new BatallaFinalizadaEvento());
	}

	public void jugar(Habilidad habilidad) throws Exception {
		this.validarFinalizacion();
		habilidad.realizar(this);
		this.notificarEvento();
		actualizadorTurno.cambiarTurno(this);
		// aviso a los observers
		this.setChanged();
		this.notifyObservers(this);
	}

	private void validarFinalizacion() throws Exception {
		if(this.getEstado().equals(EstadoBatalla.FINALIZADA)) throw new Exception("Batalla finalizada! No se permite seguir jugando");
	}

	private void notificarEvento() {
		for (BatallaEvento listener : eventListeners) {
            listener.onJugar(this);
        }
	}

	public ArrayList<Properties> getPersonajes() {
		return personajes;
	}

	public EstadoBatalla getEstado() {
		return estado;
	}

	public void setEstado(EstadoBatalla estado) {
		this.estado = estado;
	}

	public int getPersonajeActual() {
		return personajeActual;
	}

	public void setPersonajeActual(int personajeActual) {
		this.personajeActual = personajeActual;
	}

	public List<Habilidad> getHabilidades() {
		return habilidades;
	}

	public Habilidad getHabilidad(String nombreHabilidad) throws Exception{
		
		if(habilidades.isEmpty())
			throw new Exception("No existe la habilidad: " + nombreHabilidad + " en batalla");

		Habilidad habilidad = null;
		for (Habilidad h : habilidades) {
			if(h.getNombre().equals(nombreHabilidad)){
				habilidad = h;
				break;
			}
		}

		if (habilidad == null)
			throw new Exception("No existe la habilidad: " + nombreHabilidad + " en batalla");
		
		return habilidad;
	}

	public Object getCaracteristicaPj(String caract,int index) throws Exception{

		if (personajes.isEmpty())
			throw new Exception("No existe el personaje " + index);

		try {
			return Integer.valueOf(personajes.get(index-1).getProperty(caract));	
		} catch (Exception e) {
			return personajes.get(index-1).getProperty(caract);
		}
	}

	public void setPersonajes(ArrayList<Properties> personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		return "Batalla [personajes=" + personajes + ", habilidades=" + habilidades + ", personajeActual="
				+ personajeActual + ", estado=" + estado + "]";
	}

}
