package tp.pp2.rpg.experience.core.extensible;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class HabilidadFinder {

	Properties properties;

	public HabilidadFinder(String pathConfigProperties){
		try {
            properties = new Properties();
			properties.load(new FileInputStream(pathConfigProperties.replace("\\", File.separator)));
		} 
        catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public List<Habilidad> findClasses(String dir) throws Exception {
		String path= getHabilidadPath() + File.separator + dir;
		List<Habilidad> clasesEncontradas = new ArrayList<>();
		File carpeta = new File(path.replace("\\", File.separator));
		if (!carpeta.exists())
			throw new FileNotFoundException("No se encontro una carpeta o un archivo en: "+path);

		if (!carpeta.isDirectory())
			throw new IllegalArgumentException("No es un argumento valido: "+path);

		for (File archivo : carpeta.listFiles()) {
			if (!archivo.getName().endsWith(".class"))
				continue;

			// aca cargo las clases dinamicamente en runtime
			URL[] urls = new URL[] { carpeta.toURI().toURL() };
			
			DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(urls, ClassLoader.getSystemClassLoader());
			// busco las clases
			Class<?> claseEncontrada = Class.forName(archivo.getName().replace(".class", ""), false,
					dynamicClassLoader);
			clasesEncontradas.add((Habilidad) claseEncontrada.newInstance());
		}
		return clasesEncontradas;
	}
	

    private String getHabilidadPath(){
			return properties.getProperty("path.habilidades");
	}
}
