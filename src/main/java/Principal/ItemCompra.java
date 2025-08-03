package Principal;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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
                                break;
                            }
                        }
                        if (!produtoEncontrado) {
                            System.out.println("Produto não encontrado! Informe o nome do produto novamente (\"0\" para sair)");
                            nomeProduto = scanner.nextLine();
                            if (nomeProduto.equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho(); return;}
                        }
                    }
                    clienteEncontrado = true;
                    break;
                }
            }
            if (!clienteEncontrado) {
                System.out.println("Cliente não encontrado! Informe o nome novamente (\"0\" para sair)");
                donoCarrinho = scanner.nextLine();
                if (donoCarrinho.equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho(); return;}
            }
        }
        System.out.println("Produto adicionado com sucesso!\n");
        Ecommerce.app.subMenuCarrinho(); return;
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
                                    break;
                                } else {
                                    System.out.println("Produto não encontrado no carrinho! Informe outro produto (\"0\" para sair)");
                                    nomeProduto = scanner.nextLine();
                                    if (nomeProduto.equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho(); return;}
                                }
                            }
                        } if (!produtoEncontrado) {
                            System.out.println("Produto não encontrado! Informe o nome do produto novamente (\"0\" para sair)");
                            nomeProduto = scanner.nextLine();
                            if (nomeProduto.equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho(); return;}
                        }
                        if (produtoEncontrado) {
                            break;
                        }
                    }
                    clienteEncontrado = true;
                    break;
                }
            }
            if (!produtoEncontrado) {
                System.out.println("Cliente não encontrado! Informe o nome novamente (\"0\" para sair)");
                donoCarrinho = scanner.nextLine();
                if (donoCarrinho.equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho(); return;}
            }
            if (clienteEncontrado) {
                break;
            }
        }
        System.out.println("Produto removido com sucesso!\n");
        Ecommerce.app.subMenuCarrinho(); return;
    }

    public static void comprarItensDoCarrinho(List<ItemCompra> tabelaCarrinho, List<Compra> tabelaCompras) {
        System.out.println("Informe o nome do dono do carrinho: ");
        String donoCarrinho = scanner.nextLine();
        boolean clienteEncontrado = false;
        ItemCompra carrinho = null;
        Compra compra = null;
        while (!clienteEncontrado){
            for (ItemCompra i : tabelaCarrinho) {
                // Entra se o nome digitado existir em algum cliente
                if (donoCarrinho.equalsIgnoreCase(i.cliente.getNome())) {
                    clienteEncontrado = true;
                    for (Compra c : tabelaCompras) {
                        if (donoCarrinho.equalsIgnoreCase(c.getCliente().getNome())) {
                            compra = c;
                        }
                    }
                    carrinho = i;
                    break;
                }
            } if (!clienteEncontrado) {
                System.out.println("Cliente não encontrado! Informe o nome novamente (\"0\" para sair)");
                donoCarrinho = scanner.nextLine();
                if (donoCarrinho.equalsIgnoreCase("0")) {Ecommerce.app.subMenuCarrinho(); return;}
            }
        }
        compra.setItensComprados(carrinho.getItensDoCarrinho());
        compra.getCliente().setCarrinhoAssociado(new ItemCompra(new Cliente(compra.getCliente().getNome())));
        carrinho.getItensDoCarrinho().clear();
        tabelaCompras.add(compra);
        System.out.println("Compra adicionada com sucesso!\n");
        Ecommerce.app.subMenuCarrinho(); return;
    }

    public static void verCarrinho(List<ItemCompra> tabelaCarrinho) {
        String donoCarrinho;
        System.out.println("Informe o dono do carrinho: ");
        donoCarrinho = scanner.nextLine();
        boolean clienteEncontrado = false;
        while (!clienteEncontrado) {
            for (ItemCompra c : tabelaCarrinho) {
                if (donoCarrinho.equalsIgnoreCase(c.cliente.getNome())) {
                    if (c.getItensDoCarrinho().isEmpty()) {
                        System.out.println("Carrinho vazio\n");
                        Ecommerce.app.subMenuCarrinho(); return;
                    }
                    System.out.println(c.getItensDoCarrinho());
                    clienteEncontrado = true;
                    Ecommerce.app.subMenuCarrinho(); return;
                } else {
                    System.out.println("Cliente não encontrado! Digite o nome novamente (\"0\" para sair): ");
                    donoCarrinho = scanner.nextLine();
                    if (donoCarrinho.equalsIgnoreCase("0")) {
                        Ecommerce.app.subMenuCarrinho();
                        return;
                    }
                }
            }
        }
        Ecommerce.app.subMenuCarrinho(); return;
    }
}
