package tp.pp2.rpg.experience.core;



import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;
import com.google.gson.reflect.TypeToken;

import tp.pp2.rpg.experience.core.utils.LectorPersonajesJSON;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;


public class GSONTest {
	/*
	@Test
	public void test1() {

		String jsonValue = "C:\\RPGExpConfig\\personajes.json";
		Map<String,Properties> personajes=LectorPersonajesJSON.parsearPersonajesJSON(jsonValue);
		
		  for (Map.Entry<String, Properties> entry : personajes.entrySet()) {
	            String nombre = entry.getKey();
	            Properties propiedades = entry.getValue();
	            System.out.println("Personaje: " + nombre);
	            System.out.println("Ataque: " + propiedades.getProperty("ataque"));
	            System.out.println("Vida: " + propiedades.getProperty("vida"));
	            System.out.println();
	        }
	} */
	
	@Test
	public void test2() {
		String json = "{\"Fabian\":{\"ataque\":\"80\",\"vida\":\"100\"},\"Martin\":{\"ataque\":\"100\",\"vida\":\"100\"}}";

        // Parsear el JSON a un Map<String, Properties>
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, Properties>>() {}.getType();
        Map<String, Properties> personajesMap = gson.fromJson(json, mapType);

        // Acceder a los personajes y sus propiedades
        for (Map.Entry<String, Properties> entry : personajesMap.entrySet()) {
            String nombre = entry.getKey();
            Properties propiedades = entry.getValue();
            System.out.println("Personaje: " + nombre);
            System.out.println("Ataque: " + propiedades.getProperty("ataque"));
            System.out.println("Vida: " + propiedades.getProperty("vida"));
            System.out.println();
        }
	}
	
	
	
}
