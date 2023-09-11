package tp.pp2.rpg.generator.core.extensible;

import tp.pp2.rpg.generator.core.entidades.Enfrentamiento;

public interface Campo {

    public String nombre ="";
    public Enfrentamiento cambioRegla(Enfrentamiento enfrentamiento);
}
