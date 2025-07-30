package Principal;

import java.util.ArrayList;
import java.util.List;

// Carrinho de compras
public class ItemCompra {

    private List<Produto> itensDoCarrinho = new ArrayList<>();

    // Lista de produtos no Carrinho
    public ItemCompra(List<Produto> itensDoCarrinho) {
        this.itensDoCarrinho = itensDoCarrinho;
    }
    public ItemCompra() {
    }

    public List<Produto> getItensDoCarrinho() {
        return itensDoCarrinho;
    }

    public void setItensDoCarrinho(List<Produto> itensDoCarrinho) {
        this.itensDoCarrinho = itensDoCarrinho;
    }
}
