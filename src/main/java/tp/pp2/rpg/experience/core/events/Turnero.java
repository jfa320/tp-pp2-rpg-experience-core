package tp.pp2.rpg.experience.core.events;

import java.util.ArrayList;
import java.util.List;

import tp.pp2.rpg.experience.core.entidades.Batalla;

public class Turnero {

	public static void cambiarTurno(Batalla batalla) {
		List<String> personajes = new ArrayList<>(batalla.getPersonajes().keySet());
		String personajeActual = batalla.getPersonajeActual();
		int i = personajes.indexOf(personajeActual);
		if (i < personajes.size() - 1)
			batalla.setPersonajeActual(personajes.get(i + 1));
		else
			batalla.setPersonajeActual(personajes.get(0));
	}
}
