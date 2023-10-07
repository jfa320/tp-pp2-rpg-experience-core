package tp.pp2.rpg.experience.core.entidades;

import java.util.ArrayList;
import java.util.List;

public class ActualizadorTurno {
	private List<String> personajes;
	
	public ActualizadorTurno(Batalla batalla) {
		this.personajes = new ArrayList<>(batalla.getPersonajes().keySet());
		batalla.setPersonajeActual(this.personajes.get(0));
	}

	public void cambiarTurno(Batalla batalla) {
		String personajeActual = batalla.getPersonajeActual();
		int i = personajes.indexOf(personajeActual);
		if (i < personajes.size() - 1)
			batalla.setPersonajeActual(personajes.get(i + 1));
		else
			batalla.setPersonajeActual(personajes.get(0));
	}
}
