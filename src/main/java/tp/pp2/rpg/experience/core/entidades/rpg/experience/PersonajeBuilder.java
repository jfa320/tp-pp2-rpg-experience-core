package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

    public ArrayList<Properties> buildAllPersonajes(){
        String jsonValue = properties.getProperty("datos.personaje").replace("\\", File.separator);
        return LectorPersonajesJSON.parsearPersonajesJSON(jsonValue);
    }
}
