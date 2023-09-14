package tp.pp2.rpg.generator.core.entidades;

import java.util.Map;

import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;

public class Batalla {
	private Integer turno;
	private Map<Integer, Integer> vidas;
	private Integer personajeGanadorId;
	
	public Batalla() {}

	public Batalla(Integer turno, Map<Integer, Integer> vidas, Integer personajeGanadorId) {
		this.turno = turno;
		this.vidas = vidas;
		this.personajeGanadorId = personajeGanadorId;
	}

	public Integer getTurno() {
		return turno;
	}

	public Map<Integer, Integer> getVidas() {
		return vidas;
	}

	public Integer getPersonajeGanadorId() {
		return personajeGanadorId;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public void setVidas(Map<Integer, Integer> vidas) {
		this.vidas = vidas;
	}

	public void setPersonajeGanadorId(Integer personajeGanadorId) {
		this.personajeGanadorId = personajeGanadorId;
	}

	@Override
	public String toString() {
		return "Batalla [turno=" + turno + ", vidas=" + vidas + ", personajeGanadorId=" + personajeGanadorId + "]";
	};
	
	public void calcularDaño(Habilidad habilidad,Personaje personajeAtacante, Personaje personajeAtacado) {
		habilidad.dañar(personajeAtacado);
	}
}
