package tp.pp2.rpg.generator.core.entidades.interfaces;

import tp.pp2.rpg.generator.core.entidades.Personaje;

public interface Habilidad {
	Integer daniar(Personaje personajeAtacado);
	String getDescripcion();
}
