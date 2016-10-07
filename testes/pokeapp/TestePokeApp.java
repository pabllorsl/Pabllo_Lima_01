package pokeapp;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pokeapp.Pokemon;
import pokeapp.Treinador;

public class TestePokeApp {

	private Pokemon starmie;
	private Pokemon pikachu;
	private Pokemon squirtle;
	private Pokemon articuno;
	private Treinador neto;
	private Treinador ash;

	@Before
	public void setup() throws Exception {
		starmie = new Pokemon("Starmie", 50, "Psiquico", 15);
		pikachu = new Pokemon("Pikachu", 30, "Eletrico", 10);
		squirtle = new Pokemon("Squirtle", 15, "Agua", 8);
		articuno = new Pokemon("Articuno", 50, "Gelo", 20);

		neto = new Treinador("Neto");
		ash = new Treinador("Ash");
	}

	@Test
	public void testeProva() throws Exception {
		testePasso1();
		testePasso2e3();
		testePasso4();
		testePasso5();
		
		//testes extras: descomente para verificar sua implementacao.
		testeExtraException();
		testeExtraMochila();
	}

	private void testePasso1() throws Exception {
		Pokemon starmieRaro = new Pokemon("Starmie", 50, "Psiquico", 18);

		Assert.assertEquals("Starmie", starmie.getNome());
		Assert.assertEquals("Psiquico", starmie.getTipo());
		Assert.assertEquals(50, starmie.getNivel());
		Assert.assertEquals(15, starmie.getAtaqueBase());
		Assert.assertEquals(750, starmie.getPoderAtaque());

		Assert.assertEquals("Starmie", starmieRaro.getNome());
		Assert.assertEquals("Psiquico", starmieRaro.getTipo());
		Assert.assertEquals(50, starmieRaro.getNivel());
		Assert.assertEquals(18, starmieRaro.getAtaqueBase());
		Assert.assertEquals(900, starmieRaro.getPoderAtaque());

		Assert.assertEquals(starmie, starmieRaro);
		Assert.assertNotEquals(starmie, pikachu);

		starmieRaro.ganhaNivel();
		Assert.assertEquals(51, starmieRaro.getNivel());
		Assert.assertNotEquals(starmie, starmieRaro);
	}

	private void testePasso2e3() throws Exception {
		Pokemon starmieRaro = new Pokemon("Starmie", 50, "Psiquico", 18);
		neto.captura(starmie);
		neto.captura(articuno);
		neto.captura(starmieRaro);

		// ------- Passo 2 -----------
		Assert.assertTrue(neto.jaCapturou("Starmie"));
		Assert.assertTrue(neto.jaCapturou("Articuno"));
		Assert.assertFalse(neto.jaCapturou("Pikachu"));
		Assert.assertFalse(neto.jaCapturou("Vileplume"));
		Assert.assertFalse(neto.jaCapturou("Pidget"));

		Assert.assertEquals(articuno, neto.getMaisForte());
		Assert.assertEquals(3, neto.getQtdPokemons());

		// --------------- Passo 3: --------------
		// buscas de pokemons por tipo
		ArrayList<Pokemon> pokemonsPsiquicos = neto.getPokemons("Psiquico");
		ArrayList<Pokemon> pokemonsGelo = neto.getPokemons("Gelo");
		Assert.assertEquals(2, pokemonsPsiquicos.size());
		Assert.assertEquals(1, pokemonsGelo.size());
		Assert.assertEquals(starmie, pokemonsPsiquicos.get(0));
		Assert.assertEquals(articuno, pokemonsGelo.get(0));

		// neto tem:
		// starmie: 750
		// articuno: 1000
		// starmie: 900
		Assert.assertEquals(2650, neto.getPoderAtaque());

		// Repetindo os testes do passo 2 e 3 para Ash.
		Assert.assertEquals(0, ash.getPoderAtaque());
		Assert.assertEquals(0, ash.getQtdPokemons());
		ash.captura(pikachu);
		ash.captura(squirtle);
		Assert.assertEquals(2, ash.getQtdPokemons());
		Assert.assertEquals(pikachu, ash.getMaisForte());

		ArrayList<Pokemon> pokemonsEletrico = ash.getPokemons("Eletrico");
		ArrayList<Pokemon> pokemonsAgua = ash.getPokemons("Agua");
		Assert.assertEquals(1, pokemonsEletrico.size());
		Assert.assertEquals(1, pokemonsAgua.size());
		Assert.assertEquals(pikachu, pokemonsEletrico.get(0));
		Assert.assertEquals(squirtle, pokemonsAgua.get(0));
		Assert.assertEquals(420, ash.getPoderAtaque());
	}

