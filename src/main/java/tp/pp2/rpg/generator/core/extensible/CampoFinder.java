package tp.pp2.rpg.generator.core.extensible;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class CampoFinder {
  
    @SuppressWarnings("deprecation")
	public Set<Object> findClasses(String path) throws Exception{
        Set<Object> resultado = new HashSet<>();

        File carpeta = new File(path);

        if (!carpeta.exists())
            throw new FileNotFoundException();
        
        if (!carpeta.isDirectory())
            throw new IllegalArgumentException();

        for (File archivo: carpeta.listFiles()){
           if (!archivo.getName().endsWith(".class")) continue; 
           
           /*String clasesSinExtension=archivo.getName().substring(0, archivo.getName().length() -".class".length());
           String pathClases=carpeta.getPath()+"."+clasesSinExtension;
           String pathABuscar="tp-pp2-rpg-generator-core."+pathClases.replace('\\', '.');
           System.out.println(archivo.getPath());
           Class<?> claseEncontrada = Class.forName("tp.pp2.rpg.generator.core.entidades.Enfrentamiento"); // faltaba arreglar*/

           String clasesSinExtension=archivo.getName().substring(0, archivo.getName().length() -".class".length());
           System.out.println(clasesSinExtension);
           String pathClases=path+"."+clasesSinExtension;
           System.out.println(pathClases);
           String pathABuscar="tp.pp2.rpg.generator.core."+pathClases.replace('\\', '.');
           System.out.println(pathABuscar);
           //Class<?> claseEncontrada = Class.forName("tp.pp2.rpg.generator.core.entidades.Enfrentamiento");
           Class<?> claseEncontrada = Class.forName("tp.pp2.rpg.generator.core.utils.Enfrentamiento");
           /*if(!CampoInterface.class.isAssignableFrom(claseEncontrada))
            throw new RuntimeException();
            */
            resultado.add(claseEncontrada.newInstance());
        }

        return resultado;
    }
}
