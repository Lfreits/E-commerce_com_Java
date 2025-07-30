package Principal;

import java.util.List;

// Cliente e carrinho associado
public class Cliente {

    private String nome;
    private ItemCompra carrinhoAssociado;

    // Criar cliente com carrinho vazio
    public Cliente(String nome) {
        this.carrinhoAssociado = new ItemCompra();
        setNome(nome);
    }

    // Criar cliente com carrinho cheio
    public Cliente(List<Produto> carrinhoAssociado, String nome) {
        this.carrinhoAssociado = new ItemCompra(carrinhoAssociado);
        setNome(nome);
    }
    public Cliente(String nome, List<Produto> carrinhoAssociado) {
        this.carrinhoAssociado = new ItemCompra(carrinhoAssociado);
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ItemCompra getCarrinhoAssociado() {
        return carrinhoAssociado;
    }

    public void setCarrinhoAssociado(ItemCompra carrinhoAssociado) {
        this.carrinhoAssociado = carrinhoAssociado;
    }
}
