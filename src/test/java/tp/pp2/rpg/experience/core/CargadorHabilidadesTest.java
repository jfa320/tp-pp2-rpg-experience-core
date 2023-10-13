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
import org.junit.jupiter.api.Test;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.experience.core.entidades.rpg.experience.BatallaBuilder;
import tp.pp2.rpg.experience.core.extensible.CargadorHabilidades;

public class CargadorHabilidadesTest {
	private CargadorHabilidades cargadorHabilidades;
	private String path;
	private Batalla batalla;

	@SuppressWarnings("serial")
	@BeforeEach
	public void escenario() {
		path = "src\\main\\resources\\pluginsRuntime\\";
		//path="C:\\Users\\Fabián\\Documents\\pluginsRuntime\\";
		cargadorHabilidades = new CargadorHabilidades();
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
		List<Habilidad> habilidades = new ArrayList<Habilidad>();
		batalla = (new BatallaBuilder()).build(habilidades, personajes);
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
		cargadorHabilidades.cargar(batalla, path + "Herir.class");
		cargadorHabilidades.cargar(batalla, path + "Corte.class");
		assertEquals(batalla.getHabilidades().size(), 3);
	}

	@Test
	public void CA4_multiplesHabilidadesCargadas() throws Exception {
		cargadorHabilidades.cargar(batalla, path + "Corte.class");
		cargadorHabilidades.cargar(batalla, path + "Corte.class");
		assertEquals(batalla.getHabilidades().size(), 1);
	}
}
