package tp.pp2.rpg.generator.core;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tp.pp2.rpg.generator.core.entidades.Batalla;
import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;

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
    public void ataqueValido(){
        batalla.calcularDanio(habilidad1, personaje1, personaje2);
        Assert.assertEquals((Integer)300, batalla.getVidas().get(personaje2.getId()));
    }
    
    @Test
    public void finalizarBatalla(){
        batalla.calcularDanio(habilidad2, personaje1, personaje2);
        Assert.assertEquals((Integer)1, batalla.getPersonajeGanadorId());
    }

    @Test(expected = ArithmeticException.class)
    public void turnoIncorrecto(){
        batalla.calcularDanio(habilidad1, personaje2, personaje1);
    }

    @Test(expected = RuntimeException.class)
    public void habilidadInexistente(){
        batalla.calcularDanio(null, personaje1, personaje2);
    }
}
