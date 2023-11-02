package tp.pp2.rpg.experience.core.entidades;

import java.util.ArrayList;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class ActualizadorTurno {
	private ArrayList<Properties> personajes;

	public ActualizadorTurno(Batalla batalla) {
		this.personajes = batalla.getPersonajes();
		batalla.setPersonajeActual(1);
	}

	public void cambiarTurno(Batalla batalla) {
		if (!batalla.getEstado().equals(EstadoBatalla.FINALIZADA)) {
			int index = batalla.getPersonajeActual();
			if (index < personajes.size() - 1)
				batalla.setPersonajeActual(index + 1);
			else
				batalla.setPersonajeActual(1);
		}
	}
}
