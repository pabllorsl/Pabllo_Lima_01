package exceptions;

public class Verificador {

	public void verificaPokemon(String nome, int nivel, String tipo, int ataqueBase) throws Exception {
		verificaNome(nome);
		verificaNivel(nivel);
		verificaTipo(tipo);
		verificaAtaqueBase(ataqueBase);
	}

	private void verificaNome(String nome) throws Exception {
		if (stringNulaVazia(nome)) {
			throw new Exception("Nome de Pokemon nao pode ser nulo ou vazio.");
		}
	}

	private void verificaNivel(int nivel) throws Exception {
		if (inteiroMenorQueUm(nivel)) {
			throw new Exception("Nivel de Pokemon deve ser maior que zero.");
		}
	}

	private void verificaTipo(String tipo) throws Exception {
		if (tipo != "Agua" && tipo != "Fogo" && tipo != "Eletrico" && tipo != "Grama" && tipo != "Gelo"
				&& tipo != "Dragao" && tipo != "Fantasma" && tipo != "Psiquico") {
			throw new Exception("Tipo " + tipo
					+ " eh invalido. Sao permitidos apenas: Agua, Fogo, Eletrico, Grama, Gelo, Dragao, Fantasma e Psiquico.");
		}
	}

	private void verificaAtaqueBase(int ataqueBase) throws Exception {
		if (inteiroMenorQueZero(ataqueBase)) {
			throw new Exception("Poder de ataque de pokemon deve ser maior ou igual a zero.");
		}
	}

	private boolean stringNulaVazia(String string) {
		if (string == null || string.trim().isEmpty()) {
			return true;
		}

		return false;
	}

	private boolean inteiroMenorQueUm(int inteiro) {
		if (inteiro < 1) {
			return true;
		}

		return false;
	}

	private boolean inteiroMenorQueZero(int inteiro) {
		if (inteiro < 0) {
			return true;
		}

		return false;
	}

}
