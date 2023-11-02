package tp.pp2.rpg.experience.core.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LectorPersonajesJSON {
	public static ArrayList<Properties> parsearPersonajesJSON(String pathJSON) {
		Gson gson = new Gson();
		Path path = Paths.get(pathJSON);
		String json = null;
		try {
			json = new String(Files.readAllBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Properties> personajes = gson.fromJson(json, new TypeToken<ArrayList<Properties>>(){}.getType());
		return personajes;
	}
}
