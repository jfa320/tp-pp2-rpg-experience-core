package tp.pp2.rpg.generator.core.entidades;

import java.util.Map;
import java.util.Map.Entry;

public class ValidadorVictoria {
	public Integer validarVictoria(Map<Integer, Integer> vidas) {
		Integer contadorVidasMayorACero = 0;
		Integer claveEncontrada = -1;
        for (Entry<Integer, Integer> entry : vidas.entrySet()) {
            Integer valor = entry.getValue();
            if (valor > 0) {
                contadorVidasMayorACero++;
                claveEncontrada = entry.getKey();
            }
        }
        return contadorVidasMayorACero == 1 ? claveEncontrada : null;
	}
}
