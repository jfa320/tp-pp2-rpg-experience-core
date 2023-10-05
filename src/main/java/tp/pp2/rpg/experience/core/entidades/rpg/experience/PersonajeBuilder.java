package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.utils.LectorPersonajesJSON;

public class PersonajeBuilder {

    private Properties properties;    
    
    public PersonajeBuilder(String pathConfigProperties){
        try {
            properties = new Properties();
			properties.load(new FileInputStream(pathConfigProperties));
		} 
        catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

    public Map<String,Properties> buildAllPersonajes(){
        String jsonValue = properties.getProperty("datos.personaje");
        return LectorPersonajesJSON.parsearPersonajesJSON(jsonValue);
    }
}
