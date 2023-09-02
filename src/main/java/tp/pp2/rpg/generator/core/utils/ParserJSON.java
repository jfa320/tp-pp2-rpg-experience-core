package tp.pp2.rpg.generator.core.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import tp.pp2.rpg.generator.core.entidades.Personaje;

public class ParserJSON {
	public static List<Personaje> parsearJSON(String json) {
		 // Crear una instancia de Gson
        Gson gson = new Gson();
        // Utilizar TypeToken para convertir el JSON en una lista de objetos Personaje
        List<Personaje> personajes = gson.fromJson(json, new TypeToken<List<Personaje>>(){}.getType());
        return personajes;
	}
}
