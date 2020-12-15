package teste.relacionamentoUmPraUm;

import infra.DAO;
import modelo.relacionamentoUmPraUm.Assento;
import modelo.relacionamentoUmPraUm.Cliente;

public class NovoClienteAssento1 {
	public static void main(String[] args) {
		// Criando o assento...
		Assento assento = new Assento("19C");
		// Criando o cliente...
		Cliente cliente = new Cliente("Carlos", assento);

		DAO<Object> dao = new DAO<Object>(); // Criando um DAO GENÉRICO

		// Criando a transação para se colocar no banco
		dao.abrirTransacao()
		.incluirTransacao(assento)
		.incluirTransacao(cliente)
		.fecharTransacao()
		.fechar();
		/*
		 * Lembrando que estamos querendo um tipo de relacionamento UM PRA UM, ou seja,
		 * não poderá haver duplicidade de código ref. ao assento. E Devido a isso por
		 * padrão, o relacionamento "OneToOne" ele não cria a chave UNIQUE, ou seja,
		 * vamos ter que criar na classe Cliente uma annotation chamada "JoinColumn" que
		 * ele é específico para mapear campos que representam junção de tabelas.
		 */
	}
}
