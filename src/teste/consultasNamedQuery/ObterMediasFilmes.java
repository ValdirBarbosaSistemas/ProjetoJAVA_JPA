package teste.consultasNamedQuery;

import infra.DAO;
import modelo.consultaNativeNamedQuery.NotaFilme;

public class ObterMediasFilmes {
	public static void main(String[] args) {
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);

		NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");

		System.out.println(nota.getMedia());
		
		dao.fechar();
	}
}
