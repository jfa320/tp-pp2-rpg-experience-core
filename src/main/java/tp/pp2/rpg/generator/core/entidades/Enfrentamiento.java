package tp.pp2.rpg.generator.core.entidades;

public class Enfrentamiento {
	private Personaje personaje1;
	private Personaje personaje2;
	private String personajeActivo;
	private Boolean batallaFinalizada;
	private String victoriaJugador;
	
	public Enfrentamiento(Personaje personaje1, Personaje personaje2, String personajeActivo) {
		this.personaje1 = personaje1;
		this.personaje2 = personaje2;
		this.personajeActivo = personajeActivo;
		this.batallaFinalizada=false;
		victoriaJugador="";
	}

	public Personaje getPersonaje1() {
		return personaje1;
	}

	public Personaje getPersonaje2() {
		return personaje2;
	}

	public String getPersonajeActivo() {
		return personajeActivo;
	}

	public void setPersonaje1(Personaje personaje1) {
		this.personaje1 = personaje1;
	}

	public void setPersonaje2(Personaje personaje2) {
		this.personaje2 = personaje2;
	}

	public void setPersonajeActivo(String personajeActivo) {
		this.personajeActivo = personajeActivo;
	}
	
	public Boolean getBatallaFinalizada() {
		return batallaFinalizada;
	}

	public String getVictoriaJugador() {
		return victoriaJugador;
	}

	public void setBatallaFinalizada(Boolean batallaFinalizada) {
		this.batallaFinalizada = batallaFinalizada;
	}

	public void setVictoriaJugador(String victoriaJugador) {
		this.victoriaJugador = victoriaJugador;
	}

	public void ejecutarHabilidad(Habilidad habilidadUsada) {
		int habilidadDanio=habilidadUsada.getDanio();
		switch (personajeActivo) {
		//TODO ARREGLAR ESTA REPETICION DE CODIGO
			case "P1":
				if(habilidadUsada.getTipo()=="F") {
					personaje2.setVidaActual(habilidadDanio*(personaje1.getAtaqueFisico()/100)*(1-personaje2.getDefensaFisica()/100));
				}else {
					personaje2.setVidaActual(habilidadDanio*(personaje1.getAtaqueEspecial()/100)*(1-personaje2.getDefensaEspecial()/100));
				}
				
				break;
			case "P2":
				if(habilidadUsada.getTipo()=="F") {
					personaje1.setVidaActual(habilidadDanio*(personaje2.getAtaqueFisico()/100)*(1-personaje1.getDefensaFisica()/100));
				}else {
					personaje1.setVidaActual(habilidadDanio*(personaje2.getAtaqueEspecial()/100)*(1-personaje1.getDefensaEspecial()/100));
				}
				break;	
			default:
				break;
		}
	}

	@Override
	public String toString() {
		return "Enfrentamiento [personaje1=" + personaje1 + ", personaje2=" + personaje2 + ", personajeActivo="
				+ personajeActivo + ", batallaFinalizada=" + batallaFinalizada + ", victoriaJugador=" + victoriaJugador
				+ "]";
	}
}