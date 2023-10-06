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

	@SuppressWarnings("deprecation")
	public List<Habilidad> findClasses(String pathConfigProperties) throws Exception {
		String path=this.getHabilidadPath(pathConfigProperties);
		List<Habilidad> clasesEncontradas = new ArrayList<>();
		File carpeta = new File(path);
		if (!carpeta.exists())
			throw new FileNotFoundException("No se encontro una carpeta o un archivo en: "+path);

		if (!carpeta.isDirectory())
			throw new FileNotFoundException("No es una carpeta: "+path);

		for (File archivo : carpeta.listFiles()) {
			if (!archivo.getName().endsWith(".class"))
				continue;

			// aca cargo las clases dinamicamente en runtime
			URL[] urls = new URL[] { carpeta.toURI().toURL() };
			
			DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(urls, ClassLoader.getSystemClassLoader());
			// busco las clases
			System.out.println(archivo.getName());
			Class<?> claseEncontrada = Class.forName(archivo.getName().replace(".class", ""), false,
					dynamicClassLoader);
			clasesEncontradas.add((Habilidad) claseEncontrada.newInstance());
		}
		return clasesEncontradas;
	}
	

    private String getHabilidadPath(String pathConfigProperties){
			Properties p = new Properties();
			try {
				p.load(new FileInputStream(pathConfigProperties));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return p.getProperty("path.habilidades");
	}
}
