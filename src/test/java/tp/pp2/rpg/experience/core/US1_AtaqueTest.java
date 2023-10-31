package tp.pp2.rpg.experience.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaInitializer;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class US1_AtaqueTest {

	private Batalla batalla;
	private BatallaInitializer initializer;
	private String path;
	private Habilidad atacar;

	@SuppressWarnings({ "serial", "static-access" })
	@BeforeEach
	public void escenario() {
		initializer = new BatallaInitializer();
		path = "src\\main\\resources\\test.properties";
		batalla = initializer.generarBatalla(path.replace("\\", File.separator));
		atacar = batalla.getHabilidades().get(0);
	}

	@Test
	public void CA1_ataqueValido() throws Exception {
		batalla.jugar(atacar);
		assertEquals(batalla.getCaracteristicaPj("Martin", "vida"), 50);
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
		batalla.jugar(atacar);
		assertEquals(batalla.getCaracteristicaPj("Martin", "vida"),0);
		assertEquals(batalla.getEstado(), EstadoBatalla.FINALIZADA);
	}

	@Test
	public void CA4_batallaNoFinalizada() throws Exception {
		batalla.jugar(atacar);
		assertEquals(batalla.getEstado(), EstadoBatalla.EN_PROGRESO);
	}

	@Test
	public void CA5_batallaSinJugar() throws Exception {
		assertEquals(batalla.getEstado(), EstadoBatalla.INICIADA);
	}
	@Test
	public void CA6_retornoTurno() throws Exception {
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(batalla.getPersonajeActual(), "Fabian");
	}
	@Test
	public void CA7_ataqueBatallaFinalizada() throws Exception{
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(batalla.getCaracteristicaPj("Martin", "vida"),0);
		assertEquals(batalla.getEstado(), EstadoBatalla.FINALIZADA);
		assertThrows(Exception.class,
                () -> batalla.jugar(atacar));
	}

}
