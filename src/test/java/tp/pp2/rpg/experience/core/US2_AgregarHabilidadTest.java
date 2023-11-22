package tp.pp2.rpg.experience.core;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class US2_AgregarHabilidadTest {
    
    private HabilidadFinder habilidadFinder;
    private String pathHabilidades;
    @BeforeEach
    public void escenario(){
        pathHabilidades = "src\\test\\resources\\plugins\\";
        habilidadFinder = new HabilidadFinder();
    }
     
    @Test
    public void CA1_ubicacionInexistente(){
        assertThrows(FileNotFoundException.class,
                                () -> habilidadFinder.findClasses(pathHabilidades + "ubicacionInexistente"));
    }

    @Test
    public void CA2_ubicacionInvalida(){
        assertThrows(IllegalArgumentException.class,
                                () -> habilidadFinder.findClasses(pathHabilidades +"archivo.txt"));
    }
    
    @Test
    public void CA3_carpetaVacia() throws Exception{
        
        assertTrue(habilidadFinder.findClasses(pathHabilidades +"carpetaVacia").isEmpty());
    }

    @Test
    public void CA4_noEsHabilidad() throws Exception{
        assertTrue(habilidadFinder.findClasses(pathHabilidades +"noEsHabilidad").isEmpty());
    }

    @Test
    public void CA5_unaHabilidad() throws Exception{
        List<Habilidad> habilidades= habilidadFinder.findClasses(pathHabilidades + "unaHabilidad");
        assertEquals(1, habilidades.size());
        assertEquals("Herir", habilidades.get(0).getClass().getName());
    }
 
    @Test
    public void CA6_habilidadesMultiples() throws Exception{
        List<Habilidad> habilidades= habilidadFinder.findClasses(pathHabilidades +"multiplesHabilidades");
        assertEquals(2, habilidades.size());

        Set<String> nombreDeClases = new HashSet<>();


        for (Habilidad habilidad : habilidades)
           nombreDeClases.add(habilidad.getClass().getName());
        
        assertTrue(nombreDeClases.contains("Corte"));
        assertTrue(nombreDeClases.contains("Herir"));        
    }
}

