package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	/*
	 * Acima vemos que foi usado um "Generics". Fizemos isso para que a mesma não
	 * ficasse um único tipo de entidade, ou seja, podemos no futuro dizer que ela é
	 * um "Usuário" ou futuramente um "Produto". Um outro exemplo para ficar melhor
	 * a organização e mais restrito, seria criar uma 'interface' que podemos chamar
	 * de "interface MARCADORA" para que sempre quando for executado, ela de forma
	 * 'obrigatória', ou seja, somente as classes que implementarem a interface
	 * serão colocadas no DAO.
	 */

	private static EntityManagerFactory emf; // Declarando um entityManagerFactory
	private EntityManager em; // Criando um entityManager
	private Class<E> classe; // Declarando uma classe para o find (consulta)
	/*
	 * Outra maneira de inicializar seria melhor em um bloco estático, ou seja, ele
	 * só inicializa uma única vez quando a classe for carregada pelo java. OBS:
	 * sempre quando for usar o bloco estático é bom tratar ele através do
	 * try/catch, pois se caso ocorrer um erro ele simplismente não carregará a
	 * página.
	 */

	static {
		try {
			emf = Persistence.createEntityManagerFactory("ProjetoJAVA_JPA"); // Criando o EntityManagerFactory
		} catch (Exception e) {
			// logar -> log4j (api do java)
		}
	}

	/*
	 * Sempre quando fazemos uma consulta, precisamos dizer a "Classe" para poder
	 * efetuar, ou seja, precisamos de criar um objeto chamado "Classe" para isso.
	 * Precisamos passar a classe como parâmetro no CONSTRUTOR.
	 */
	public DAO(Class<E> classe) {
		em = emf.createEntityManager(); // Criando a instancia através do construtor
		this.classe = classe;
		/*
		 * Esse construtor faz com que toda vez quando se iniciar a transação e fazer
		 * uma consulta, geralmente quando faz isso ele pede para colocar como parâmetro
		 * o nome do arquivo '.class', ou seja, ele aqui ta fazendo de uma maneira
		 * 'automática'. Não vai precisar fazer manualmente.
		 */
	}

	public DAO() {
		this(null); // Passando a classe nula
	}

	// PARTE DE TRANSAÇÃO

	/*
	 * Existe uma técnica interessante de que quando voce cria um método que ele
	 * RETORNA O MESMO TIPO DA CLASSE ATUAL, quando ele é chamado, ele pode ser
	 * encadeado várias vezes como vemos no código abaixo...
	 * 
	 * public DAO<E> teste() { return this; }
	 * 
	 * public static void main(String[] args) { new
	 * DAO<Produto>().teste().teste().teste();
	 * 
	 * }
	 */

	// Abrindo uma transação
	public DAO<E> abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}

	// Confirmando uma transação
	public DAO<E> fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}

	// Incluindo uma transação
	public DAO<E> incluirTransacao(E entidade) {
		em.persist(entidade);
		return this;
	}

	
	/*
	 * Podemos criar um método que faz tudo isso que fizemos no código acima, que
	 * justamente foi no exemplo de encadeamente anterior. Veremos abaixo...
	 */
	
	public DAO<E> incluirTransacaoAtomica(E entidade) {
		return this.abrirTransacao().incluirTransacao(entidade).fecharTransacao();
	} 
	

	// Para obter todos os registros do banco de uma forma simples

	public List<E> obterTodos(int qtde, int desloc) {
		if (classe == null) {
			throw new UnsupportedOperationException("A classe está nula");
		}

		String jpql = "select e from " + classe.getName() + "e";
		// Toda consulta em JPQL precisa ter um "alias" ou variável
		TypedQuery<E> query = em.createQuery(jpql, classe); // Ele vai retornar a minha consulta
		query.setMaxResults(qtde);
		query.setFirstResult(desloc);
		return query.getResultList();
	}
	/*
	 * No código acima teremos 2 parâmetros... Um para ver a quantidade de registros
	 * que voce quer pesquisar, e o segundo parâmetro é para voce "deslocar" ou
	 * separar a partir de uma determinada parte que voce quer. Exemplo... Eu tenho
	 * 30 registros e quero pesquisar 15 registros, sendo que a partir do registro
	 * 10, ou seja, no primeiro parâmetro eu coloco (15) que é o que eu quero
	 * pesquisar e no segundo eu coloco (10) que é onde eu quero que pegue os
	 * registros a partir desse número. Ficaria mais ou menos assim (15,10).
	 */

	// Fechando transação
	public void fechar() {
		em.close();
	}
}