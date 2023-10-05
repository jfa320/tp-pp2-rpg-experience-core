package tp.pp2.rpg.experience.core.utils;

import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ParserJSON {
	public static Map<String,Properties> parsearPersonajesJSON(String json) {
		Gson gson = new Gson();
		Map<String,Properties> personajes = gson.fromJson(json, new TypeToken<Map<String,Properties>>(){}.getType());
		return personajes;
	}
}
