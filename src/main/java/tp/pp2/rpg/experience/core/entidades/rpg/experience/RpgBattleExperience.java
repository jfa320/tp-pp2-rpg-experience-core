package tp.pp2.rpg.experience.core.entidades.rpg.experience;
import java.util.Observable;


import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;


public class RpgBattleExperience extends Observable {
	private Batalla batalla;

	public RpgBattleExperience() {
	};

	public RpgBattleExperience(String pathConfigProperties) {
		BatallaInicializer BI= new BatallaInicializer();
		batalla = BI.generarBatalla(pathConfigProperties);
		BI = null;
	}

	public void jugar(Habilidad habilidad) throws Exception {
		batalla.jugar(habilidad);
		setChanged();
		notifyObservers(batalla);
	}

	public Batalla getBatalla() {
		return batalla;
	}

	public void setBatalla(Batalla batalla) {
		this.batalla = batalla;
	}
}
