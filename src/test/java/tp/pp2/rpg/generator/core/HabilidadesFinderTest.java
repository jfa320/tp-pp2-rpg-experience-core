package tp.pp2.rpg.generator.core;

import java.util.Set;

import org.junit.Test;

import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.generator.core.extensible.HabilidadFinder;


public class HabilidadesFinderTest {
    
    @Test
	public void pruebaFind() throws Exception {
    	//System.getProperty para pararme donde esta el proyecto
        String path =  "src.test.resources.plugins";	
        HabilidadFinder campo = new HabilidadFinder();
        Set<Habilidad> clases=campo.findClasses(path);
        //Set<Campo> clases=campo.findClassesJAR(path);
        clases.forEach(c->System.out.println(c.getClass()));
	}
    

}
