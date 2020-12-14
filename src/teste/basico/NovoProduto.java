package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	public static void main(String[] args) {

		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		/*
		 * Neste caso como eu passei o 'Produto.class' não será necessário passar o //
		 * parâmetro na inserção do dado, PORÉM se for fazer uma consulta irá precisar
		 * de passar novamente.
		 */

		Produto produto = new Produto("Caneta", 7.45);
		dao.abrirTransacao().incluirTransacao(produto).fecharTransacao().fechar();
		// Do modo como criamos o método para retornar o próprio DAO, podemos fazer
		// dessa maneira.

		Produto produto2 = new Produto("Notebook", 2987.78);
		dao.incluirTransacaoAtomica(produto2).fechar();
		/*
		 * Neste caso como criamos o método 'incluirTransacaoAtomica' e que ele já
		 * possui o 'abrir, incluir e fechar a transação', só fechamos a DAO no final.
		 */
		
		Produto produto3 = new Produto("Monitor23", 789.98);
		dao.incluirTransacaoAtomica(produto3).fechar();
	}
}
