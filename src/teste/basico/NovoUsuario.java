package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	public static void main(String[] args) {
		EntityManager em;
		/*
		 * Nessa classe veremos a criação das entidades para ser adicionada ao banco, ou
		 * seja aqui iremos criar as inserções, alterações e exclusões de cada
		 * linha/coluna do banco. E para isso veremos os objetos (EntityManager) que é o
		 * 'gerente das entidades' que serve para inserir uma entidade, alterar uma
		 * entidade entre outros, ou seja, é ele que irá fazer o CRUD para o banco de
		 * dados... Ele vai converter os dados dos objetos em dados SQL.
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoJAVA_JPA");
		/*
		 * Aqui no caso ele ta 'setando' o projeto para ser criado o banco com o nome,
		 * ou seja, todas as configurações realizadas ref. ao banco de dados feitos no
		 * 'persistence.xml', serão criados a partir daqui. OBS: SE TIVER OUTRO BANCO DE
		 * DADOS/OUTRAS CONFIGURAÇÕES, TERIA QUE SE CRIAR OUTRO 'PERSISTENCE.XML' E
		 * CONSEQUENTEMENTE OUTRO 'ENTITYMANAGERFACTORY'.
		 */

		/*
		 * O papel do (EntityManagerFactory) é criar um ENTITYMANAGER, ou seja, é aqui
		 * que ele irá criar uma conexao com o banco para poder 'rodar' no
		 * entityManager.
		 */

		em = emf.createEntityManager();

		/*
		 * para inserir um objeto (pois no JPA trabalhamos no mundo dos objetos) no
		 * banco de dados usaremos um método 'persist'
		 */
		Usuario novoUsuario = new Usuario("Arthur", "arthur@lanche.com.br");
		/*
		 * Para se colocar um dado no banco temos que 'criar' uma transação e ao término
		 * fechar o mesmo como veremos no código abaixo.
		 */
		em.getTransaction().begin(); // Criando a transação do dado no banco
		em.persist(novoUsuario); // Colocando o objeto no banco de dados
		em.getTransaction().commit(); // Efetivando a transação do dado no banco

		/*
		 * Na criação do objeto, ele só irá gerar o 'id' a partir do 'persist', ou seja,
		 * antes disso ele não gera nada. Caso queira saber qual foi o 'id' gerado na
		 * hora da criação, basta ver pelo getNome como mostra o código abaixo.
		 */

		System.out.println(novoUsuario.getNome());

		/*
		 * No JPA, o (PERSIST) SÓ IRÁ SER CRIADO QUANDO VOCE COLOCA A TRANSAÇÃO, caso
		 * não tenha, ele não irá ser adicionado ao banco.
		 */
		em.close(); // fechando o entityManager
		emf.close(); // fechando o entitymanagerFactory
	}
}
