package tp.pp2.rpg.experience.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.estados.EstadoBatalla;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class US1_JugarAtaqueTest {

	private Batalla batalla;
	private String atacar;
	private String p1;
	private String p2;
	
	@BeforeEach
	public void escenario() {
		try {
			BatallaFactory batallaFactory = new BatallaFactory();
			batalla = batallaFactory.generarBatalla("src\\test\\resources\\archivos\\test.properties");
			atacar = "Atacar";
			p1=batalla.getPersonajes().get(0);
			p2=batalla.getPersonajes().get(1);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	@Test
	public void CA1_ataqueValido() throws Exception {
		batalla.jugar(atacar);
		assertEquals(Integer.parseInt(batalla.getCaracteristicasPersonaje(p2).getProperty("vida")), 50);
		assertEquals(batalla.getEstado(),EstadoBatalla.EN_PROGRESO);
	}

	@Test
	public void CA2_habilidadInvalida() throws Exception {
		String golpe = "golpe";
		assertThrows(Exception.class,
                () -> batalla.jugar(golpe));
	}

	@Test
	public void CA3_cambioTurno() throws Exception {
		batalla.jugar(atacar);
		assertEquals(batalla.getPersonajeActual(), "Martin");
	}

	@Test
	public void CA4_retornoTurno() throws Exception {
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(batalla.getPersonajeActual(), "Fabian");
	}

	@Test
	public void CA5_batallaSinJugar() throws Exception {
		assertEquals(batalla.getEstado(), EstadoBatalla.INICIADA);
	}

	@Test
	public void CA6_batallaNoFinalizada() throws Exception {
		batalla.jugar(atacar);
		assertEquals(batalla.getEstado(), EstadoBatalla.EN_PROGRESO);
	}

	@Test
	public void CA7_batallaFinalizada() throws Exception {
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(Integer.parseInt(batalla.getCaracteristicasPersonaje(p2).getProperty("vida")),0);
		assertEquals(batalla.getEstado(), EstadoBatalla.FINALIZADA);
	}

	@Test
	public void CA8_ataqueBatallaFinalizada() throws Exception{
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		batalla.jugar(atacar);
		assertEquals(batalla.getEstado(), EstadoBatalla.FINALIZADA);
		assertThrows(Exception.class,
                () -> batalla.jugar(atacar));
	}
}
