package teste.relacionamentoUmPraMuitos;

import infra.DAO;
import modelo.relacionamentoUmPraMuitos.ItemPedido;
import modelo.relacionamentoUmPraMuitos.Pedido;

public class ObterPedido {
	public static void main(String[] args) {
		DAO<Pedido> dao = new DAO<Pedido>(Pedido.class); // Para consultar colocamos o '.class'

		Pedido pedido = dao.obterPorID(1L);

		for (ItemPedido item : pedido.getItens()) {
			System.out.println(item.getQuantidade());
		}

		dao.fechar();

		/*
		 * FIXME ESTUDAR POSTERIORMENTE 'LAZY' E 'EAGER' EM RELAÇÃO A ANNOTATION E
		 * RELACIONAMENTOS UM PRA MUITOS E MUITOS PRA MUITOS ENTRE OUTROS.
		 */
	}
}
