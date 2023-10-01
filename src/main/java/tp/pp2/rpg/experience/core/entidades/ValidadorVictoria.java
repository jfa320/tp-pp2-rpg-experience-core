package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;
import java.util.Map.Entry;

public class ValidadorVictoria {
	public Integer validarVictoria(Map<Integer, Integer> vidas) {

		Integer personajesVivos = 0;
		Integer noHayGanador = -1;
        Integer ultimoPersonajeVivo= -1;
        
        for (Entry<Integer, Integer> vidaPorPersonaje : vidas.entrySet()) {
            Integer vida = vidaPorPersonaje.getValue();
            if (vida > 0) {
                personajesVivos++;
                ultimoPersonajeVivo = vidaPorPersonaje.getKey();
            }
        }
        return personajesVivos == 1 ? ultimoPersonajeVivo : noHayGanador;
	}
}
