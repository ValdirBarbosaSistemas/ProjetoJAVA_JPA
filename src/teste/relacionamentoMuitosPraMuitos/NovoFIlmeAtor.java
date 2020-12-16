package teste.relacionamentoMuitosPraMuitos;

import infra.DAO;
import modelo.relacionamentoMuitosPraMuitos.Ator;
import modelo.relacionamentoMuitosPraMuitos.Filme;

public class NovoFIlmeAtor {
	public static void main(String[] args) {
		Filme filmeA = new Filme("Star Wars Ep. 4", 8.7);
		Filme filmeB = new Filme("O fugitivo", 9.9);

		Ator atorA = new Ator("Harrison Ford");
		Ator atrizB = new Ator("Carrie Fisher");

		filmeA.adicionarAtor(atorA);
		filmeA.adicionarAtor(atrizB);

		filmeB.adicionarAtor(atorA);

		// Abaixo vamos gerar operação em cascata

		DAO<Filme> dao = new DAO<Filme>();

		dao.incluirTransacaoAtomica(filmeA);
		/*
		 * No código acima ocorrerá que quando ele for criar o filme A, ele irá chamar
		 * TODOS os atores do filme A e vice-versa.
		 */
	}
}
