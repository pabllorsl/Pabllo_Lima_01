package pokeapp;

import exceptions.Verificador;

public class Pokemon {

	private String nome;
	private int nivel;
	private String tipo;
	private int ataqueBase;
	private Verificador verificador;

	public Pokemon(String nome, int nivel, String tipo, int ataqueBase) throws Exception {
		this.verificador = new Verificador();
		verificador.verificaPokemon(nome, nivel, tipo, ataqueBase);

		this.nome = nome;
		this.nivel = nivel;
		this.tipo = tipo;
		this.ataqueBase = ataqueBase;
	}

	public void ganhaNivel() {
		this.nivel++;
	}

	public int getPoderAtaque() {
		return this.getNivel() * this.getAtaqueBase();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNivel() {
		return nivel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAtaqueBase() {
		return ataqueBase;
	}

	public void setAtaqueBase(int ataqueBase) {
		this.ataqueBase = ataqueBase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nivel;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pokemon)) {
			return false;
		}

		Pokemon pokemon = (Pokemon) obj;
		return this.getNome().equals(pokemon.getNome()) && this.getNivel() == pokemon.getNivel();
	}

	@Override
	public String toString() {
		return String.format("%s (%s). lvl %d; power: %d", this.getNome(), this.getTipo(), this.getNivel(),
				this.getPoderAtaque());
	}

}
