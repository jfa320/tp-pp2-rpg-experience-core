package tp.pp2.rpg.experience.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.BatallaContexto;
import tp.pp2.rpg.experience.core.entidades.Personaje;
import tp.pp2.rpg.experience.core.entidades.ValidadorVictoria;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;


public class BatallaTest {

    @Mock
    private Habilidad atacar;
    @Mock
    private Habilidad invisibilidad;
    private Batalla batalla;
    private Map<Personaje,Set<Habilidad>> habilidadesActivadas;
    private Map<Habilidad,Set<Personaje>> habilidades;
    private ValidadorVictoria validadorVictoria;
    private Map<Personaje,Integer> vidas;
    private BatallaContexto contexto;
    private Personaje p1;
    private Personaje p2;
    
    @BeforeAll
    public void escenario(){
        
        p1 = new Personaje(1, "Fabian");
        p2 = new Personaje(2, "Martin");
        
        habilidadesActivadas = new HashMap<>();
        validadorVictoria = new ValidadorVictoria();
        vidas = new HashMap<>();
        vidas.put(p1,100);
        vidas.put(p2,80);

        contexto = new BatallaContexto(p1,vidas,habilidadesActivadas);
        batalla = new Batalla(habilidades,validadorVictoria,contexto);
    }

    @Test
    public void CA1_ataqueValido() throws Exception{
        batalla.jugar(atacar);
        //Assertions.assertEquals(batalla.vida(p2), 0);
    }
    
    @Test
    public void CA2_evitarAtaque() throws Exception{
        batalla.jugar(invisibilidad);
        //Assertions.assertEquals(batalla.turno(), p2);
        batalla.jugar(atacar);
        //Assertions.assertEquals(batalla.vida(p1), 100);
    }

    @Test
    public void CA3_batallaNoFinalizada() throws Exception{
        batalla.jugar(atacar);
        //Assertions.assertEquals(batalla.ganador(), "");
    }

}
