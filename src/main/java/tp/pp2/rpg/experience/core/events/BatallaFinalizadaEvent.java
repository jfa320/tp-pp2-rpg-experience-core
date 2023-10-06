package tp.pp2.rpg.experience.core.events;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaFinalizadaEvent extends BatallaEvent implements Observer  {
	private String ganador;

	@Override
	public void update(Observable o, Object arg) {
		Batalla contexto=(Batalla) arg;
		this.validarFinalizacion(contexto);
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
