package tp.pp2.rpg.experience.core.utils;

import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.CambioTurnoEvent;
import tp.pp2.rpg.experience.core.entidades.estados.VictoriaEvent;

public class ParserJSON {
	public static Map<String,Properties> parsearPersonajesJSON(String json) {
		Gson gson = new Gson();
		Map<String,Properties> personajes = gson.fromJson(json, new TypeToken<Map<String,Properties>>(){}.getType());
		return personajes;
		/* 
		Map<String, Object> datos = gson.fromJson(json, Map.class);
		List<Map<String, Object>> personajesData = (List<Map<String, Object>>) datos.get("personajes");
		return gson.fromJson(gson.toJson(personajesData), new TypeToken<List<Personaje>>() {
		}.getType());*/
	}
/* 
	public static Batalla parsearBatallaJSON(String json) {
		// Crear una instancia de Gson
		Gson gson = new Gson();
		// Parsear el JSON a una instancia de la clase Batalla
		Batalla batalla = gson.fromJson(json, Batalla.class);
		batalla.addObserver(new CambioTurnoEvent(batalla.getPersonajes()));
		batalla.addObserver(new VictoriaEvent(batalla.getPersonajes()));
		return batalla;
	}*/
}
