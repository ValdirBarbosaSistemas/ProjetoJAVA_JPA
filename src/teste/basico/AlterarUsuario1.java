package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoJAVA_JPA");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 3L); // Consultando o usuario de cód. 3
		System.out.println(usuario.getNome()); // Consultado através do nome
		usuario.setNome("Carlos");

		em.merge(usuario);
		/*
		 * Neste caso para EFETIVAR a transação de uma ALTERAÇÃO usamos a palavra
		 * 'MERGE' e não 'persist', pois o PERSIST só é para CADASTRO
		 */

		System.out.println(usuario.getNome()); // NOME ALTERADO

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
