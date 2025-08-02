package Principal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Principal.Ecommerce.scanner;

// Carrinho de compras
public class ItemCompra {

    private List<Produto> itensDoCarrinho = new LinkedList<Produto>();
    private Cliente cliente;

    // Lista de produtos no Carrinho
    public ItemCompra(Cliente cliente, List<Produto> itensDoCarrinho) {
        this.itensDoCarrinho = itensDoCarrinho;
        this.cliente = cliente;
    }
    public ItemCompra(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getItensDoCarrinho() {
        return itensDoCarrinho;
    }

    public void setItensDoCarrinho(List<Produto> itensDoCarrinho) {
        this.itensDoCarrinho = itensDoCarrinho;
    }

    @Override
    public String toString() {
        return "ItemCompra{" +
                "itensDoCarrinho=" + itensDoCarrinho +
                ", cliente=" + cliente +
                '}';
    }

    public static void adicionarItemNoCarrinho(List<ItemCompra> tabelaCarrinho, List<Produto> tabelaProdutos) {
        String donoCarrinho;
        boolean clienteEncontrado = false;
        boolean produtoEncontrado = false;
        System.out.println("Informe o nome do dono do carrinho: ");
        donoCarrinho = scanner.nextLine();
        while (!clienteEncontrado){
            for (ItemCompra i : tabelaCarrinho) {
                // Entra se o nome digitado existir em algum cliente
                if (donoCarrinho.equalsIgnoreCase(i.cliente.getNome())) {
                    System.out.println("Informe o nome do produto:");
                    String nomeProduto = scanner.nextLine();
                    while (!produtoEncontrado) {
                        for (Produto p : tabelaProdutos) {
                            // Entra se o produto digitado existir
                            if (p.getNomeDoProduto().equalsIgnoreCase(nomeProduto)) {
                                i.itensDoCarrinho.add(p);
                                produtoEncontrado = true;
                            } else {
                                System.out.println("Produto não encontrado! Informe o nome do produto novamente (\"0\" para sair)");
                                if (scanner.nextLine().equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho();}
                            }
                        }
                    }
                    clienteEncontrado = true;
                } else {
                    System.out.println("Cliente não encontrado! Informe o nome novamente (\"0\" para sair)");
                    if (scanner.nextLine().equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho();}
                }
            }
        }
        System.out.println("Produto adicionado com sucesso!\n");
        Ecommerce.app.subMenuCarrinho();
    }

    public static void removerItemNoCarrinho(List<ItemCompra> tabelaCarrinho, List<Produto> tabelaProdutos) {
        String donoCarrinho;
        boolean clienteEncontrado = false;
        boolean produtoEncontrado = false;
        System.out.println("Informe o nome do dono do carrinho: ");
        donoCarrinho = scanner.nextLine();
        while (!clienteEncontrado){
            for (ItemCompra i : tabelaCarrinho) {
                // Entra se o nome digitado existir em algum cliente
                if (donoCarrinho.equalsIgnoreCase(i.cliente.getNome())) {
                    System.out.println("Informe o nome do produto a ser removido:");
                    String nomeProduto = scanner.nextLine();
                    while (!produtoEncontrado) {
                        for (Produto p : tabelaProdutos) {
                            // Entra se o produto digitado existir
                            if (p.getNomeDoProduto().equalsIgnoreCase(nomeProduto)) {
                                // Entra se o produto digitado estiver no carrinho
                                if (i.getItensDoCarrinho().contains(p)){
                                    i.itensDoCarrinho.remove(p);
                                produtoEncontrado = true;
                                } else {
                                    System.out.println("Produto não encontrado no carrinho! Informe outro produto (\"0\" para sair)");
                                    if (scanner.nextLine().equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho();}
                                }
                            } else {
                                System.out.println("Produto não encontrado! Informe o nome do produto novamente (\"0\" para sair)");
                                if (scanner.nextLine().equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho();}
                            }
                        }
                    }
                    clienteEncontrado = true;
                } else {
                    System.out.println("Cliente não encontrado! Informe o nome novamente (\"0\" para sair)");
                    if (scanner.nextLine().equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho();}
                }
            }
        }
        System.out.println("Produto removido com sucesso!\n");
        Ecommerce.app.subMenuCarrinho();
    }

    public static void comprarItensDoCarrinho(List<ItemCompra> tabelaCarrinho, List<Compra> tabelaCompras) {
        System.out.println("Informe o nome do dono do carrinho: ");
        String donoCarrinho = scanner.nextLine();
        boolean clienteEncontrado = false;
        while (!clienteEncontrado){
            for (ItemCompra i : tabelaCarrinho) {
                // Entra se o nome digitado existir em algum cliente
                if (donoCarrinho.equalsIgnoreCase(i.cliente.getNome())) {
                    Compra compra = new Compra(i);
                    tabelaCompras.add(compra);
                    clienteEncontrado = true;
                    tabelaCarrinho.clear();
                } else {
                    System.out.println("Cliente não encontrado! Informe o nome novamente (\"0\" para sair)");
                    if (scanner.nextLine().equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho();}
                }
            }
        }
        System.out.println("Compra adicionada com sucesso!\n");
        Ecommerce.app.subMenuCarrinho();
    }
}
