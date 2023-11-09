package tp.pp2.rpg.experience.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaInitializer;
import tp.pp2.rpg.experience.core.extensible.CargadorHabilidades;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class US4_CargadorHabilidadesTest {
	private CargadorHabilidades cargadorHabilidades;
	private Batalla batalla;
	private Habilidad atacar;
	private Habilidad debilitar;
	private String p1;
	private String p2;
	private String path;

	@SuppressWarnings({ "serial", "static-access" })
	@BeforeEach
	public void escenario() {
		path = "src\\test\\resources\\pluginsRuntime\\";
		cargadorHabilidades = new CargadorHabilidades();
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
	public void CA1_archivoNoEsHabilidad() {
		assertThrows(FileNotFoundException.class, () -> cargadorHabilidades.cargar(batalla, path + "image.gif"));
		assertEquals(batalla.getHabilidades().size(), 0);
	}

	@Test
	public void CA2_habilidadCargada() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		assertEquals(batalla.getHabilidades().size(), 1);
	}

	@Test
	public void CA3_multiplesHabilidadesCargadas() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		cargadorHabilidades.cargar(batalla, path + "Debilitar.class");
		assertEquals(batalla.getHabilidades().size(), 2);
	}

	@Test
	public void CA4_habilidadDuplicada() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		assertEquals(batalla.getHabilidades().size(), 1);
	}

	@Test
	public void CA5_multiplesHabilidadesIgualesCargadas() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		cargadorHabilidades.cargar(batalla, path + "Debilitar.class");
		cargadorHabilidades.cargar(batalla, path + "Atacar.class");
		cargadorHabilidades.cargar(batalla, path + "Debilitar.class");
		assertEquals(batalla.getHabilidades().size(), 2);
	}
}
