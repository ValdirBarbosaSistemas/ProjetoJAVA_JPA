package teste.relacionamentoUmPraUm;

import infra.DAO;
import modelo.relacionamentoUmPraUm.Assento;
import modelo.relacionamentoUmPraUm.Cliente;

public class ObterClienteAssento {
	public static void main(String[] args) {

		// RELACIONAMENTO BIDIRECIONAL

		DAO<Cliente> daoCliente = new DAO<Cliente>(Cliente.class);
		// Aprendemos que no código acima, colocando como parâmetro o nome da classe,
		// fica melhor de se fazer consultas

		Cliente cliente = daoCliente.obterPorID(1L);
		System.out.println(cliente.getAssentos().getNome());

		daoCliente.fechar();
		
		DAO<Assento> daoAssento = new DAO<Assento>(Assento.class);
	
		Assento assento = daoAssento.obterPorID(4L);
		System.out.println(assento.getCliente().getNome());

		daoAssento.fechar();
	}
}
