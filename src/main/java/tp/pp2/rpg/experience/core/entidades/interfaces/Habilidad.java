package tp.pp2.rpg.experience.core.entidades.interfaces;

import tp.pp2.rpg.experience.core.entidades.BatallaContexto;

public interface Habilidad {
	void realizar(BatallaContexto contexto);
	String getDescripcion();
	String getNombre();
}
