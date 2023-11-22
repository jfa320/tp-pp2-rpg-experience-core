package tp.pp2.rpg.experience.core.eventos;

import java.util.Properties;
import java.util.Map.Entry;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaFinalizadaEvento implements BatallaEvento  {

	private Batalla batalla;
	
	public BatallaFinalizadaEvento(Batalla batalla) {
		this.batalla = batalla;
	}
	
	@Override
	public void onJugar() {
		this.validarFinalizacion();
	}
	
	private void validarFinalizacion() {
		int personajesVivos = 0;
		for (Entry<String, Properties> entry : batalla.getCaracteristicas().entrySet()) {
            Properties caracteristica = entry.getValue();
            String vida = caracteristica.getProperty("vida");
            if (Integer.valueOf(vida) > 0) {
            	personajesVivos++;
            }
        }
		if (personajesVivos == 1)
			batalla.setEstado(EstadoBatalla.FINALIZADA);
	}	
}
