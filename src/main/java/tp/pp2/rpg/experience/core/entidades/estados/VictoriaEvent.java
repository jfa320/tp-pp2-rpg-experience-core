package tp.pp2.rpg.experience.core.entidades.estados;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import tp.pp2.rpg.experience.core.entidades.BatallaContexto;
import tp.pp2.rpg.experience.core.entidades.Personaje;

public class VictoriaEvent extends BatallaEvent implements Observer  {
	private Personaje ganador;
	private List<Personaje> personajes;
	
	
	public VictoriaEvent(List<Personaje> personajes) {
		this.personajes = personajes;
		ganador=new Personaje(-1,"Aún no hay ganador");
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		BatallaContexto contexto=(BatallaContexto) arg;
		this.validar(contexto.getVidas());
	}
	
	public void validar(Map<Integer, Integer> vidas) {
		int personajesVivos = 0;
		for (Integer idPersonajeActual : vidas.keySet())
			if (vidas.get(idPersonajeActual) > 0)
				personajesVivos++;

		if (personajesVivos == 1)
			buscarGanador(vidas);
	}
	
	private void buscarGanador(Map<Integer, Integer> vidas) {
		for (Integer idPersonajeActual : vidas.keySet())
			if (vidas.get(idPersonajeActual) > 0)
				setGanador(personajes.get(idPersonajeActual-1));
	}

	public Personaje getGanador() {
		return ganador;
	}

	public void setGanador(Personaje ganador) {
		this.ganador = ganador;
	}
}
