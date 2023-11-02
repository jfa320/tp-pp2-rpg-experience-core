package tp.pp2.rpg.experience.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaInitializer;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class US1_JugarAtaqueTest {

	private Batalla batalla;
	private Habilidad atacar;
	
	@BeforeEach
	public void escenario() {
		try {
			BatallaInitializer batallaInitializer = new BatallaInitializer();
			batalla = batallaInitializer.generarBatalla("src\\test\\resources\\archivos\\test.properties");
			atacar = batalla.getHabilidad("Atacar");
		} catch (Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void CA1_ataqueValido() throws Exception {
		batalla.jugar(atacar);
		assertEquals(batalla.getCaracteristicaPj("vida",2), 50);
		assertEquals(batalla.getEstado(),EstadoBatalla.EN_PROGRESO);
	}

	@Test
	public void CA2_cambioTurno() throws Exception {
		batalla.jugar(atacar);
		assertEquals(batalla.getPersonajeActual(), 2);
	}

	@Test
	public void CA3_retornoTurno() throws Exception {
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(batalla.getPersonajeActual(), 1);
	}

	@Test
	public void CA4_batallaSinJugar() throws Exception {
		assertEquals(batalla.getEstado(), EstadoBatalla.INICIADA);
	}

	@Test
	public void CA5_batallaNoFinalizada() throws Exception {
		batalla.jugar(atacar);
		assertEquals(batalla.getEstado(), EstadoBatalla.EN_PROGRESO);
	}

	@Test
	public void CA6_batallaFinalizada() throws Exception {
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(batalla.getCaracteristicaPj("vida",2),0);
		assertEquals(batalla.getEstado(), EstadoBatalla.FINALIZADA);
	}

	@Test
	public void CA7_ataqueBatallaFinalizada() throws Exception{
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(batalla.getCaracteristicaPj("vida",2),0);
		assertEquals(batalla.getEstado(), EstadoBatalla.FINALIZADA);
		assertThrows(Exception.class,
                () -> batalla.jugar(atacar));
	}
}
