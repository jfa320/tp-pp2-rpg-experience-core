package tp.pp2.rpg.generator.core.entidades.asignadorHabilidades;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

import tp.pp2.rpg.generator.core.importadorHabilidades.ImportadorHabilidades;
import tp.pp2.rpg.generator.core.importadorHabilidades.ImportadorHabilidadesXLSX;

public class AsignadorHabilidades extends Observable {
	private ImportadorHabilidades importadorHabilidades;
	private boolean archivoLeido;
	
	public AsignadorHabilidades() {
		archivoLeido=false;
	}
	
	public void asignarHabilidades(File archivoLeer) {
		importadorHabilidades=new ImportadorHabilidadesXLSX();
		try {
			importadorHabilidades.importarHabilidades(archivoLeer);
			this.setArchivoLeido(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isArchivoLeido() {
		return archivoLeido;
	}

	public void setArchivoLeido(boolean archivoLeido) {
		this.archivoLeido = archivoLeido;
		//notifico a los observers del cambio
		 setChanged();
	     notifyObservers(archivoLeido);
	}
	public boolean getSeLeyoArchivo() {
		return this.archivoLeido;
	}
		
}
