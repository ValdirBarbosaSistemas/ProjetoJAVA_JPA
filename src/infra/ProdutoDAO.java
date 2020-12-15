package infra;

import modelo.basico.Produto;

public class ProdutoDAO extends DAO<Produto> {

    // Outra maneira de resolver o generics. Aqui voce pode criar funcionalidades que APENAS o produto tem

    // Em vez de chamar o construtor padrão, eu chamo o construtor que já recebe a classe
    public ProdutoDAO() {
        super(Produto.class);
    }

}
