package tp.pp2.rpg.experience.core;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

    private Personaje p1;
    private Personaje p2;

    private Batalla batalla;
    private Map<Habilidad,Set<Personaje>> habilidades;
    private ValidadorVictoria validadorVictoria;
    
    private BatallaContexto contexto;
    private Map<Personaje,Set<Habilidad>> habilidadesActivadas;
    private Map<Personaje,Integer> vidas;
      
    @BeforeEach
    public void escenario(){
        
        MockitoAnnotations.openMocks(this);

        doAnswer(invocation -> {
            BatallaContexto bc = invocation.getArgument(0);

            if(!bc.getHabilidadesActivadas().containsKey(p1) || !bc.getHabilidadesActivadas().get(p1).contains(invisibilidad)){
                int vida =  bc.getVidas().get(p2);
                bc.getVidas().put(p2, vida -80);
            }
            return null;
        }).when(atacar).realizar(any(BatallaContexto.class));
        
        doAnswer(invocation -> {
            BatallaContexto bc = invocation.getArgument(0);
            
            if(!bc.getHabilidadesActivadas().containsKey(p1))
                bc.getHabilidadesActivadas().put(p1, new HashSet<>());
            
            bc.getHabilidadesActivadas().get(p1).add(invisibilidad);
            return null;
        }).when(invisibilidad).realizar(any(BatallaContexto.class));
    
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
        Assertions.assertEquals(0,batalla.vida(p2));
        Assertions.assertEquals("Fabian",batalla.ganador());
    }
    
    @Test
    public void CA2_evitarAtaque() throws Exception{
        batalla.jugar(invisibilidad);
        Assertions.assertEquals(p2,batalla.turno());
        batalla.jugar(atacar);
        Assertions.assertEquals(100,batalla.vida(p1));
    }

    @Test
    public void CA3_batallaNoFinalizada() throws Exception{
        batalla.jugar(invisibilidad);
        Assertions.assertEquals("Aun no hay ganador",batalla.ganador());
    }

}
