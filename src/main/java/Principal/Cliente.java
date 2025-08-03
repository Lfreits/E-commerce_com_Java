package Principal;

import java.util.List;
import static Principal.Ecommerce.scanner;

// Cliente e carrinho associado
public class Cliente {

    private String nome;
    private ItemCompra carrinhoAssociado;

    // Criar cliente com carrinho vazio
    public Cliente(String nome) {
        this.carrinhoAssociado = new ItemCompra(this);
        setNome(nome);
    }

    public Cliente(String nome, ItemCompra carrinhoAssociado) {
        this.nome = nome;
        this.carrinhoAssociado = carrinhoAssociado;
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
                ", carrinhoAssociado=" + carrinhoAssociado.getItensDoCarrinho() +
                '}';
    }

    public static void cadastrarCliente(List<Cliente> tabelaClientes, List<ItemCompra> tabelaCarrinho, List<Compra> tabelaCompras) {
        System.out.println("Informe o nome do cliente:");
        Cliente cliente =  new Cliente(scanner.nextLine());
        ItemCompra carrinho = new ItemCompra(cliente);
        Compra historicoCompra = new Compra(carrinho.getItensDoCarrinho(), cliente);
        System.out.println("Cliente cadastrado com sucesso\n");
        tabelaClientes.add(cliente);
        tabelaCarrinho.add(cliente.carrinhoAssociado);
        tabelaCompras.add(historicoCompra);
        Ecommerce.app.subMenuCliente(); return;
    }

    public static void visualizarClientes(List<Cliente> tabelaClientes) {
        if (tabelaClientes.isEmpty()) {
            System.out.println("Não existem clientes cadastrados!\n");
            Ecommerce.app.subMenuCliente(); return;
        } else {
            for (Cliente c : tabelaClientes) {
                System.out.println(c);
            }
            System.out.println("\n");
            Ecommerce.app.subMenuCliente(); return;
        }
    }
    
    public static void removerCliente(List<Cliente> tabelaClientes, List<ItemCompra> tabelaCarrinho, List<Compra> tabelaCompras) {
        System.out.println("Informe o nome do cliente a ser removido: ");
        String nome = scanner.nextLine();
        boolean encontrado = false;
        Cliente cliente = null;
        ItemCompra carrinho = null;
        Compra compra = null;
        while (!encontrado) {
            for (Cliente c : tabelaClientes) {
                if (c.getNome().equalsIgnoreCase(nome)) {
                    cliente = c;
                    encontrado = true;
                    for (ItemCompra i : tabelaCarrinho) {
                        if (i.getCliente().equals(c)) {
                            carrinho = i;
                        }
                    }
                    for (Compra co : tabelaCompras) {
                        if (co.getCliente().equals(c)) {
                            compra = co;
                        }
                    }
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Cliente não encontrado! Digite o nome novamente (\"0\" pra sair)\n");
                nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("0")) {
                    Ecommerce.app.subMenuCliente(); return;
                }
            } else {
                break;
            }
        }
        tabelaClientes.remove(cliente);
        tabelaCarrinho.remove(carrinho);
        tabelaCompras.remove(compra);
        System.out.println("Cliente removido com sucesso!\n");
        Ecommerce.app.subMenuCliente(); return;
    }
}