package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsuario {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoJAVA_JPA");
		EntityManager em = emf.createEntityManager();

		/*
		 * No código abaixo no primeiro parametro ele quer o tipo de classe que quero
		 * mapear a partir do resultado do banco e o segundo é o indentificador que
		 * quero usar para consultar.
		 */
		Usuario usuario = em.find(Usuario.class, 1L);

		System.out.println(usuario.getNome()); // Irá mostrar o usuário que voce solicitou
		/*
		 * Quando voce quer consultar um usuário, você não precisa fazer 'transações'. A
		 * transação só se é necessária para a criação de objetos.
		 */
		em.close();
		emf.close();
	}
}
