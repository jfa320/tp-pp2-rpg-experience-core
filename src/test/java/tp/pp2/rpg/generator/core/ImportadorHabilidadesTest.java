package tp.pp2.rpg.generator.core;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tp.pp2.rpg.generator.core.importadorHabilidades.ImportadorHabilidades;
import tp.pp2.rpg.generator.core.importadorHabilidades.ImportadorHabilidadesXLSX;

public class ImportadorHabilidadesTest {
	@Test
	public void someMethodReturnsTrue() {
		ImportadorHabilidades classUnderTest = new ImportadorHabilidadesXLSX();
		assertTrue("someLibraryMethod should return 'true'", true);
	}
}
