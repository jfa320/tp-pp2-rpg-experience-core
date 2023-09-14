package tp.pp2.rpg.generator.core.extensible;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;

public class HabilidadFinder {

	@SuppressWarnings("deprecation")
	public Set<Habilidad> findClasses(String path) throws Exception {
		String pathPackage=path.replace('.', '/');
		Set<Habilidad> clasesEncontradas = new HashSet<>();
		File carpeta = new File(pathPackage);
		System.out.println(pathPackage);
		if (!carpeta.exists())
			throw new FileNotFoundException();

		if (!carpeta.isDirectory())
			throw new IllegalArgumentException();

		for (File archivo : carpeta.listFiles()) {
			if (!archivo.getName().endsWith(".class"))
				continue;

			// aca cargo las clases dinamicamente en runtime
			URL[] urls = new URL[] { carpeta.toURI().toURL() };
			DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(urls, ClassLoader.getSystemClassLoader());
			System.out.println(archivo.getName());
			// busco las clases
			Class<?> claseEncontrada = Class.forName(archivo.getName().replace(".class", ""), false,
					dynamicClassLoader);
			clasesEncontradas.add((Habilidad) claseEncontrada.newInstance());
		}
		return clasesEncontradas;
	}
}
