package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class ObtenedorGanador {
	
	public String obtenerGanador(Batalla contexto) {
		if(contexto.getEstado().equals(EstadoBatalla.FINALIZADA)) {
			for (String personaje : contexto.getPersonajes().keySet()){
				int vida = Integer.parseInt(contexto.getPersonajes().get(personaje).getProperty("vida"));
				if(vida > 0)
					return personaje;
			}
		} 
		return "No hay ganador";
	}
	
}
