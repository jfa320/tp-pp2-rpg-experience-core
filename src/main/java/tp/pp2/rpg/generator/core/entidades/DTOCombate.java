package tp.pp2.rpg.generator.core.entidades;

public class DTOCombate {
	private DTOPersonaje personaje;
	private DTOPersonaje enemigo;
	private Boolean victoriaJugador;
	private Boolean batallaFinalizada;

	public DTOCombate() {
	};

	public DTOCombate(DTOPersonaje personaje, DTOPersonaje enemigo, Boolean victoriaJugador,
			Boolean batallaFinalizada) {
		super();
		this.personaje = personaje;
		this.enemigo = enemigo;
		this.victoriaJugador = victoriaJugador;
		this.batallaFinalizada = batallaFinalizada;
	}

	public DTOPersonaje getPersonaje() {
		return personaje;
	}

	public DTOPersonaje getEnemigo() {
		return enemigo;
	}

	public Boolean getVictoriaJugador() {
		return victoriaJugador;
	}

	public Boolean getBatallaFinalizada() {
		return batallaFinalizada;
	}

	public void setPersonaje(DTOPersonaje personaje) {
		this.personaje = personaje;
	}

	public void setEnemigo(DTOPersonaje enemigo) {
		this.enemigo = enemigo;
	}

	public void setVictoriaJugador(Boolean victoriaJugador) {
		this.victoriaJugador = victoriaJugador;
	}

	public void setBatallaFinalizada(Boolean batallaFinalizada) {
		this.batallaFinalizada = batallaFinalizada;
	}

	@Override
	public String toString() {
		return "DTOBatalla [personaje=" + personaje.getNombrePersonaje() + ", enemigo=" + enemigo.getNombrePersonaje()
				+ ", victoriaJugador=" + victoriaJugador + ", batallaFinalizada=" + batallaFinalizada + "]";
	}

}