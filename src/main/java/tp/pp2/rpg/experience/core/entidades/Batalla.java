package tp.pp2.rpg.experience.core.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.eventos.BatallaEnProgresoEvento;
import tp.pp2.rpg.experience.core.eventos.BatallaEvento;
import tp.pp2.rpg.experience.core.eventos.BatallaFinalizadaEvento;

public class Batalla extends Observable {
	private List<String> personajes;
	private List<Habilidad> habilidades;
	private String personajeActual;
	private EstadoBatalla estado;
	private Map<String,Properties> caracteristicas;
	private ActualizadorTurno actualizadorTurno;
	private List<BatallaEvento> eventListeners;

	public Batalla(List<String> personajes, Map<String,Properties> caracteristicas,List<Habilidad> habilidades) {
		this.personajes = personajes;
		this.habilidades = habilidades;
		this.caracteristicas=caracteristicas;
		this.estado = EstadoBatalla.INICIADA;
		this.actualizadorTurno = new ActualizadorTurno(this);
		this.eventListeners=new ArrayList<BatallaEvento>();
		this.eventListeners.add(new BatallaEnProgresoEvento());
		this.eventListeners.add(new BatallaFinalizadaEvento());
	}

	public void jugar(String habilidad) throws Exception {
		this.validarFinalizacion();
		getHabilidadPorNombre(habilidad).realizar();
		this.notificarEvento();
		actualizadorTurno.cambiarTurno(this);
		// aviso a los observers
		this.setChanged();
		this.notifyObservers(this);
	}

	private Habilidad getHabilidadPorNombre(String nombreHabilidad) throws Exception{
		for (Habilidad h : habilidades) 
			if (h.getNombre().equals(nombreHabilidad))
				return h;
		
		throw new Exception("La habilidad: "+ nombreHabilidad+ " no existe");
	}

	private void validarFinalizacion() throws Exception {
		if(this.getEstado().equals(EstadoBatalla.FINALIZADA)) throw new Exception("Batalla finalizada! No se permite seguir jugando");
	}

	private void notificarEvento() {
		for (BatallaEvento listener : eventListeners) {
            listener.onJugar(this);
        }
	}

	public List<String> getPersonajes() {
		return personajes;
	}

	public Properties getCaracteristicasPersonaje(String p){
		return caracteristicas.get(p);
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

	public void setPersonajes(ArrayList<String> personajes) {
		this.personajes = personajes;
	}

	public Map<String, Properties> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Map<String, Properties> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@Override
	public String toString() {
		return "Batalla [personajes=" + personajes + ", habilidades=" + habilidades + ", personajeActual="
				+ personajeActual + ", estado=" + estado + "]";
	}

}
