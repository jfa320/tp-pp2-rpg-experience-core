package tp.pp2.rpg.generator.core.extensible;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CampoFinder {
  
	@SuppressWarnings("deprecation")
	public static Set<Object> findClasses(String path) throws Exception {
		Set<Object> clasesEncontradas = new HashSet<>();
		File carpeta = new File(path);

		if (!carpeta.exists())
			throw new FileNotFoundException();

		if (!carpeta.isDirectory())
			throw new IllegalArgumentException();

		for (File archivo : carpeta.listFiles()) {
			if (!archivo.getName().endsWith(".class"))
				continue;

			// Crea una URL para el directorio que contiene el archivo Enfrentamiento.class
			URL classUrl = new URL("file://" + path);

			// Crea un ClassLoader basado en la URL
			URLClassLoader classLoader = new URLClassLoader(new URL[] { classUrl });

			// Carga la clase dinámicamente
			Class<?> claseEncontrada = classLoader
					.loadClass(archivo.getName().substring(0, archivo.getName().length() - ".class".length()));

			clasesEncontradas.add(claseEncontrada.newInstance());
		}
		return clasesEncontradas;
	}

	@SuppressWarnings("deprecation")
	public static Set<Object> findClassesJAR(String path) throws Exception {
		Set<Object> clasesEncontradas = new HashSet<>();
		File directorioPlugins = new File(path);
		if (directorioPlugins.exists()) {
			for (File archivoPlugin : directorioPlugins.listFiles()) {
				if (archivoPlugin.getName().endsWith(".jar")) {
					String className = "";
					ZipInputStream zip = new ZipInputStream(Files.newInputStream(archivoPlugin.toPath()));
					for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
						if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
							className = entry.getName().replace('/', '.'); // including ".class"
							className = className.substring(0, className.length() - ".class".length());
							ClassLoader loader = URLClassLoader.newInstance(new URL[] { archivoPlugin.toURL() });
							Class<?> claseEncontrada = loader.loadClass(className);
							clasesEncontradas.add(claseEncontrada.newInstance());
						}
					}

				}
			}

		}
		return clasesEncontradas;
	}
}
