package tp.pp2.rpg.experience.core.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CaracteristicasReader {
	public Map<String,Properties> readCaracteristicas(String path) {
		Gson gson = new Gson();
		String json = null;
		try {
			json = new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String,Properties> caracteristicas = gson.fromJson(json, new TypeToken<Map<String,Properties>>(){}.getType());
		return caracteristicas;
	}
}
