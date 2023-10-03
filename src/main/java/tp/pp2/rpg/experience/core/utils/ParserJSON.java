package tp.pp2.rpg.experience.core.utils;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.Personaje;
import tp.pp2.rpg.experience.core.entidades.ValidadorVictoria;

public class ParserJSON {
	public static List<Personaje> parsearPersonajesJSON(String json) {
		Gson gson = new Gson();
		Map<String, Object> datos = gson.fromJson(json, Map.class);
		List<Map<String, Object>> personajesData = (List<Map<String, Object>>) datos.get("personajes");
		return gson.fromJson(gson.toJson(personajesData), new TypeToken<List<Personaje>>() {
		}.getType());
	}

	public static Batalla parsearBatallaJSON(String json) {
		// Crear una instancia de Gson
		Gson gson = new Gson();
		// Parsear el JSON a una instancia de la clase Batalla
		Batalla batalla = gson.fromJson(json, Batalla.class);
		batalla.setValidadorVictoria(new ValidadorVictoria());
		return batalla;
	}
}
