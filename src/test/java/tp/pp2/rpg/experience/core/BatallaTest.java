package tp.pp2.rpg.experience.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.Batalla;

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
            
        }).when(atacar).realizar(any(Batalla.class));
        
		List<Habilidad> habilidades = new ArrayList<Habilidad>();
		habilidades.add(atacar);
		batalla = new Batalla(personajes, habilidades);

	}
	/*
	 * @Test public void CA1_ataqueValido() throws Exception {
	 * batalla.jugar(atacar); Assertions.assertEquals(0, batalla.vida(p2));
	 * Assertions.assertEquals(p1.getId(), victoriaE.getGanador().getId()); }
	 * 
	 * @Test public void CA3_batallaNoFinalizada() throws Exception {
	 * batalla.jugar(invisibilidad); Assertions.assertEquals(personajeNoGanador,
	 * victoriaE.getGanador()); }
	 */

}
