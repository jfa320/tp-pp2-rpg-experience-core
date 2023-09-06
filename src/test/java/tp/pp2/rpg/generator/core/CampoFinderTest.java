package tp.pp2.rpg.generator.core;

import java.util.Set;

import org.junit.Test;

import tp.pp2.rpg.generator.core.extensible.CampoFinder;


public class CampoFinderTest {
    
    @Test
	public void pruebaFind() throws Exception {

        String path =  "C:\\Users\\Fabián\\Desktop\\UNGS\\Proyecto Profesional 2 - S2 2023\\TP PP2\\Core\\tp-pp2-rpg-generator-core\\plugins";
        CampoFinder campo = new CampoFinder();
        //Set<Object> clases=campo.findClassesJAR(path);
        Set<Object> clases=campo.findClasses(path);
        clases.forEach(c->System.out.println(c.getClass()));
	}

}
