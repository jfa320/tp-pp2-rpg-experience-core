package tp.pp2.rpg.generator.core;

import java.util.Set;

import org.junit.Test;

import tp.pp2.rpg.generator.core.extensible.CampoFinder;


public class CampoFinderTest {
    
    @Test
	public void pruebaFind() throws Exception {

        String path =  "bin\\main\\tp\\pp2\\rpg\\generator\\core\\entidades";

        CampoFinder campo = new CampoFinder();

        Set<Object> clases=campo.findClasses(path);
        
        clases.forEach(System.out::println);
	}

}
