package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.util.Map.Entry;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class ObtenedorGanador {
	
	public String obtenerGanador(Batalla contexto) {
		if(contexto.getEstado().equals(EstadoBatalla.FINALIZADA)) {
			for (Entry<String, Properties> entry : contexto.getCaracteristicas().entrySet()) {
	            Properties caracteristica = entry.getValue();
	            String vida = caracteristica.getProperty("vida");
	            if (Integer.valueOf(vida) > 0) {
	                String nombrePersonaje = entry.getKey();
	                return nombrePersonaje;
	            }
	        }
		} 
		return "No hay ganador";
	}
	
}
