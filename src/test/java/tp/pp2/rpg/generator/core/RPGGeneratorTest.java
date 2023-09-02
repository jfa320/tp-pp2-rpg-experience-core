package tp.pp2.rpg.generator.core;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tp.pp2.rpg.generator.core.entidades.rpg.generator.RpgBattleGenerator;

public class RPGGeneratorTest {
	@Test
	public void someMethodReturnsTrue() {
		RpgBattleGenerator classUnderTest = new RpgBattleGenerator("");
		assertTrue("someLibraryMethod should return 'true'", true);
	}

	@Test
	public void pruebaMain() {
		String json="[{\"nombre\":\"N1\",\"tipo\":\"T1\",\"vidaInicial\":500,\"vidaActual\":200,\"ataqueFisico\":90,\"ataqueEspecial\":120,\"defensaFisica\":30,\"defensaEspecial\":50,\"habilidades\":[{\"id\":1,\"nombre\":\"H1\",\"danio\":600,\"tipo\":\"E\"},{\"id\":2,\"nombre\":\"H3\",\"danio\":50000,\"tipo\":\"F\"}]},{\"nombre\":\"N2\",\"tipo\":\"T2\",\"vidaInicial\":1400,\"vidaActual\":500,\"ataqueFisico\":70,\"ataqueEspecial\":60,\"defensaFisica\":60,\"defensaEspecial\":70,\"habilidades\":[{\"id\":3,\"nombre\":\"H2\",\"danio\":10,\"tipo\":\"F\"}]}]\r\n" + 
				"";
		RpgBattleGenerator classUnderTest = new RpgBattleGenerator(json);
		System.out.println(classUnderTest.getEnfrentamiento().toString());
	}
}
