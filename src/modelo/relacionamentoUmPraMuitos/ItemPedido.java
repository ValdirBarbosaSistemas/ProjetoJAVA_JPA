package modelo.relacionamentoUmPraMuitos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import modelo.basico.Produto;


		//RELACIONAMENTO UNIDIRECIONAL
@Entity
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false) // Não aceita valor nulo
	private int quantidade;

	@Column(nullable = false) // Também não aceita valor nulo
	private Double preco;

	/*
	 * Como podemos observar, a partir daqui temos uma relacao 'muitos pra um' //
	 * devido a situação em que nos encontramos neste momento. Portanto, colocamos a
	 * annotation chamada "ManyToOne".
	 */
	@ManyToOne
	private Pedido pedido;

	@ManyToOne
	private Produto produto;

	// Construtor padrão

	public ItemPedido() {
		super();
	}

	public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
		this.setQuantidade(quantidade);
		this.setPedido(pedido);
		this.setProduto(produto);
		// No código acima estamos colocando o set para na criação ele ja setar os itens
		// do produto
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		// Aqui eu posso fazer uma verificação para quando for setar o produto ja com o
		// preço
		if (produto != null && this.preco == null) { // Caso o produto não tenha sido setado ainda
			this.setPreco(produto.getPreco());
		}
	}

}
