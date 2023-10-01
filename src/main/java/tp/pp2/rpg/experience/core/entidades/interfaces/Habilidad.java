package tp.pp2.rpg.experience.core.entidades.interfaces;

import tp.pp2.rpg.experience.core.entidades.Personaje;

public interface Habilidad {
	Integer daniar(Personaje personajeAtacado);
	String getDescripcion();
}
