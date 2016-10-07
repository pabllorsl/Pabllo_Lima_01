package pokeapp;

import java.util.HashSet;
import java.util.Set;

public class Mochila {

	private Set<Item> mochila;

	public Mochila() {
		this.mochila = new HashSet<Item>();
	}

	public void adicionaItem(String nome, double preco) {
		this.mochila.add(new Item(nome, preco));
	}

	public boolean contemItem(String nome) {
		for (Item item : mochila) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}

		return false;
	}

	public double lucroTotal() {
		double lucroTotal = 0.0;

		for (Item item : mochila) {
			lucroTotal += item.getPreco();
		}

		return lucroTotal;
	}

	public int getQtdItens() {
		return mochila.size();
	}

	public boolean removeItem(String nome) {
		for (Item item : mochila) {
			if (item.getNome().equalsIgnoreCase(nome)) {
				mochila.remove(item);
				return true;
			}
		}

		return false;
	}

}
