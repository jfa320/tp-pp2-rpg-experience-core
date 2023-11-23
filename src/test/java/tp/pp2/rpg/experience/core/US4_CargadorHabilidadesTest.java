package tp.pp2.rpg.experience.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaFactory;
import tp.pp2.rpg.experience.core.extensible.CargadorHabilidades;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class US4_CargadorHabilidadesTest {
	private CargadorHabilidades cargadorHabilidades;
	private Batalla batalla;
	private String p1;
	private String p2;
	private String path;

	@BeforeEach
	public void escenario() {
		path = "src\\test\\resources\\pluginsRuntime\\";
		cargadorHabilidades = new CargadorHabilidades();
		try {
			BatallaFactory batallaFactory = new BatallaFactory();
			batalla = batallaFactory.generarBatalla("src\\test\\resources\\archivos\\testIt1US4.properties");
			p1=batalla.getPersonajes().get(0);
			p2=batalla.getPersonajes().get(1);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void CA1_archivoNoEsHabilidad() {
		assertThrows(FileNotFoundException.class, () -> cargadorHabilidades.cargar(batalla, path + "image.gif"));
		assertEquals(batalla.getHabilidades().size(), 0);
	}

	@Test
	public void CA2_habilidadCargada() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		assertEquals(batalla.getHabilidades().size(), 1);
		assertTrue(existeHabilidad(batalla,"Atacar"));
	}

	@Test
	public void CA3_multiplesHabilidadesCargadas() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		assertEquals(batalla.getHabilidades().size(), 1);
		assertTrue(existeHabilidad(batalla,"Atacar"));
		cargadorHabilidades.cargar(batalla, path + "Debilitar.class");
		assertEquals(batalla.getHabilidades().size(), 2);
		assertTrue(existeHabilidad(batalla,"Debilitar"));
	}

	@Test
	public void CA4_habilidadDuplicada() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		assertEquals(batalla.getHabilidades().size(), 1);
		assertTrue(existeHabilidad(batalla,"Atacar"));
		assertThrows(Exception.class, () -> cargadorHabilidades.cargar(batalla, path + "Atacar.class"));
		assertEquals(batalla.getHabilidades().size(), 1);
	}
	
	@Test
	public void CA5_jugarDespuesDeCargar() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		batalla.jugar("Atacar");
		assertEquals(Integer.parseInt(batalla.getCaracteristicasPersonaje(p2).getProperty("vida")), 90);
	}

	@Test
	public void CA6_cargaDeHabilidadeDespuesDeArchivoNoValido() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Debilitar.class");
		assertThrows(FileNotFoundException.class, () -> cargadorHabilidades.cargar(batalla, path + "image.gif"));
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		assertEquals(batalla.getHabilidades().size(), 2);
	}
	

	private boolean existeHabilidad(Batalla batalla, String nombreHabilidad) {
		for(Habilidad habilidad:batalla.getHabilidades()){
			if(habilidad.getClass().getSimpleName()==nombreHabilidad) {
				return true;
			}
		}
		return false;
	}

}
