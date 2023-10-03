package tp.pp2.rpg.experience.core;

import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.BatallaContexto;
import tp.pp2.rpg.experience.core.entidades.Personaje;

public class GSONTest {
	@Test
	public void ca1() {
		String json = "{\"turno\":{\"nombre\":\"NombreDeTurno\"},\"vidas\":{\"Personaje1\":100,\"Personaje2\":100},\"habilidadesActivadas\":null}";
		Gson gson = new Gson();
		BatallaContexto batallaContexto = gson.fromJson(json, BatallaContexto.class);
		// Ahora puedes trabajar con la instancia de Batalla
		System.out.println(batallaContexto.toString());
	}
}
