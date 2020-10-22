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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projeto_JPA");
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

		// para inserir um objeto no banco de dados usaremos um método 'persist'

		Usuario novoUsuario = new Usuario("Djalma", "djalma@lanche.com.br");
		/*
		 * Para se colocar um dado no banco temos que 'criar' uma transação e ao término
		 * fechar o mesmo como veremos no código abaixo.
		 */
		em.getTransaction().begin();
		em.persist(novoUsuario); // Colocando o objeto no banco de dados
		em.getTransaction().commit(); // Efetivando a transação do dado no banco

		em.close(); // fechando o entityManager
		emf.close(); // fechando o entitymanagerFactory
	}
}
