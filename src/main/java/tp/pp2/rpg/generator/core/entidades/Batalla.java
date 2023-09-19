package tp.pp2.rpg.generator.core.entidades;

import java.util.Map;

import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.generator.core.excepciones.HabilidadInexistenteException;
import tp.pp2.rpg.generator.core.excepciones.TurnoIncorrectoException;

public class Batalla {
	private Integer turno;
	private Map<Integer, Integer> vidas;
	private Integer personajeGanadorId;
	private ValidadorVictoria validadorVictoria;
	
	public Batalla() {}

	public Batalla(Integer turno, Map<Integer, Integer> vidas, Integer personajeGanadorId) {
		this.turno = turno;
		this.vidas = vidas;
		this.personajeGanadorId = personajeGanadorId;
		validadorVictoria = new ValidadorVictoria();
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
	
	public void jugar(Habilidad habilidad,Personaje personajeAtacante, Personaje personajeAtacado) throws Exception {

		if(habilidad == null)
			throw new HabilidadInexistenteException();

		if(turno != personajeAtacante.getId())
			throw new TurnoIncorrectoException();

		// realiza calculo de danio
		Integer danioPorRealizar = habilidad.daniar(personajeAtacado);
		Integer vidaPersonajeAtacado = vidas.get(personajeAtacado.getId());
		vidas.put(personajeAtacado.getId(), vidaPersonajeAtacado + danioPorRealizar);

		// valida ganador
		Integer idGanador = validadorVictoria.validarVictoria(vidas);
		if (idGanador != -1) 
			personajeGanadorId = idGanador;

		// cambia turno
	/*	if (turno <= vidas.size())
			turno ++;
		else
			turno = 1;	*/
	}

	public ValidadorVictoria getValidadorVictoria() {
		return validadorVictoria;
	}

	public void setValidadorVictoria(ValidadorVictoria validadorVictoria) {
		this.validadorVictoria = validadorVictoria;
	}
}
