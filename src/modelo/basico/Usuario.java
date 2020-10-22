package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/*
 * Significa que essa classe ela é uma entidade de um banco de dados, ou seja, a
 * tabela que irá ser criada terá o mesmo nome da classe. Assim que terminar as annotations, 
 * DEVE-SE ir no arquivo persistence.xml para referenciar a classe Usuario no banco de dados
 */
@Entity
public class Usuario {
	@Id // Significa que o atributo irá ser a chave primária do banco de dados
	@GeneratedValue // Gerando o id (no caso seria o auto incremento)
	private Long id;

	private String nome;

	@Transient // Dessa forma ele NÃO VAI para o banco de dados
	private String email;

	// Construtor padrão
	public Usuario() {

	}

	// Construtor

	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	// Getters e Setters

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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
