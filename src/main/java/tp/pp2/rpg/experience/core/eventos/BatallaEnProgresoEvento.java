package tp.pp2.rpg.experience.core.eventos;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaEnProgresoEvento implements BatallaEvento {

	@Override
	public void onJugar(Batalla batalla) {
		this.cambiarEstadoEnProgreso(batalla);
	}

	private void cambiarEstadoEnProgreso(Batalla contexto) {
		if (contexto.getEstado().equals(EstadoBatalla.INICIADA))
			contexto.setEstado(EstadoBatalla.EN_PROGRESO);
	}

}
