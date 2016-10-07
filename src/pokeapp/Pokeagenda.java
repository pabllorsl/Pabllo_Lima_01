package pokeapp;

import java.util.ArrayList;
import java.util.List;

public class Pokeagenda {

	private List<Pokemon> pokeagenda;
	private String FIM_DE_LINHA = System.lineSeparator();

	public Pokeagenda() {
		this.pokeagenda = new ArrayList<Pokemon>();
	}

	public void captura(Pokemon pokemon) {
		this.pokeagenda.add(pokemon);
	}

	public boolean jaCapturou(String nomePokemon) {
		for (Pokemon pokemon : pokeagenda) {
			if (pokemon.getNome().equalsIgnoreCase(nomePokemon)) {
				return true;
			}
		}

		return false;
	}

	public int getQtdPokemons() {
		return this.pokeagenda.size();
	}

	public Pokemon getMaisForte() {
		Pokemon pokemonMaisForte = pokeagenda.get(0);

		for (Pokemon pokemon : pokeagenda) {
			if (pokemon.getPoderAtaque() > pokemonMaisForte.getPoderAtaque()) {
				pokemonMaisForte = pokemon;
			}
		}

		return pokemonMaisForte;
	}

	public ArrayList<Pokemon> getPokemons(String tipoPokemon) {
		ArrayList<Pokemon> pokemonsTipoEspecifico = new ArrayList<Pokemon>();

		for (Pokemon pokemon : pokeagenda) {
			if (pokemon.getTipo().equalsIgnoreCase(tipoPokemon)) {
				pokemonsTipoEspecifico.add(pokemon);
			}
		}

		return pokemonsTipoEspecifico;
	}

	public int getPoderAtaque() {
		int poderAtaqueTotal = 0;

		for (Pokemon pokemon : pokeagenda) {
			poderAtaqueTotal += pokemon.getPoderAtaque();
		}

		return poderAtaqueTotal;
	}

	public List<Pokemon> getPokemons() {
		return pokeagenda;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pokeagenda)) {
			return false;
		}

		Pokeagenda pokeagenda = (Pokeagenda) obj;
		return this.getQtdPokemons() == pokeagenda.getQtdPokemons()
				&& this.getPoderAtaque() == pokeagenda.getPoderAtaque();
	}

	@Override
	public String toString() {
		String string = this.getQtdPokemons() + " pokemons capturados:" + FIM_DE_LINHA;

		for (int i = 0; i < pokeagenda.size(); i++) {
			if (i == pokeagenda.size() - 1) {
				string += (i + 1) + " - " + pokeagenda.get(i).toString();
			} else {
				string += (i + 1) + " - " + pokeagenda.get(i).toString() + FIM_DE_LINHA;
			}
		}

		return string;
	}

}
