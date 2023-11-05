package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class ObtenedorGanador {
	
	public String obtenerGanador(Batalla contexto) {
		if(contexto.getEstado().equals(EstadoBatalla.FINALIZADA)) {

			for (Properties personaje : contexto.getPersonajes()){
				int vida = Integer.valueOf(personaje.getProperty("vida"));
				if(vida > 0)
					return personaje.getProperty("nombre");
			}
		} 
		return "No hay ganador";
	}
	
}
