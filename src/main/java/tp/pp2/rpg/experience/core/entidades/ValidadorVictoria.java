package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;

public class ValidadorVictoria {
	private Integer idPersonajeGanador;

	public ValidadorVictoria() {
		idPersonajeGanador = -1;
	}
	
	public void validar(Map<Integer, Integer> vidas) {
		int personajesVivos = 0;

		for (Integer idPersonajeActual : vidas.keySet())
			if (vidas.get(idPersonajeActual) > 0)
				personajesVivos++;

		if (personajesVivos == 1)
			buscarGanador(vidas);

	}
	
	private void buscarGanador(Map<Integer, Integer> vidas) {
		for (Integer idPersonajeActual : vidas.keySet())
			if (vidas.get(idPersonajeActual) > 0)
				idPersonajeGanador = idPersonajeActual;
	}

	public Integer getGanador() {
		return idPersonajeGanador;
	}

	public void setGanador(Integer idPersonaje) {
		this.idPersonajeGanador = idPersonaje;
	}

	

}
