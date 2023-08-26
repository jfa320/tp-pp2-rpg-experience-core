package tp.pp2.rpg.generator.core.entidades.rpg.generator;

import java.io.File;
import java.util.Arrays;
import java.util.Observable;

import tp.pp2.rpg.generator.core.entidades.DTOCombate;
import tp.pp2.rpg.generator.core.entidades.DTOHabilidad;
import tp.pp2.rpg.generator.core.entidades.DTOPersonaje;

public class RpgGenerator extends Observable {
	//private boolean asigneHabilidades;
	private DTOCombate combate;
	private DTOPersonaje jugador1;
	private DTOPersonaje jugadorEnemigo;

	public RpgGenerator() {
		//asigneHabilidades = false;
		generarCombateBase();
	}

	private void generarCombateBase() {
		// TODO recibir params?
		jugador1=new DTOPersonaje("Mago oscuro", "Mago", 100,
				Arrays.asList(
						new DTOHabilidad(1, "Hechizo", "Mago", 10), 
						new DTOHabilidad(2, "Quemar", "Mago", 20),
						new DTOHabilidad(3, "Congelar", "Mago", 30), 
						new DTOHabilidad(4, "Terremoto", "Mago", 40))
				);
		jugadorEnemigo=new DTOPersonaje("Espadachin", "Espada", 100, 
				Arrays.asList(
						new DTOHabilidad(1, "Espadazo", "Espada", 10), 
						new DTOHabilidad(2, "Desangrar", "Espada", 20),
						new DTOHabilidad(3, "Golpe doble", "Espada", 30), 
						new DTOHabilidad(4, "Glope de furia", "Espada", 40))
				);
		combate=new DTOCombate(jugador1, jugadorEnemigo, false, false);
	}
	public void atacarJ2(DTOHabilidad habilidadUsada) {
		int danioCausado= jugadorEnemigo.getVida()-habilidadUsada.getDanio();
		jugadorEnemigo.setVida(danioCausado);
		setChanged();
		notifyObservers(jugadorEnemigo);
	}
	public void validarCombate() {
		if((combate.getPersonaje().getVida() <= 0) || (combate.getEnemigo().getVida()<= 0)){
			combate.setBatallaFinalizada(true);
            if(combate.getPersonaje().getVida()>=(combate.getEnemigo().getVida())){
            	combate.setVictoriaJugador(true);
            }
            setChanged();
    		notifyObservers(combate);
        }
	}
	/*private void asignarHabilidades() {
		// TODO
	}

	public boolean isArchivoLeido() {
		return asigneHabilidades;
	}

	public void setAsigneHabilidades(boolean asigneHabilidades) {
		this.asigneHabilidades = asigneHabilidades;
		// notifico a los observers del cambio
		setChanged();
		notifyObservers(asigneHabilidades);
	}*/

	/*public boolean getAsigneHabilidades() {
		return this.asigneHabilidades;
	}*/

	public DTOPersonaje getJugador1() {
		return jugador1;
	}

	public void setJugador1(DTOPersonaje jugador1) {
		this.jugador1 = jugador1;
	}

	public DTOPersonaje getJugador2() {
		return jugadorEnemigo;
	}

	public void setJugador2(DTOPersonaje jugador2) {
		this.jugadorEnemigo = jugador2;
	}

	public DTOCombate getCombate() {
		return combate;
	}

	public DTOPersonaje getJugadorEnemigo() {
		return jugadorEnemigo;
	}

	public void setCombate(DTOCombate combate) {
		this.combate = combate;
	}

	public void setJugadorEnemigo(DTOPersonaje jugadorEnemigo) {
		this.jugadorEnemigo = jugadorEnemigo;
	}

}
