package tp.pp2.rpg.generator.core;

import java.util.Set;

import org.junit.Test;

import tp.pp2.rpg.generator.core.extensible.Campo;
import tp.pp2.rpg.generator.core.extensible.CampoFinder;


public class CampoFinderTest {
    
    @Test
	public void pruebaFind() throws Exception {
    	//System.getProperty para pararme donde esta el proyecto
        String path =  "src.test.resources.plugins";	
        CampoFinder campo = new CampoFinder();
        Set<Campo> clases=campo.findClasses(path);
        //Set<Campo> clases=campo.findClassesJAR(path);
        clases.forEach(c->System.out.println(c.getClass()));
	}
    

}
