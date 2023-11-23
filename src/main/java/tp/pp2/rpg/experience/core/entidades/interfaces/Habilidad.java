package tp.pp2.rpg.experience.core.entidades.interfaces;

import tp.pp2.rpg.experience.core.entidades.Batalla;

public interface Habilidad {
	void realizar();
	String getNombre();
	String getDescripcion();
	void setBatallaInicial(Batalla batalla);
}
