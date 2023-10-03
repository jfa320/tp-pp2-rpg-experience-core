package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;
import java.util.Map.Entry;

public class ValidadorVictoria {
	private Personaje ganador;

	public Personaje validar(Map<Personaje, Integer> vidas) {

		Integer personajesVivos = 0;
		Personaje noHayGanador = new Personaje(-1, "Aún no hay ganador");
		Personaje ultimoPersonajeVivo=new Personaje(-1, "Aún hay varios personajes en batalla");
		
		for (Entry<Personaje, Integer> vidaPorPersonaje : vidas.entrySet()) {
			Integer vida = vidaPorPersonaje.getValue();
			if (vida > 0) {
				personajesVivos++;
				ultimoPersonajeVivo = vidaPorPersonaje.getKey();
			}
		}

		if (personajesVivos == 1) {
			ganador = ultimoPersonajeVivo;
		}
		
		return personajesVivos == 1 ? ultimoPersonajeVivo : noHayGanador;
	}

	public Personaje getGanador() {
		return ganador;
	}

	public void setGanador(Personaje ganador) {
		this.ganador = ganador;
	}
	
	
}
