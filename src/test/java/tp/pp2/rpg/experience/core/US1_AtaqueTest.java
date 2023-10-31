package tp.pp2.rpg.experience.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaBuilder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class US1_AtaqueTest {

	private Batalla batalla;
	private Batalla batallaFinalizada;

	@Mock
	private Habilidad atacar;

	@SuppressWarnings({ "serial", "static-access" })
	@BeforeEach
	public void escenario() {
		Properties c1 = new Properties() {
			{
				setProperty("ataque", "80");
				setProperty("vida", "100");
			}
		};
		Properties c2 = new Properties() {
			{
				setProperty("ataque", "100");
				setProperty("vida", "100");
			}
		};
		Map<String, Properties> personajes = new HashMap<String, Properties>() {
			{
				put("Fabian", c1);
				put("Martin", c2);
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

		List<Habilidad> habilidades = new ArrayList<Habilidad>();
		habilidades.add(atacar);
		batalla = (new BatallaBuilder()).build(habilidades, personajes);
		batallaFinalizada = (new BatallaBuilder()).build(habilidades, personajes);
		batallaFinalizada.setEstado(EstadoBatalla.FINALIZADA);
	}

	@Test
	public void CA1_ataqueValido() throws Exception {
		batalla.jugar(atacar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Martin").getProperty("vida")), 20);
	}

	@Test
	public void CA2_cambioTurno() throws Exception {
		batalla.jugar(atacar);
		assertEquals(batalla.getPersonajeActual(), "Martin");
	}

	@Test
	public void CA3_batallaFinalizada() throws Exception {
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Fabian").getProperty("vida")), 0);
		assertEquals(batalla.getEstado(), EstadoBatalla.FINALIZADA);
		assertEquals(batalla.getPersonajeActual(), "Martin");
	}

	@Test
	public void CA4_batallaNoFinalizada() throws Exception {
		batalla.jugar(atacar);
		assertEquals(batalla.getEstado(), EstadoBatalla.EN_PROGRESO);
	}

	@Test
	public void CA5_ataqueBatallaFinalizada() throws Exception {
		assertEquals(batalla.getEstado(), EstadoBatalla.INICIADA);
	}
	@Test
	public void CA6_retornoTurno() throws Exception {
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(batalla.getPersonajeActual(), "Fabian");
	}
	@Test
	public void CA7_ataqueBatallaFinalizada(){
		assertThrows(Exception.class,
                () -> batallaFinalizada.jugar(atacar));
	}

}
