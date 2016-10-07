package pokeapp;

import java.util.ArrayList;

public class Treinador {

	private String nome;
	private Pokeagenda pokeagenda;
	private Mochila mochila;
	private String FIM_DE_LINHA = System.lineSeparator();

	public Treinador(String nome) {
		this.nome = nome;
		this.pokeagenda = new Pokeagenda();
		this.mochila = new Mochila();
	}

	public void captura(Pokemon pokemon) {
		this.pokeagenda.captura(pokemon);
	}

	public boolean jaCapturou(String nomePokemon) {
		return this.pokeagenda.jaCapturou(nomePokemon);
	}

	public int getQtdPokemons() {
		return this.pokeagenda.getQtdPokemons();
	}

	public Pokemon getMaisForte() {
		return this.pokeagenda.getMaisForte();
	}

	public ArrayList<Pokemon> getPokemons(String tipoPokemon) {
		return this.pokeagenda.getPokemons(tipoPokemon);
	}

	public int getPoderAtaque() {
		return this.pokeagenda.getPoderAtaque();
	}

	public String lutaContra(Treinador treinador) {
		if (this.getPoderAtaque() > treinador.getPoderAtaque()) {
			return "Aew, ganhei! Sou mais forte que " + treinador.getNome() + ".";
		} else if (this.getPoderAtaque() == treinador.getPoderAtaque()) {
			return "Eu e " + treinador.getNome() + " estamos empatados.";
		} else { // if (this.getPoderAtaque() < treinador.getPoderAtaque()){
			return "Droga, perdi! " + treinador.getNome() + " eh mais forte!";
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pokeagenda getPokeagenda() {
		return pokeagenda;
	}

	public void adicionaItem(String nome, double preco) {
		mochila.adicionaItem(nome, preco);
	}

	public boolean contemItem(String nome) {
		return mochila.contemItem(nome);
	}

	public double lucroTotal() {
		return mochila.lucroTotal();
	}

	public int getQtdItens() {
		return mochila.getQtdItens();
	}

	public boolean removeItem(String nome) {
		return mochila.removeItem(nome);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pokeagenda == null) ? 0 : pokeagenda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Treinador)) {
			return false;
		}

		Treinador treinador = (Treinador) obj;
		return this.getNome().equalsIgnoreCase(treinador.getNome())
				&& this.getPokeagenda().equals(treinador.getPokeagenda());
	}

	@Override
	public String toString() {
		String string = "Ola, sou " + this.getNome() + "." + FIM_DE_LINHA + "Meu poder total eh "
				+ this.getPoderAtaque() + ", vai encarar?!" + FIM_DE_LINHA;

		string += pokeagenda.toString();

		return string;
	}

}
