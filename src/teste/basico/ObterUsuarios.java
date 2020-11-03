package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {
	public static void main(String[] args) {
		/*
		 * Como iremos começar a trabalhar no mundo dos objetos, teremos que usar uma
		 * query chamada (JPQL= Java Persistence Query Language). Pois com ela
		 * trabalharemos com OBJETOS para consultar os dados no banco.
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoJAVA_JPA");
		EntityManager em = emf.createEntityManager();

		// Consulta em cima dos objetos
		String jpql = "select u from Usuario u"; // Neste caso no jpql não tem o '*' e a consulta é através da classe
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class); // Aqui ele vai consultar por tipo
		query.setMaxResults(5); // Aqui ele vai consultar no máximo 5 objetos

		List<Usuario> usuarios = query.getResultList(); // Aqui ele vai mostrar o resultado da consulta da lista

		for (Usuario usuario : usuarios) {
			System.out.println("ID: " + usuario.getId() + "Email: " + usuario.getEmail());
		}

		em.close();
		emf.close();
	}
}
