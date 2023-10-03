package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;

public class ValidadorVictoria {
	private Personaje ganador;

	public ValidadorVictoria(){
		ganador = new Personaje(-1, "Aun no hay ganador");
	}


	public Personaje validar(Map<Personaje, Integer> vidas) {

		int personajesVivos = 0;
		
		for (Personaje p : vidas.keySet())
			if (vidas.get(p) > 0)
				personajesVivos++;
		
		if(personajesVivos == 1)
			buscarGanador(vidas);

		return ganador;
	}

	private void buscarGanador(Map<Personaje, Integer> vidas){
		for(Personaje p : vidas.keySet())
			if(vidas.get(p)>0)
				ganador = p;				
	}

	public String getGanador(){
		return ganador.getNombre().toString();
	}


	public void setGanador(Personaje ganador) {
		this.ganador = ganador;
	}
	
	
}
