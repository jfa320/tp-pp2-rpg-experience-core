package tp.pp2.rpg.experience.core.extensible;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class CargadorHabilidades {

	public void cargar(Batalla batalla, String path) throws Exception {
		Habilidad habilidadAgregar = this.findClass(path);
		if (!validarExistenciaHabilidad(habilidadAgregar, batalla.getHabilidades())) {
			batalla.addHabilidad(habilidadAgregar);
		}else {
			throw new Exception("La habilidad ya existe en Batalla!");
		}
	}

	@SuppressWarnings("deprecation")
	public Habilidad findClass(String path) throws Exception {
		List<Habilidad> clasesEncontradas = new ArrayList<>();

		File archivoArg = new File(path.replace("\\", File.separator));
		String pathCarpeta = archivoArg.getParent();
		String nombreArchivo = archivoArg.getName();
		File carpeta = new File(pathCarpeta);
		if (!carpeta.exists())
			throw new FileNotFoundException("No se encontro una carpeta o un archivo en: " + path);

		if (!carpeta.isDirectory())
			throw new FileNotFoundException("No es una carpeta: " + path);

		for (File archivo : carpeta.listFiles()) {
			if (!archivo.getName().endsWith(".class") || !archivo.getName().equals(nombreArchivo))
				continue;
			// aca cargo las clases dinamicamente en runtime
			URL[] urls = new URL[] { carpeta.toURI().toURL() };

			DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(urls, ClassLoader.getSystemClassLoader());
			// busco las clases
			Class<?> claseEncontrada = Class.forName(archivo.getName().replace(".class", ""), false,
					dynamicClassLoader);
			clasesEncontradas.add((Habilidad) claseEncontrada.newInstance());
			break;
		}
		if (clasesEncontradas.isEmpty()) {
			throw new FileNotFoundException("No se encontro un archivo .class en el path: " + path);
		}
		return clasesEncontradas.get(0);
	}

	private boolean validarExistenciaHabilidad(Habilidad habilidad, List<Habilidad> habilidades) {
		boolean existe = false;
		for (Habilidad habilidadAux : habilidades) {
			existe = habilidad.getClass().toString().equals(habilidadAux.getClass().toString());
			if(existe) {
				break;
			}
		}
		return existe;
	}
}
