package tp.pp2.rpg.experience.core.entidades.estados;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;

public class VictoriaEvent extends BatallaEvent implements Observer  {
	private String ganador;
	
	public VictoriaEvent() {
		ganador="Aun no hay ganador";
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Batalla contexto=(Batalla) arg;
		this.validar(contexto.getPersonajes());
	}
	
	public void validar(Map<String, Properties> personajes) {
		int personajesVivos = 0;

		for (String personaje : personajes.keySet()){
			int vida =Integer.parseInt(personajes.get(personaje).getProperty("vida"));
			if(vida > 0)
				personajesVivos++;
		}

		if (personajesVivos == 1)
			buscarGanador(personajes);
	}
	
	private void buscarGanador(Map<String, Properties> personajes) {
		for (String personaje : personajes.keySet()){
			int vida =Integer.parseInt(personajes.get(personaje).getProperty("vida"));
			if(vida > 0)
				setGanador(personaje);
		}
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
}
