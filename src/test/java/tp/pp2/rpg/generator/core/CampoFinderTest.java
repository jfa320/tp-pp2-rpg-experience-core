package tp.pp2.rpg.generator.core;

import org.junit.Test;

import tp.pp2.rpg.generator.core.extensible.CampoFinder;


public class CampoFinderTest {
    
    @Test
	public void pruebaFind() {

        String path =  "bin\\main\\tp\\pp2\\rpg\\generator\\core\\entidades";

        CampoFinder campo = new CampoFinder();

        campo.findClasses(path);
        
        System.out.println();
	}

}
