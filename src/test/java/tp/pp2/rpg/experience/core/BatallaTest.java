package tp.pp2.rpg.experience.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import static org.mockito.Answers.valueOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;

public class BatallaTest {

	private Batalla batalla;

	@Mock
	private Habilidad atacar;

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
						setProperty("ataque", "100");
						setProperty("vida", "100");
					}
				});
			}
		};

		MockitoAnnotations.openMocks(this);

        doAnswer(invocation -> {
            Batalla batalla = invocation.getArgument(0);
            String personajeActual=batalla.getPersonajeActual();
            Integer danio=Integer.valueOf(personajes.get(personajeActual).getProperty("ataque"));
			for(Entry<String,Properties> personaje : personajes.entrySet()){
				if(!personaje.getKey().equals(personajeActual)){
					int vida = Integer.valueOf(personaje.getValue().getProperty("vida"));
					personaje.getValue().setProperty("vida", String.valueOf(vida-danio));
				}
			}
			return null; 
        }).when(atacar).realizar(any(Batalla.class));
        
		List<Habilidad> habilidades = new ArrayList<Habilidad>();
		habilidades.add(atacar);
		batalla = new Batalla(personajes, habilidades);

	}
	
	@Test public void CA1_ataqueValido() throws Exception {
	  batalla.jugar(atacar); 
	  assertEquals("20", batalla.getPersonajes().get("Martin").getProperty("vida")); 
	}
	  
	@Test public void CA2_batallaNoFinalizada() throws Exception {
	  batalla.jugar(atacar); 
	  assertEquals("Martin",batalla.getPersonajeActual()); 
	}

	@Test public void CA3_batallaFinalizada() throws Exception {
	  batalla.jugar(atacar); 
	  batalla.jugar(atacar);
	  assertEquals(EstadoBatalla.FINALIZADA,batalla.getEstado()); // falta implemtar logica de batalla finalizada
	}
}
