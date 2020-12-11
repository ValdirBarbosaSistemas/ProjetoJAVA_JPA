package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
	public static void main(String[] args) {
		/*
		 * Neste caso aqui é a maneira mais CORRETA de se fazer, pois com o NÃO
		 * GERENCIADO ele fica "mais seguro" de se fazer transações de dados.
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoJAVA_JPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 3L); // Consultando o usuario de cód. 3

		em.detach(usuario); // Para DESASSOCIAR A ALTERAÇÃO, É NECESSÁRIO USAR A PALAVRA 'DETACH'

		System.out.println(usuario.getNome()); // Consultado através do nome
		usuario.setNome("Carlos de Souza");

		em.merge(usuario); // NOME NÃO ALTERADO, pois só altera agora com a palavra 'MERGE'

		System.out.println(usuario.getNome()); 

		em.getTransaction().commit();

		em.close();
		emf.close();

	}
}
