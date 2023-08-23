package tp.pp2.rpg.generator.core.importadorHabilidades;

import java.io.File;
import java.io.IOException;
import java.util.List;

import tp.pp2.rpg.generator.core.entidades.DTOHabilidad;

public interface ImportadorHabilidades {
	List<DTOHabilidad> importarHabilidades(File archivoLeer) throws IOException;
}
