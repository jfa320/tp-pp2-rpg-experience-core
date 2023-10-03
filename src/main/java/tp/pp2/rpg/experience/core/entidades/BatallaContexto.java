package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;
import java.util.Set;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class BatallaContexto {
	Personaje turno;
	Map<Personaje,Integer> vidas;
	Map<Personaje,Set<Habilidad>> habilidadesActivadas;
	
	public BatallaContexto(Personaje turno, Map<Personaje, Integer> vidas,
			Map<Personaje, Set<Habilidad>> habilidadesActivadas) {
		this.turno = turno;
		this.vidas = vidas;
		this.habilidadesActivadas = habilidadesActivadas;
	}
	public Personaje getTurno() {
		return turno;
	}
	public Map<Personaje, Integer> getVidas() {
		return vidas;
	}
	public Map<Personaje, Set<Habilidad>> getHabilidadesActivadas() {
		return habilidadesActivadas;
	}
	public void setTurno(Personaje turno) {
		this.turno = turno;
	}
	public void setVidas(Map<Personaje, Integer> vidas) {
		this.vidas = vidas;
	}
	public void setHabilidadesActivadas(Map<Personaje, Set<Habilidad>> habilidadesActivadas) {
		this.habilidadesActivadas = habilidadesActivadas;
	}
 }
