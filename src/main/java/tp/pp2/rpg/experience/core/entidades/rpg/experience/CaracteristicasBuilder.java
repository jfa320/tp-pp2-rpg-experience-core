package tp.pp2.rpg.experience.core.entidades.rpg.experience;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.utils.LectorCaracteristicasJSON;

public class CaracteristicasBuilder {

    private Properties properties;    
    
    public CaracteristicasBuilder(String pathConfigProperties){
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

    public Map<String,Properties> buildAllCaracteristicas(){
        String jsonValue = properties.getProperty("datos.personaje").replace("\\", File.separator);
        return LectorCaracteristicasJSON.parsearCaracteristicasJSON(jsonValue);
    }
}
