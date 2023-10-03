package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;
import java.util.Set;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class BatallaContexto {
	Personaje turno;
	Map<Integer,Integer> vidas;
	Map<Integer,Set<Habilidad>> habilidadesActivadas;
	
	public BatallaContexto(Personaje turno, Map<Integer, Integer> vidas,
			Map<Integer, Set<Habilidad>> habilidadesActivadas) {
		this.turno = turno;
		this.vidas = vidas;
		this.habilidadesActivadas = habilidadesActivadas;
	}
	public Personaje getTurno() {
		return turno;
	}
	public Map<Integer, Integer> getVidas() {
		return vidas;
	}
	public Map<Integer, Set<Habilidad>> getHabilidadesActivadas() {
		return habilidadesActivadas;
	}
	public void setTurno(Personaje turno) {
		this.turno = turno;
	}
	public void setVidas(Map<Integer, Integer> vidas) {
		this.vidas = vidas;
	}
	public void setHabilidadesActivadas(Map<Integer, Set<Habilidad>> habilidadesActivadas) {
		this.habilidadesActivadas = habilidadesActivadas;
	}
	@Override
	public String toString() {
		return "BatallaContexto [turno=" + turno + ", vidas=" + vidas + ", habilidadesActivadas=" + habilidadesActivadas
				+ "]";
	}
	
 }
