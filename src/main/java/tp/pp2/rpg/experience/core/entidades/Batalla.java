package tp.pp2.rpg.experience.core.entidades;

import java.util.Map;
import java.util.Set;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.excepciones.HabilidadInexistenteException;

public class Batalla {
	private Map<Habilidad,Set<Personaje>> habilidades;
	private ValidadorVictoria validadorVictoria;
	private BatallaContexto contexto;
	private Turnero turnero;

	public Batalla() {
	}

	public Batalla(Map<Habilidad, Set<Personaje>> habilidades, ValidadorVictoria validadorVictoria,
			BatallaContexto contexto) {
		this.habilidades = habilidades;
		this.validadorVictoria = validadorVictoria;
		this.contexto = contexto;
		this.turnero = new Turnero(contexto.getVidas().keySet());
	}

	public void jugar(Habilidad habilidad) throws Exception {

		if (habilidad == null)
			throw new HabilidadInexistenteException();

		// realiza efecto habilidad
		habilidad.realizar(this.getContexto());

		// valida ganador
		validadorVictoria.validar(contexto.getVidas());

		// cambia turno
		turnero.cambiaTurno(contexto);
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

	public int vida(Personaje p){
		return contexto.getVidas().get(p);
	}

	public String ganador(){
		return validadorVictoria.getGanador();
	}

	public Personaje turno(){
		return contexto.getTurno();
	}
}
