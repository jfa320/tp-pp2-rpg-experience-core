package tp.pp2.rpg.experience.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaInitializer;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class US3_DebilitamientoTest {
	private Batalla batalla;
	private Habilidad atacar;
	private Habilidad debilitar;
	private String p1;
	private String p2;
	
	@BeforeEach
	public void escenario() {
		try {
			BatallaInitializer batallaInitializer = new BatallaInitializer();
			batalla = batallaInitializer.generarBatalla("src\\test\\resources\\archivos\\testIt1.properties");
			atacar = batalla.getHabilidad("Atacar");
			debilitar = batalla.getHabilidad("Debilitar");
			p1=batalla.getPersonajes().get(0);
			p2=batalla.getPersonajes().get(1);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void CA1_debilitacionValida() throws Exception {
		batalla.jugar(atacar);
		batalla.jugar(debilitar);
		batalla.jugar(atacar);
		assertEquals(Integer.parseInt(batalla.getCaracteristicasPersonaje(p2).getProperty("vida")), 85);
	}

	@Test
	public void CA2_multiplesDebilitaciones()  throws Exception {
		batalla.jugar(atacar);
		assertEquals(Integer.parseInt(batalla.getCaracteristicasPersonaje(p2).getProperty("vida")), 90);
		batalla.jugar(debilitar);
		batalla.jugar(atacar);
		assertEquals(Integer.parseInt(batalla.getCaracteristicasPersonaje(p2).getProperty("vida")), 85);
		batalla.jugar(debilitar);
		batalla.jugar(atacar);
		assertEquals(Integer.parseInt(batalla.getCaracteristicasPersonaje(p2).getProperty("vida")), 82);
	}

	@Test
	public void CA3_debilitacionSinEfecto() throws Exception {
		batalla.jugar(debilitar);
		batalla.jugar(atacar);
		assertEquals(Integer.parseInt(batalla.getCaracteristicasPersonaje(p1).getProperty("vida")), 99);
		batalla.jugar(debilitar);
		batalla.jugar(atacar);
		assertEquals(Integer.parseInt(batalla.getCaracteristicasPersonaje(p1).getProperty("vida")), 98);
	}
}
