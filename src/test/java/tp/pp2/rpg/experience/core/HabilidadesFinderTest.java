package tp.pp2.rpg.experience.core;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HabilidadesFinderTest {
    
    private HabilidadFinder habilidadFinder;
    private String path;

    @BeforeEach
    public void escenario(){
        habilidadFinder = new HabilidadFinder();
        path = "src//test//resources//plugins//";
    }
    /* 
    @Test
    public void CA1_ubicacionInexistente(){
        Assertions.assertThrows(FileNotFoundException.class,
                                () -> habilidadFinder.findClasses(path + "ubicacionInexistente"));
    }

    @Test
    public void CA2_ubicacionInvalida(){
        Assertions.assertThrows(FileNotFoundException.class,
                                () -> habilidadFinder.findClasses(path + "archivo.txt"));
    }
    
    @Test
    public void CA3_carpetaVacia() throws Exception{
        
        Assertions.assertTrue(habilidadFinder.findClasses(path + "carpetaVacia").isEmpty());
    }

    @Test
    public void CA4_noEsHabilidad() throws Exception{
        Assertions.assertTrue(habilidadFinder.findClasses(path + "noEsHabilidad").isEmpty());
    }

    @Test
    public void CA5_unaHabilidad() throws Exception{
        List<Habilidad> habilidades= habilidadFinder.findClasses(path + "unaHabilidad");
        Assertions.assertEquals(1, habilidades.size());
        Assertions.assertEquals("Herir", habilidades.get(0).getClass().getName());
    }
 
    @Test
    public void CA6_habilidadesMultiples() throws Exception{
        List<Habilidad> habilidades= habilidadFinder.findClasses(path + "multiplesHabilidades");
        Assertions.assertEquals(2, habilidades.size());

        Set<String> nombreDeClases = new HashSet<>();


        for (Habilidad habilidad : habilidades)
           nombreDeClases.add(habilidad.getClass().getName());
        
        Assertions.assertTrue(nombreDeClases.contains("Corte"));
        Assertions.assertTrue(nombreDeClases.contains("Herir"));        
    }*/
}

