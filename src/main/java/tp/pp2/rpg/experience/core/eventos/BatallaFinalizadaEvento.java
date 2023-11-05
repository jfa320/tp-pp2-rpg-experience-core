package tp.pp2.rpg.experience.core.eventos;

import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaFinalizadaEvento implements BatallaEvento  {

	@Override
	public void onJugar(Batalla batalla) {
		this.validarFinalizacion(batalla);
	}
	
	private void validarFinalizacion(Batalla contexto) {
		int personajesVivos = 0;

		for (Properties personaje : contexto.getPersonajes()){
			int vida = Integer.parseInt(personaje.getProperty("vida"));
			if(vida > 0)
				personajesVivos++;
		}
		if (personajesVivos == 1)
			contexto.setEstado(EstadoBatalla.FINALIZADA);
	}	
}
