package tp.pp2.rpg.experience.core.entidades;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.excepciones.HabilidadInexistenteException;

public class Batalla {
	private Personaje turno;
	private int indexTurno;
	private Map<Personaje, Integer> vidas;
	private Map<Habilidad, Set<Personaje>> estadoHabilidad;
	private ValidadorVictoria validadorVictoria;

	public Batalla() {
	}

	public Personaje getTurno() {
		return turno;
	}

	public Map<Personaje, Integer> getVidas() {
		return vidas;
	}

	public Map<Habilidad, Set<Personaje>> getEstadoHabilidad() {
		return estadoHabilidad;
	}

	public void setTurno(Personaje turno) {
		this.turno = turno;
	}

	public void setVidas(Map<Personaje, Integer> vidas) {
		this.vidas = vidas;
	}

	public void setEstadoHabilidad(Map<Habilidad, Set<Personaje>> estadoHabilidad) {
		this.estadoHabilidad = estadoHabilidad;
	}

	@Override
	public String toString() {
		return "Batalla [turno=" + turno + ", vidas=" + vidas + ", estadoHabilidad=" + estadoHabilidad + "]";
	}

	public void jugar(Habilidad habilidad) throws Exception {

		if (habilidad == null)
			throw new HabilidadInexistenteException();

		// realiza efecto habilidad
		habilidad.realizarEfecto(this);

		// valida ganador
		Personaje personajeGanador = validadorVictoria.validarVictoria(vidas);

		// cambia turno
		if (indexTurno <= vidas.size()) {
			validadorVictoria.validarVictoria(vidas);
			turno = (new ArrayList<>(vidas.keySet())).get(indexTurno);
			indexTurno++;
		} else {
			indexTurno = 0;
		}
	}

	public ValidadorVictoria getValidadorVictoria() {
		return validadorVictoria;
	}

	public void setValidadorVictoria(ValidadorVictoria validadorVictoria) {
		this.validadorVictoria = validadorVictoria;
	}
}
