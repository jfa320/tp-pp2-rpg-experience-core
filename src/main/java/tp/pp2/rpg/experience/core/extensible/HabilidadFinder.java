package tp.pp2.rpg.experience.core.extensible;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class HabilidadFinder {

	@SuppressWarnings("deprecation")
	public List<Habilidad> findClasses(String path) throws Exception {
		
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
}
