package modelo.composicao;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String logradouro;
	private String complemento;

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/*
	 * Neste caso como não temos uma tabela endereco, as informações dessa classe
	 * irão para as tabelas Funcionario e Fornecedor. E para isso usamos o
	 * 'Embeddable', que serve para colocar as informações dessa classe Endereco nas
	 * tabelas que irão para o banco de dados. Fazendo isso temos que ir no
	 * 'persistence.xml' para colocar os dados dessa classe no arquivo.
	 */
}
