package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;
import tp.pp2.rpg.experience.core.utils.CaracteristicasReader;

public class BatallaFactory {

	public BatallaFactory(){}

    public Batalla generarBatalla(String pathConfigProperties){
		Properties p = cargarConfig(pathConfigProperties);
		String pathHabilidades = getPath(p, "path.habilidades");
		String pathCaracteriticas = getPath(p, "path.caracteristicas");


    	CaracteristicasReader reader = new CaracteristicasReader();
		Map<String,Properties> caracteristicas = reader.readCaracteristicas(pathCaracteriticas);
		HabilidadFinder habilidadFinder = new HabilidadFinder();
		List<Habilidad> habilidades = null;
		try {
			habilidades = habilidadFinder.findClasses(pathHabilidades);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> personajes = new ArrayList<>(caracteristicas.keySet());
		Batalla batalla = new Batalla(personajes, caracteristicas, habilidades);
		batalla.getHabilidades().forEach(habilidad->habilidad.setBatallaInicial(batalla));
        return batalla;
    }

	private Properties cargarConfig(String pathConfig){
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(pathConfig.replace("\\", File.separator)));
		} 
        catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return p;
	}

	private String getPath(Properties p , String clave){
		return p.getProperty(clave).replace("\\", File.separator);
	}
}
