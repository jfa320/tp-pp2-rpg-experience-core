package tp.pp2.rpg.generator.core.entidades.rpg.generator;

import java.util.Observable;

import tp.pp2.rpg.generator.core.entidades.Enfrentamiento;
import tp.pp2.rpg.generator.core.entidades.Habilidad;
import tp.pp2.rpg.generator.core.entidades.Personaje;

public class RpgBattleGenerator extends Observable {
	private Enfrentamiento enfrentamiento;

	public RpgBattleGenerator(Personaje personaje1, Personaje personaje2) {
		generarCombateBase(personaje1,personaje2);
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
	
	
	public Enfrentamiento getCombate() {
		return enfrentamiento;
	}

	public void setCombate(Enfrentamiento combate) {
		this.enfrentamiento = combate;
	}
	
	private void generarCombateBase(Personaje personaje1, Personaje personaje2) {
		enfrentamiento=new Enfrentamiento(personaje1, personaje2, "P1");
	}
		
}
