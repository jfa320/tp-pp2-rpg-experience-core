package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class ObtenedorGanador {
	
	public String obtenerGanador(Batalla contexto) {
		if(contexto.getEstado().equals(EstadoBatalla.FINALIZADA)) {
			for (String personajeNombre : contexto.getPersonajes().keySet()){
				int vida = Integer.parseInt(contexto.getPersonajes().get(personajeNombre).getProperty("vida"));
				if(vida > 0)
					return personajeNombre;
			}
		} 
		return "No hay ganador";
	}
	
}
