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
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaBuilder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class SanacionTest {
	private Batalla batalla;
	@Mock
	private Habilidad atacar;
	@Mock
	private Habilidad sanar;

	@SuppressWarnings({ "serial", "static-access" })
	@BeforeEach
	public void escenario() {
		Map<String, Properties> personajes = new HashMap<String, Properties>() {
			{
				put("Fabian", new Properties() {
					{
						setProperty("ataque", "80");
						setProperty("vida", "100");
					}
				});
				put("Martin", new Properties() {
					{
						setProperty("ataque", "50");
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
			Map<String, Integer> vidasInicial = null;
			System.out.println(vidasInicial);
			Batalla batalla = invocation.getArgument(0);
			String personajeActual = batalla.getPersonajeActual();
			if (vidasInicial == null) {
				Map<String, Integer> vidaMap = new HashMap<>();
				for (String nombre : personajes.keySet()) {
					Properties propiedadesFabian = personajes.get(nombre);
					String vidaString = propiedadesFabian.getProperty("vida");
					int vida = Integer.parseInt(vidaString);
					vidaMap.put(nombre, vida);
				}
				vidasInicial = vidaMap;
			}
			String sanacion = vidasInicial.get(personajeActual) + "";
			System.out.println(sanacion);
			Map<String, Properties> personajesAux = batalla.getPersonajes();
			personajesAux.get(personajeActual).setProperty("vida", sanacion);
			batalla.setPersonajes(personajesAux);
			return null;
		}).when(sanar).realizar(any(Batalla.class));

		List<Habilidad> habilidades = new ArrayList<Habilidad>();
		habilidades.add(atacar);
		habilidades.add(sanar);
		batalla = (new BatallaBuilder()).build(habilidades, personajes);

	}

	@Test
	public void CA1_sanacionValida() throws Exception {
		batalla.jugar(atacar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Martin").getProperty("vida")), 20);
		batalla.jugar(sanar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Martin").getProperty("vida")), 100);
	}

	@Test
	public void CA2_sanacionSinDanio() throws Exception {
		batalla.jugar(sanar);
		assertEquals(Integer.valueOf(batalla.getPersonajes().get("Fabian").getProperty("vida")), 100);
	}
	
	@Test
	public void CA3_sanacionBatallaFinalizada() throws Exception {
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(batalla.getEstado(), EstadoBatalla.FINALIZADA);
		batalla.jugar(sanar);
		//TODO AGREGAR EXCEPCION DE FINALIZADA
	}
}
