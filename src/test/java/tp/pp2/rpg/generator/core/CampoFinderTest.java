package tp.pp2.rpg.generator.core;

import java.util.Set;

import org.junit.Test;

import tp.pp2.rpg.generator.core.extensible.Campo;
import tp.pp2.rpg.generator.core.extensible.CampoFinder;


public class CampoFinderTest {
    
    @Test
	public void pruebaFind() throws Exception {
    	//System.getProperty para pararme donde est� el proyecto
        String path =  System.getProperty("user.dir")+"\\src\\test\\resources\\plugins";
        CampoFinder campo = new CampoFinder();
     // Set<Object> clases=campo.findClassesJAR(path);
        Set<Campo> clases=campo.findClasses(path);
        clases.forEach(c->System.out.println(c.getClass()));
	}

}
