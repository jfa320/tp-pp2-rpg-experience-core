package tp.pp2.rpg.generator.core.entidades.rpg.generator;

import java.util.List;
import java.util.Observable;

import tp.pp2.rpg.generator.core.entidades.Enfrentamiento;
import tp.pp2.rpg.generator.core.entidades.Habilidad;
import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.utils.ParserJSON;

public class RpgBattleGenerator extends Observable {
	private Enfrentamiento enfrentamiento;

	public RpgBattleGenerator(String datos) {
		List<Personaje> personajes=ParserJSON.parsearJSON(datos);
		//TODO: revisar esto. Lanzar excepcion quizas?
		if(personajes!=null) {
			generarCombateBase(personajes.get(0),personajes.get(1));
		}
	}

	
	public void ejecutarHabilidad(Habilidad habilidadUsada) {
		this.enfrentamiento.ejecutarHabilidad(habilidadUsada);
		setChanged();
		notifyObservers(enfrentamiento);
	}

	//Mover a otro lado?
	public void validarCombate() {
		if((enfrentamiento.getPersonaje1().getVidaActual() <= 0) || (enfrentamiento.getPersonaje2().getVidaActual() <= 0)){
			enfrentamiento.setBatallaFinalizada(true);
            if(enfrentamiento.getPersonaje1().getVidaActual()>=(enfrentamiento.getPersonaje2().getVidaActual())){
            	enfrentamiento.setVictoriaJugador("J1");
            }else {
            	enfrentamiento.setVictoriaJugador("J2");
            }
            setChanged();
    		notifyObservers(enfrentamiento);
        }
	}
	
	
	public Enfrentamiento getEnfrentamiento() {
		return enfrentamiento;
	}

	public void setEnfrentamiento(Enfrentamiento enfrentamiento) {
		this.enfrentamiento = enfrentamiento;
	}
	
	private void generarCombateBase(Personaje personaje1, Personaje personaje2) {
		enfrentamiento=new Enfrentamiento(personaje1, personaje2, "P1");
	}
		
}
