package tp.pp2.rpg.experience.core;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.Personaje;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.excepciones.HabilidadInexistenteException;
import tp.pp2.rpg.experience.core.excepciones.TurnoIncorrectoException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BatallaTest {

    @Mock
    private Habilidad habilidad1;
    @Mock
    private Habilidad habilidad2;
    
    private Batalla batalla;
    
    private Personaje personaje1;
    private Personaje personaje2;
    

    @Before
    public void setUp(){
        
        MockitoAnnotations.openMocks(this);

        when(habilidad1.daniar(any())).thenReturn(-500);
        when(habilidad2.daniar(any())).thenReturn(-800);

        personaje1 = new Personaje(1, "personaje1", 50, 50);
        personaje2 = new Personaje(2, "personaje2", 100, 50);
        
        Map<Integer,Integer> vidas = new HashMap<>();
        vidas.put(1,1000);
        vidas.put(2,800);  
        
        batalla = new Batalla(1,vidas,null);
    }

    @Test
    public void CA1_ataqueValido() throws Exception{
        batalla.jugar(habilidad1, personaje1, personaje2);
        Assert.assertEquals((Integer)300, batalla.getVidas().get(personaje2.getId()));
    }
    
    @Test
    public void CA2_finalizarBatalla() throws Exception{
        batalla.jugar(habilidad2, personaje1, personaje2);
        Assert.assertEquals((Integer)1, batalla.getPersonajeGanadorId());
    }

    @Test(expected = TurnoIncorrectoException.class)
    public void CA3_turnoIncorrecto() throws Exception{
        batalla.jugar(habilidad1, personaje2, personaje1);
    }

    @Test(expected = HabilidadInexistenteException.class)
    public void CA4_habilidadInexistente() throws Exception{
        batalla.jugar(null, personaje1, personaje2);
    }
}
