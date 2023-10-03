package tp.pp2.rpg.experience.core;



import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.ValidadorVictoria;

public class GSONTest {
	@Test
	public void test1() {
		String json = "{\"habilidades\":null,\"validadorVictoria\":null,\"contexto\":{\"turno\":{\"id\":1,\"nombre\":\"Personaje1\"},\"vidas\":{\"1\":100,\"2\":100},\"habilidadesActivadas\":{}},\"turnero\":null}";
		// Crear una instancia de Gson
		Gson gson = new Gson();
		// Parsear el JSON a una instancia de la clase Batalla
		Batalla batalla = gson.fromJson(json, Batalla.class);
		batalla.setValidadorVictoria(new ValidadorVictoria());
		System.out.println(batalla.toString());
	}
}
