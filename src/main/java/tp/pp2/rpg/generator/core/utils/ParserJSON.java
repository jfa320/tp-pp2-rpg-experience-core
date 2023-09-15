package tp.pp2.rpg.generator.core.utils;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import tp.pp2.rpg.generator.core.entidades.Batalla;
import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.entidades.ValidadorVictoria;

public class ParserJSON {
	public static List<Personaje> parsearPersonajesJSON(String json) {
		Gson gson = new Gson();
        Map<String, Object> datos = gson.fromJson(json, Map.class);
        List<Map<String, Object>> personajesData = (List<Map<String, Object>>) datos.get("personajes");
        return gson.fromJson(gson.toJson(personajesData), new TypeToken<List<Personaje>>(){}.getType());
	}
	public static Batalla parsearBatallaJSON(String json) {
		Gson gson = new Gson();
        Map<String, Object> datos = gson.fromJson(json, Map.class);
        Map<String, Object> batallaData = (Map<String, Object>) datos.get("batalla");
        Batalla batallaGenerada=gson.fromJson(gson.toJson(batallaData), Batalla.class);
        batallaGenerada.setValidadorVictoria(new ValidadorVictoria());
        return batallaGenerada;
	}
}
