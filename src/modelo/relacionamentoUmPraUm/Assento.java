package modelo.relacionamentoUmPraUm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assentos")
public class Assento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	/*
	 * No código abaixo iremos fazer um relacionamento BIDIRECIONAL. Para isso
	 * usamos a propriedade "mappedBy" que faz com que digamos que aquele
	 * determinado atributo ja foi mapeado uma vez.
	 */
	@OneToOne(mappedBy = "assentos") // Para se fazer relacionamento BIDIRECIONAL
	private Cliente cliente;

	// Construtor padrão
	public Assento() {
		super();
	}

	public Assento(String nome) {
		super();
		this.nome = nome;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