	private void testePasso4() throws Exception {
		// Os metodos estao sendo testados pelo treinador nas chamadas
		// anteriores. Verifique aqui a apresentacao em String dos treinadores.
		// confira o resultado dos sysos abaixo.
		System.out.println(ash);
		System.out.println();
		System.out.println(neto);

		// Testar dois treinadores iguais
		Pokemon starmieRaro = new Pokemon("Starmie", 50, "Psiquico", 18);
		Treinador netoClone = new Treinador("Neto");
		netoClone.captura(starmie);
		netoClone.captura(articuno);
		netoClone.captura(starmieRaro);

		Assert.assertEquals(neto, netoClone);
		Assert.assertNotEquals(neto, ash);
	}

	private void testePasso5() throws Exception {
		Pokemon mewtwo = new Pokemon("Mewtwo", 100, "Psiquico", 25);
		Pokemon mewtwo2 = new Pokemon("Mewtwo", 100, "Psiquico", 25);
		Pokemon giratina = new Pokemon("Giratina", 100, "Fantasma", 20);
		Pokemon hooh = new Pokemon("Ho oh", 100, "Fogo", 28);

		Treinador joaozinho = new Treinador("Joaozinho Hack");// huehueBR
		joaozinho.captura(mewtwo);
		joaozinho.captura(mewtwo2);
		joaozinho.captura(giratina);
		joaozinho.captura(hooh);

		Treinador lance = new Treinador("Lance");
		lance.captura(new Pokemon("Dragonite", 50, "Dragao", 17));
		lance.captura(new Pokemon("Gyarados", 100, "Agua", 18));

		String netoVSash = "Aew, ganhei! Sou mais forte que Ash.";
		String netoVSlance = "Eu e Lance estamos empatados.";
		String netoVSjoazinho = "Droga, perdi! Joaozinho Hack eh mais forte!";

		Assert.assertEquals(netoVSash, neto.lutaContra(ash));
		Assert.assertEquals(netoVSlance, neto.lutaContra(lance));
		Assert.assertEquals(netoVSjoazinho, neto.lutaContra(joaozinho));
	}

	private void testeExtraException() throws Exception {
		try {
			new Pokemon("", 50, "Agua", 15);
			Assert.fail("Exception deveria ter sido lancada.");
		} catch (Exception e) {
			Assert.assertEquals("Nome de Pokemon nao pode ser nulo ou vazio.", e.getMessage());
		}
		try {
			new Pokemon("Abra", 0, "Psiquico", 15);
			Assert.fail("Exception deveria ter sido lancada.");
		} catch (Exception e) {
			Assert.assertEquals("Nivel de Pokemon deve ser maior que zero.", e.getMessage());
		}
		try {
			new Pokemon("Magikarp", 1, "Agua", -50);
			Assert.fail("Exception deveria ter sido lancada.");
		} catch (Exception e) {
			Assert.assertEquals("Poder de ataque de pokemon deve ser maior ou igual a zero.", e.getMessage());
		}
		try {
			new Pokemon("Clefairy", 1, "Fada", 25);
			Assert.fail("Exception deveria ter sido lancada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Tipo Fada eh invalido. Sao permitidos apenas: Agua, Fogo, Eletrico, Grama, Gelo, Dragao, Fantasma e Psiquico.",
					e.getMessage());
		}
		try {
			new Pokemon("Magnemite", 1, "Metal", 25);
			Assert.fail("Exception deveria ter sido lancada.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Tipo Metal eh invalido. Sao permitidos apenas: Agua, Fogo, Eletrico, Grama, Gelo, Dragao, Fantasma e Psiquico.",
					e.getMessage());
		}
	}
	
	private void testeExtraMochila() throws Exception {
		neto.adicionaItem("Master Ball", 150.50);
		neto.adicionaItem("Ultra Ball", 75.00);
		neto.adicionaItem("Revive", 29.90);

		Assert.assertTrue(neto.contemItem("Master Ball"));
		Assert.assertTrue(neto.contemItem("Ultra Ball"));
		Assert.assertFalse(neto.contemItem("Great Ball"));
		Assert.assertFalse(neto.contemItem("Rare Candy"));

		Assert.assertEquals(255.40, neto.lucroTotal(), 0.001);
		Assert.assertEquals(3, neto.getQtdItens());

		Assert.assertTrue(neto.removeItem("Master Ball"));
		Assert.assertFalse(neto.removeItem("Full Restore"));

		Assert.assertFalse(neto.contemItem("Master Ball"));
		Assert.assertTrue(neto.contemItem("Ultra Ball"));

		Assert.assertEquals(104.9, neto.lucroTotal(), 0.001);
		Assert.assertEquals(2, neto.getQtdItens());
	}
}
