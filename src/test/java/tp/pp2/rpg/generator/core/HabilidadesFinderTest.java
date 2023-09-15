package tp.pp2.rpg.generator.core;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.generator.core.extensible.HabilidadFinder;


public class HabilidadesFinderTest {
    
    private HabilidadFinder habilidadFinder;

    @Before
    public void setUp(){
        habilidadFinder = new HabilidadFinder();
    }
      
    @Test(expected = FileNotFoundException.class)
    public void ubicacionInexistente() throws Exception{
        habilidadFinder.findClasses("ubicacionInexistente");
    }

    @Test(expected = FileNotFoundException.class)
    public void ubicacionInvalida() throws Exception{
         habilidadFinder.findClasses("src\\test\\resources\\plugins\\archivo.txt");
    }
    
    @Test
    public void carpetaVacia() throws Exception{
        Assert.assertTrue(habilidadFinder.findClasses("src\\test\\resources\\plugins\\carpetaVacia").isEmpty());
    }

    @Test
    public void noEsHabilidad() throws Exception{
        Assert.assertTrue(habilidadFinder.findClasses("src\\test\\resources\\plugins\\noEsHabilidad").isEmpty());
    }

    @Test
    public void unaHabilidad() throws Exception{
        List<Habilidad> habilidades= habilidadFinder.findClasses("src\\test\\resources\\plugins\\unaHabilidad");
        Assert.assertEquals(1, habilidades.size());
        Assert.assertEquals("Herir", habilidades.get(0).getClass().getName());
    }

    @Test
    public void habilidadesMultiples() throws Exception{
        List<Habilidad> habilidades= habilidadFinder.findClasses("src\\test\\resources\\plugins\\multiplesHabilidades");
        Assert.assertEquals(2, habilidades.size());
        Assert.assertEquals("Corte", habilidades.get(0).getClass().getName());
        Assert.assertEquals("Herir", habilidades.get(1).getClass().getName());
    }
}
