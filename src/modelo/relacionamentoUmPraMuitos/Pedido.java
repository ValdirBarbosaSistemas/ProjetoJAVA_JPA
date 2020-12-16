package modelo.relacionamentoUmPraMuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//RELACIONAMENTO UNIDIRECIONAL
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Não aceita valor nulo
    private Date data;

    // RELACIONAMENTO BIDIRECIONAL
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

    // Construtor padrão

    public Pedido() {
        // Colocando a data atual no pedido
        this(new Date());
    }

    public Pedido(Date data) {
        this.data = data;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

}
