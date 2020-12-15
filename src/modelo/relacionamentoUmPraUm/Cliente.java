package modelo.relacionamentoUmPraUm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	/*
	 * Neste caso estamos querendo fazer um tipo de relacionamento "UNIDIRECINAL",
	 * ou seja, iremos focar em apenas um lado. Veremos no código abaixo...
	 * 
	 */

	@OneToOne(cascade = CascadeType.PERSIST)
	/*
	 * Essa propriedade serve para de forma automatizada fazer operações de //
	 * transação, ou seja, dessa forma ele vai persistir tanto o Cliente como também
	 * o assento caso não queira fazer de modo explícito.
	 */
	@JoinColumn(name = "assento_id", unique = true) // Desse modo a chave será ÚNICA não havendo duplicidade
	private Assento assentos; // Dessa maneira estarei tendo um acesso a classe Assento como um todo
	/*
	 * Dessa maneira no código acima, ele irá criar uma 'chave estrangeira' de nome
	 * 'assento_id' na classe Cliente, pois além de trazer os dados da classe
	 * Assento, ele também faz de forma automática devido a annotation "OneToOne".
	 */

	// Construtor padrão
	public Cliente() {
		super();
	}

	public Cliente(String nome, Assento assentos) {
		super();
		this.nome = nome;
		this.assentos = assentos;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Assento getAssentos() {
		return this.assentos;
	}

	public void setAssentos(Assento assentos) {
		this.assentos = assentos;
	}

}
