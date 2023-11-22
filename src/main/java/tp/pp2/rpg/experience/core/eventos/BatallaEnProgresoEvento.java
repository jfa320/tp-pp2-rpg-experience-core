package tp.pp2.rpg.experience.core.eventos;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaEnProgresoEvento implements BatallaEvento {

	private Batalla batalla;

	public BatallaEnProgresoEvento(Batalla batalla) {
		this.batalla = batalla;
	}
	
	@Override
	public void onJugar() {
		this.cambiarEstadoEnProgreso();
	}

	private void cambiarEstadoEnProgreso() {
		if (batalla.getEstado().equals(EstadoBatalla.INICIADA))
			batalla.setEstado(EstadoBatalla.EN_PROGRESO);
	}

}
