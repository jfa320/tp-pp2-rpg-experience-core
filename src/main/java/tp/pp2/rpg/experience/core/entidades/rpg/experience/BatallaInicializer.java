package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.CambioTurnoEvent;
import tp.pp2.rpg.experience.core.entidades.estados.VictoriaEvent;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.extensible.HabilidadFinder;

public class BatallaInicializer {
    
    private Map<String,Properties> personajes;
    private List<Habilidad> habilidades;

    public BatallaInicializer(){}

    public Batalla generarBatalla(String pathConfigProperties){
        try{
			PersonajeBuilder pjBuilder = new PersonajeBuilder(pathConfigProperties);
			personajes = pjBuilder.buildAllPersonajes();
			
			HabilidadFinder habilidadFinder = new HabilidadFinder();
			habilidades = habilidadFinder.findClasses(getHabilidadPath(pathConfigProperties));
		}
		catch(Exception e){}

		Batalla batalla = BatallaBuilder.build(habilidades,personajes);
		ArrayList<String> listaPersonajes = new ArrayList<>();
		listaPersonajes.addAll(personajes.keySet());
		batalla.addObserver(new CambioTurnoEvent(listaPersonajes));
		batalla.addObserver(new VictoriaEvent());
		
        return batalla;
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
