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
	public static Set<Campo> findClasses(String path) throws Exception {
		Set<Campo> clasesEncontradas = new HashSet<>();
		File carpeta = new File(path);
		System.out.println(path);
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

			// aca cargo las clases dinamicamente en runtime
			File f = new File(path);
			URL[] urls = new URL[] { f.toURI().toURL() };
			DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(urls, ClassLoader.getSystemClassLoader());

			// busco las clases
			Class<?> claseEncontrada = Class.forName(
					archivo.getName().substring(0, archivo.getName().length() - ".class".length()), false,
					dynamicClassLoader);

			clasesEncontradas.add((Campo)claseEncontrada.newInstance());
		}
		return clasesEncontradas;
	}

	@SuppressWarnings("deprecation")
	public static Set<Campo> findClassesJAR(String path) throws Exception {
		Set<Campo> clasesEncontradas = new HashSet<>();
		File directorioPlugins = new File(path);
		if (directorioPlugins.exists()) {
			for (File archivoPlugin : directorioPlugins.listFiles()) {
				if (archivoPlugin.getName().endsWith(".jar")) {
					String className = "";
					ZipInputStream zip = new ZipInputStream(Files.newInputStream(archivoPlugin.toPath()));
					for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
						if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
							System.out.println(entry.getName());
							className = entry.getName().replace('/', '.'); // including ".class"
							className = className.substring(0, className.length() - ".class".length());
							// aca cargo las clases dinamicamente en runtime
							URL[] urls = new URL[] { archivoPlugin.toURL() };
							DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(urls,
									ClassLoader.getSystemClassLoader());

							// busco las clases
							Class<?> claseEncontrada = Class.forName(className, false, dynamicClassLoader);

							clasesEncontradas.add((Campo)claseEncontrada.newInstance());
						}
					}

				}
			}

		}
		return clasesEncontradas;
	}
}
