package tp.pp2.rpg.generator.core.extensible;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class CampoFinder {
  
    public Set<Object> findClasses(String path) throws Exception{
        Set<Object> resultado = new HashSet<>();

        File carpeta = new File(path);

        if (!carpeta.exists())
            throw new FileNotFoundException();
        
        if (!carpeta.isDirectory())
            throw new IllegalArgumentException();

        for (File archivo: carpeta.listFiles()){
           if (!archivo.getName().endsWith(".class")) continue; 
            
           Class<?> claseEncontrada = Class.forName(archivo.getName()); // faltaba arreglar

           if(!CampoInterface.class.isAssignableFrom(claseEncontrada))
            throw new RuntimeException();
            
            resultado.add(claseEncontrada.newInstance());
        }

        return resultado;
    }
}
