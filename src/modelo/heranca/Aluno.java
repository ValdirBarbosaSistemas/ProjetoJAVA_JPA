package modelo.heranca;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AL")
public class Aluno {

	@Id
	private Long matricula;

	private String nome;

	// Construtor padrão
	public Aluno() {

	}

	public Aluno(Long matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}

	public Long getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	 * Na HERANÇA, temos uma maneira de se criar uma tabela que é com a palavra
	 * reservada (INHERITANCE). E também nela temos 3 propriedades para se dizer
	 * qual o tipo da tabela de herança que iremos criar que são: SINGLE_TABLE (UMA
	 * ÚNICA TABELA), JOINED (JUNÇÃO DE TABELA) E TABLE_PER_CLASS (TABELA SEPARADA
	 * POR CLASSE). CASO VOCE NÃO COLOQUE NENHUMA PROPRIEDADE, POR PADRÃO ELA SERÁ
	 * SINGLE_TABLE. NO SINGLE_TABLE PARA PODERMOS DIFERENCIAR QUEM É QUEM NA
	 * TABELA, TEMOS QUE CRIAR (DISCRIMINATOR) QUE COMO O NOME JÁ DIZ, ELE VAI
	 * DIFERENCIAR PELO NOME QUE COLOCAMOS QUEM VAI SER NAS RESPECTIVAS TABELAS.
	 * COMO VEMOS NO CÓDIGO ACIMA, TEMOS 2 DISCRIMINATORS (DISCRIMINATOR COLUMN E
	 * DISCRIMINATOR VALUE). NO DISCRIMINATOR COLUMN ELE IRÁ TER 3 PROPRIEDADES QUE
	 * SÃO "NAME", "LENGTH" E "DISCRIMINATOR TYPE". JÁ NO DISCRIMINATOR VALUE ELE
	 * IRÁ DIZER QUAL O VALOR QUE IRÁ TER NA TABELA QUANDO FOR CRIADA.
	 */
}
