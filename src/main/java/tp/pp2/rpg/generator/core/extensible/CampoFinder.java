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
	public Set<Campo> findClasses(String path) throws Exception {
		String pathPackage=path.replace('.', '/');
		Set<Campo> clasesEncontradas = new HashSet<>();
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
			Class<?> claseEncontrada = Class.forName("campo.agua."+archivo.getName().replace(".class", ""), false,
					dynamicClassLoader);
			clasesEncontradas.add((Campo) claseEncontrada.newInstance());
		}
		return clasesEncontradas;
	}

	@SuppressWarnings("deprecation")
	public Set<Campo> findClassesJAR(String path) throws Exception {
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

							clasesEncontradas.add((Campo) claseEncontrada.newInstance());
						}
					}

				}
			}

		}
		return clasesEncontradas;
	}

}
