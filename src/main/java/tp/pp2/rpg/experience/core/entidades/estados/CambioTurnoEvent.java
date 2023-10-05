package tp.pp2.rpg.experience.core.entidades.estados;

import java.util.List;

import java.util.Observable;
import java.util.Observer;

public class CambioTurnoEvent extends BatallaEvent implements Observer {
	private String personajeActual;
	private List<String> personajes;

	public CambioTurnoEvent(List<String> personajes) {
		this.personajes = personajes;
		this.personajeActual = personajes.get(0);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.cambiaTurno();
	}

	private void cambiaTurno() {
		int i = personajes.indexOf(personajeActual);
		if (i < personajes.size() - 1)
			personajeActual= personajes.get(i + 1);
		else
			personajeActual= personajes.get(0);
	}

	public String getPersonajeActual() {
		return personajeActual;
	}

}
