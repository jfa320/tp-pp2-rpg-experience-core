package tp.pp2.rpg.experience.core.eventos;

import java.util.Properties;
import java.util.Map.Entry;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaFinalizadaEvento implements BatallaEvento  {

	@Override
	public void onJugar(Batalla batalla) {
		this.validarFinalizacion(batalla);
	}
	
	private void validarFinalizacion(Batalla contexto) {
		int personajesVivos = 0;
		for (Entry<String, Properties> entry : contexto.getCaracteristicas().entrySet()) {
            Properties caracteristica = entry.getValue();
            String vida = caracteristica.getProperty("vida");
            if (Integer.valueOf(vida) > 0) {
            	personajesVivos++;
            }
        }
		if (personajesVivos == 1)
			contexto.setEstado(EstadoBatalla.FINALIZADA);
	}	
}
