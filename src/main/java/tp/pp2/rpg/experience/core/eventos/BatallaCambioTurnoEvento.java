package tp.pp2.rpg.experience.core.eventos;

import java.util.List;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaCambioTurnoEvento implements BatallaEvento {
	private List<String> personajes;
	private Batalla batalla;
	
	public BatallaCambioTurnoEvento(Batalla batalla) {
		this.batalla = batalla;
		this.personajes=batalla.getPersonajes();
	}

	@Override
	public void onJugar() {
		this.cambiarTurno(batalla);
	}
	
	private void cambiarTurno(Batalla batalla) {
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
