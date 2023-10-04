package tp.pp2.rpg.experience.core;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
    private Map<Integer,Set<Habilidad>> habilidadesActivadas;
    private Map<Integer,Integer> vidas;
      
    @BeforeEach
    public void escenario(){
        
        MockitoAnnotations.openMocks(this);

        doAnswer(invocation -> {
            BatallaContexto bc = invocation.getArgument(0);

            if(!bc.getHabilidadesActivadas().containsKey(p1.getId()) || !bc.getHabilidadesActivadas().get(p1.getId()).contains(invisibilidad)){
                int vida =  bc.getVidas().get(p2.getId());
                bc.getVidas().put(p2.getId(), vida -80);
            }
            return null;
        }).when(atacar).realizar(any(BatallaContexto.class));
        
        doAnswer(invocation -> {
            BatallaContexto bc = invocation.getArgument(0);
            
            if(!bc.getHabilidadesActivadas().containsKey(p1.getId()))
                bc.getHabilidadesActivadas().put(p1.getId(), new HashSet<>());
            
            bc.getHabilidadesActivadas().get(p1.getId()).add(invisibilidad);
            return null;
        }).when(invisibilidad).realizar(any(BatallaContexto.class));
    
        p1 = new Personaje(1, "Fabian");
        p2 = new Personaje(2, "Martin");
        List<Personaje> personajes=Arrays.asList(p1,p2);
        habilidadesActivadas = new HashMap<>();
        validadorVictoria = new ValidadorVictoria();
        vidas = new HashMap<>();
        vidas.put(p1.getId(),100);
        vidas.put(p2.getId(),80);
        
        contexto = new BatallaContexto(p1,vidas,habilidadesActivadas);
        batalla = new Batalla(habilidades,validadorVictoria,personajes,contexto);
    }

    @Test
    public void CA1_ataqueValido() throws Exception{
        batalla.jugar(atacar);
        Assertions.assertEquals(0,batalla.vida(p2));
        Assertions.assertEquals(p1.getId(),batalla.getGanador());
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
        Assertions.assertEquals(-1,batalla.getGanador());
    }

}
