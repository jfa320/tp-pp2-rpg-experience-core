package tp.pp2.rpg.experience.core.entidades;

import java.util.List;

import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class ActualizadorTurno {
	private List<String> personajes;

	public ActualizadorTurno(Batalla batalla) {
		this.personajes=batalla.getPersonajes();
		batalla.setPersonajeActual(this.personajes.get(0));
	}
	
	public void cambiarTurno(Batalla batalla) {
		if (!batalla.getEstado().equals(EstadoBatalla.FINALIZADA)) {
			String personajeActual = batalla.getPersonajeActual();
			int i = personajes.indexOf(personajeActual);
			if (i < personajes.size() - 1)
				batalla.setPersonajeActual(personajes.get(i + 1));
			else
				batalla.setPersonajeActual(personajes.get(0));
		}
	}
}
