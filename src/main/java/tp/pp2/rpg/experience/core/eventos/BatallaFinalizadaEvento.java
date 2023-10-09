package tp.pp2.rpg.experience.core.eventos;

import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaFinalizadaEvento implements BatallaEvento  {

	@Override
	public void onJugar(Batalla batalla) {
		this.validarFinalizacion(batalla);
	}
	
	private void validarFinalizacion(Batalla contexto) {
		Map<String, Properties> personajes=contexto.getPersonajes();
		int personajesVivos = 0;

		for (String personaje : personajes.keySet()){
			int vida=Integer.parseInt(personajes.get(personaje).getProperty("vida"));
			if(vida > 0)
				personajesVivos++;
		}
		if (personajesVivos == 1)
			contexto.setEstado(EstadoBatalla.FINALIZADA);
	}

	
}
