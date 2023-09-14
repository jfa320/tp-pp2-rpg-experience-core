package tp.pp2.rpg.generator.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tp.pp2.rpg.generator.core.entidades.Batalla;
import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;
import tp.pp2.rpg.generator.core.entidades.rpg.generator.RpgBattleGenerator;

public class RPGGeneratorTest {
	@Test
	public void CA1AtaqueEspecial() {
		/* por si las necesitamos para los test, sino con el JSON va bien de momento
		// Crear habilidades
        Habilidad H1 = new Habilidad(1,"H1", 600, "E");
        Habilidad H2 = new Habilidad(2, "H2", 10, "F");
        Habilidad H3 = new Habilidad(3, "H3", 50000, "F");

        // Crear listas de habilidades para personajes
        List<Habilidad> habilidadesP1 = new ArrayList<>();
        habilidadesP1.add(H1);
        habilidadesP1.add(H3);

        List<Habilidad> habilidadesP2 = new ArrayList<>();
        habilidadesP2.add(H2);
        
        // Crear personajes
        Personaje P1 = new Personaje("N1", "T1", 500, 200, 90, 120, 30, 50, habilidadesP1);
        Personaje P2 = new Personaje("N2", "T2", 1400, 500, 70, 60, 60, 70, habilidadesP2);
        */
		//esto del JSON no se si sirve para los test. Quizas deberiamos tener un constructor que cargue de esta manera
		//y otro que setee una batalla mockeada
       // String json="[{\"nombre\":\"N1\",\"tipo\":\"T1\",\"vidaInicial\":500,\"vidaActual\":200,\"ataqueFisico\":90,\"ataqueEspecial\":120,\"defensaFisica\":30,\"defensaEspecial\":50,\"habilidades\":[{\"id\":1,\"nombre\":\"H1\",\"danio\":600,\"tipo\":\"E\"},{\"id\":2,\"nombre\":\"H3\",\"danio\":50000,\"tipo\":\"F\"}]},{\"nombre\":\"N2\",\"tipo\":\"T2\",\"vidaInicial\":1400,\"vidaActual\":500,\"ataqueFisico\":70,\"ataqueEspecial\":60,\"defensaFisica\":60,\"defensaEspecial\":70,\"habilidades\":[{\"id\":3,\"nombre\":\"H2\",\"danio\":10,\"tipo\":\"F\"}]}]\r\n" + 
		//		"";
		
		RpgBattleGenerator rpgBattleGenerator = new RpgBattleGenerator();
		//rpgBattleGenerator.getEnfrentamiento().ejecutarHabilidad(rpgBattleGenerator.getEnfrentamiento().getPersonaje1().getHabilidades().get(0));
       // rpgBattleGenerator.setBatalla(new Batalla());
        //assertEquals(284, rpgBattleGenerator.getEnfrentamiento().getPersonaje2().getVidaActual());
        //esto no funciona hasta no definir en quien recae la responsabilidad de cambiar el turno
        //assertEquals("P2",rpgBattleGenerator.getEnfrentamiento().getPersonajeActivo()); 
	}
/*
	@Test
	public void pruebaMain() {
		String json="[{\"nombre\":\"N1\",\"tipo\":\"T1\",\"vidaInicial\":500,\"vidaActual\":200,\"ataqueFisico\":90,\"ataqueEspecial\":120,\"defensaFisica\":30,\"defensaEspecial\":50,\"habilidades\":[{\"id\":1,\"nombre\":\"H1\",\"danio\":600,\"tipo\":\"E\"},{\"id\":2,\"nombre\":\"H3\",\"danio\":50000,\"tipo\":\"F\"}]},{\"nombre\":\"N2\",\"tipo\":\"T2\",\"vidaInicial\":1400,\"vidaActual\":500,\"ataqueFisico\":70,\"ataqueEspecial\":60,\"defensaFisica\":60,\"defensaEspecial\":70,\"habilidades\":[{\"id\":3,\"nombre\":\"H2\",\"danio\":10,\"tipo\":\"F\"}]}]\r\n" + 
				"";
		RpgBattleGenerator classUnderTest = new RpgBattleGenerator(json);
		System.out.println(classUnderTest.getEnfrentamiento().toString());
	}*/
}
