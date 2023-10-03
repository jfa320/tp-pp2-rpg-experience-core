package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;
import java.util.Set;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.excepciones.HabilidadInexistenteException;

public class Batalla {
	private Map<Habilidad,Set<Personaje>> habilidades;
	private ValidadorVictoria validadorVictoria;
	private BatallaContexto contexto;

	public Batalla() {
	}

	public Batalla(Map<Habilidad, Set<Personaje>> habilidades, ValidadorVictoria validadorVictoria,
			BatallaContexto contexto) {
		this.habilidades = habilidades;
		this.validadorVictoria = validadorVictoria;
		this.contexto = contexto;
	}

	public void jugar(Habilidad habilidad) throws Exception {

		if (habilidad == null)
			throw new HabilidadInexistenteException();

		// realiza efecto habilidad
		habilidad.realizar(this.getContexto());

		// valida ganador
		validadorVictoria.validar(contexto.getVidas());
/*
		// cambia turno
		if (indexTurno <= vidas.size()) {
			validadorVictoria.validarVictoria(vidas);
			turno = (new ArrayList<>(vidas.keySet())).get(indexTurno);
			indexTurno++;
		} else {
			indexTurno = 0;
		}*/
	}

	public Map<Habilidad, Set<Personaje>> getHabilidades() {
		return habilidades;
	}

	public BatallaContexto getContexto() {
		return contexto;
	}

	public void setHabilidades(Map<Habilidad, Set<Personaje>> habilidades) {
		this.habilidades = habilidades;
	}

	public void setContexto(BatallaContexto contexto) {
		this.contexto = contexto;
	}

	public ValidadorVictoria getValidadorVictoria() {
		return validadorVictoria;
	}

	public void setValidadorVictoria(ValidadorVictoria validadorVictoria) {
		this.validadorVictoria = validadorVictoria;
	}

	@Override
	public String toString() {
		return "Batalla [habilidades=" + habilidades + ", validadorVictoria=" + validadorVictoria.toString() + ", contexto="
				+ contexto.toString() + "]";
	}
	
}
