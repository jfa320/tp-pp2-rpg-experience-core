package tp.pp2.rpg.experience.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaBuilder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DebilitamientoTest {
	private Batalla batalla;
	@Mock
	private Habilidad atacar;
	@Mock
	private Habilidad debilitar;

	@SuppressWarnings({ "serial", "static-access" })
	@BeforeEach
	public void escenario() {
		Map<String, Properties> personajes = new HashMap<String, Properties>() {
			{
				put("Fabian", new Properties() {
					{
						setProperty("ataque", "10");
						setProperty("vida", "100");
					}
				});
				put("Martin", new Properties() {
					{
						setProperty("ataque", "1");
						setProperty("vida", "100");
					}
				});
			}
		};

		MockitoAnnotations.openMocks(this);
		doAnswer(invocation -> {
			Batalla batalla = invocation.getArgument(0);
			String personajeActual = batalla.getPersonajeActual();
			Integer danio = Integer.valueOf(personajes.get(personajeActual).getProperty("ataque"));
			Map<String, Properties> personajesAux = batalla.getPersonajes();
			for (Map.Entry<String, Properties> entry : personajesAux.entrySet()) {
				String key = entry.getKey();
				Properties properties = entry.getValue();
				if (!key.equals(personajeActual)) {
					String vidaStr = properties.getProperty("vida");
					int vida = Integer.parseInt(vidaStr);
					int nuevaVida = vida - danio;
					properties.setProperty("vida", String.valueOf(nuevaVida));
				}
			}
			batalla.setPersonajes(personajesAux);
			return null;
		}).when(atacar).realizar(any(Batalla.class));
		
		doAnswer(invocation -> {
			String personajeActual = batalla.getPersonajeActual();
			Map<String, Properties> personajesAux = batalla.getPersonajes();
			for (Map.Entry<String, Properties> entry : personajesAux.entrySet()) {
				String key = entry.getKey();
				Properties properties = entry.getValue();
				if (!key.equals(personajeActual)) {
					String ataqueStr = properties.getProperty("ataque");
					int ataque = Integer.parseInt(ataqueStr);
					int nuevoAtaque = (int) Math.ceil(ataque/2.0);
					properties.setProperty("ataque", String.valueOf(nuevoAtaque));
				}
			}
			batalla.setPersonajes(personajesAux);
			return null;
		}).when(debilitar).realizar(any(Batalla.class));

		List<Habilidad> habilidades = new ArrayList<Habilidad>();
		habilidades.add(atacar);
		habilidades.add(debilitar);
		batalla = (new BatallaBuilder()).build(habilidades, personajes);

	}

	@Test
	public void CA1_debilitacionValida() throws Exception {
		batalla.jugar(atacar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Martin").getProperty("vida")), 90);
		batalla.jugar(debilitar);
		batalla.jugar(atacar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Martin").getProperty("vida")), 85);
	}

	@Test
	public void CA2_multiplesDebilitaciones()  throws Exception {
		batalla.jugar(atacar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Martin").getProperty("vida")), 90);
		batalla.jugar(debilitar);
		batalla.jugar(atacar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Martin").getProperty("vida")), 85);
		batalla.jugar(debilitar);
		batalla.jugar(atacar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Martin").getProperty("vida")), 82);
	}

	@Test
	public void CA3_limiteDebilitacion() throws Exception {
		batalla.jugar(debilitar);
		batalla.jugar(atacar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Fabian").getProperty("vida")), 99);
	}
}
