package teste.relacionamentoUmPraUm;

import infra.DAO;
import modelo.relacionamentoUmPraUm.Assento;
import modelo.relacionamentoUmPraUm.Cliente;

public class NovoClienteAssento2 {
	public static void main(String[] args) {
		Assento assento = new Assento("4D");
		Cliente cliente = new Cliente("Rodrigo", assento);

		DAO<Cliente> dao = new DAO<>();

		/*
		 * Digamos que eu queira fazer uma transação de modo 'atômico'. Sabemos que no
		 * modo atômico só tem uma inclusão de transação e devido a isso não temos como
		 * incluir mais uma transação que no caso é a do assento. Como podemos resolver
		 * isso? Quando fazemos uma transação de um atributo que não existe, ele vai dar
		 * erro. Para isso teremos que ir na classe 'Cliente' e colocar uma propriedade
		 * na annotation 'OneToOne' chamada "Cascade".
		 */
		dao.incluirTransacaoAtomica(cliente);
	}
}
