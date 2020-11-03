package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuario {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoJAVA_JPA");
		EntityManager em = emf.createEntityManager();

		Usuario usuario = em.find(Usuario.class, 6L);// Consultando o usuario para a exclusão
		/*
		 * Em qualquer ambiente que haja mudanças no banco de dados, seja na inclusão,
		 * alteração ou exclusão, ele irá ter que entrar no 'ambiente' de TRANSAÇÃO para
		 * poder efetuar a ordem.
		 */
		if (usuario != null) {
			em.getTransaction().begin(); // Início da transação
			em.remove(usuario); // Removendo os dados
			em.getTransaction().commit(); // Fim da transação
		}
		em.close();
		emf.close();
	}
}
