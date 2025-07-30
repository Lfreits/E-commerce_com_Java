package Principal;

import Util.Aplicacao;

import java.util.ArrayList;
import java.util.List;

import static Principal.Ecommerce.scanner;

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
    public Cliente(ItemCompra carrinhoAssociado, String nome) {
        this.carrinhoAssociado = new ItemCompra(carrinhoAssociado.getItensDoCarrinho());
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

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", carrinhoAssociado=" + carrinhoAssociado +
                '}';
    }

    public static Cliente cadastrarCliente() {
        System.out.println("Informe o nome do cliente:");
        return new Cliente(scanner.nextLine());
    }

    public static void visualizarClientes(List<Cliente> tabelaClientes) {
        for (Cliente c : tabelaClientes) {
            System.out.println(c);
        }
    }
}
