package tp.pp2.rpg.generator.core.entidades.asignadorHabilidades;

import java.io.File;
import java.io.IOException;

import tp.pp2.rpg.generator.core.importadorHabilidades.ImportadorHabilidades;
import tp.pp2.rpg.generator.core.importadorHabilidades.ImportadorHabilidadesXLSX;

public class AsignadorHabilidades {
	ImportadorHabilidades importadorHabilidades;
	
	public AsignadorHabilidades(File archivoLeer) {
		importadorHabilidades=new ImportadorHabilidadesXLSX();
		try {
			importadorHabilidades.importarHabilidades(archivoLeer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
