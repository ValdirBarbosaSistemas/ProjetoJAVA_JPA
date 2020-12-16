package modelo.relacionamentoMuitosPraMuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Double nota;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "atores_filmes", // Serve para voce mudar o nome da junção da terceira tabela
			joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id"))
	private List<Ator> atores; // Já que no 'getAtores' irá ser a criação

	/*
	 * O que essas propriedades do código acima fazem? Elas simplismente fazem com
	 * que temos 2 chaves primárias que referenciam 2 tabelas diferentes indo pra
	 * uma tabela intermediária
	 */

	// Construtor padrão
	public Filme() {

	}

	public Filme(String nome, Double nota) {
		this.nome = nome;
		this.nota = nota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Ator> getAtores() {
		// Aqui ele sempre irá criar uma lista vazia
		if (atores == null) {
			atores = new ArrayList<>();
		}
		return this.atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	// Implementação para adicionar o ator na lista de filmes
	public void adicionarAtor(Ator ator) {
		if (ator != null && !getAtores().contains(ator)) {
			getAtores().add(ator);

			if (!ator.getFilmes().contains(this)) {
				ator.getFilmes().add(this);
			}
		}
	}
}
