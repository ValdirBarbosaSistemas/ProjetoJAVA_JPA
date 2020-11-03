package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoJAVA_JPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 3L); // Consultando o usuario de cód. 6
		System.out.println(usuario.getNome()); // Consultado através do email
		usuario.setNome("Carlos André");

		// em.merge(usuario);

		System.out.println(usuario.getNome()); // NOME ALTERADO

		em.getTransaction().commit();

		/*
		 * Quando o comando estiver em um 'estado de transação' INDEPENDENTEMENTE' IRÁ
		 * FAZER A ALTERAÇÃO. Mesmo se o merge estiver comentado ou se o início e fim da
		 * transação estiver depois da execução do código. Pois ele está em um tipo de
		 * estado 'GERENCIADO' ou seja, é quando o JPA tem um gerenciamento em cima de
		 * um objeto "por padrão".
		 */
		em.close();
		emf.close();
	}
}
