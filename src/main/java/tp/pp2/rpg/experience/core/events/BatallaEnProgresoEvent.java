package tp.pp2.rpg.experience.core.events;

import java.util.Observable;
import java.util.Observer;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaEnProgresoEvent implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		Batalla contexto=(Batalla) arg;
		this.cambiarEstadoEnProgreso(contexto);
	}

	private void cambiarEstadoEnProgreso(Batalla contexto) {
		if(contexto.getEstado().equals(EstadoBatalla.INICIADA))
			contexto.setEstado(EstadoBatalla.EN_PROGRESO);
	}
	
}
