package Principal;

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

    public static void cadastrarCliente(List<Cliente> tabelaClientes) {
        System.out.println("Informe o nome do cliente:");
        Cliente cliente =  new Cliente(scanner.nextLine());
        System.out.println("Cliente cadastrado com sucesso\n");
        tabelaClientes.add(cliente);
        Ecommerce.app.subMenuCliente();
    }

    public static void visualizarClientes(List<Cliente> tabelaClientes) {
        if (tabelaClientes.isEmpty()) {
            System.out.println("Não existem clientes cadastrados!\n");
            Ecommerce.app.subMenuCliente();
        } else {
            for (Cliente c : tabelaClientes) {
                System.out.println(c);
            }
            System.out.println("\n");
            Ecommerce.app.subMenuCliente();
        }
    }
    
    public static void removerCliente(List<Cliente> tabelaClientes) {
        System.out.println("Informe o nome do cliente a ser removido: ");
        String nome = scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : tabelaClientes) {
            if (c.nome.equalsIgnoreCase(nome)) {
                cliente = c;
            } else {
                System.out.println("Cliente não encontrado!\n");
                Ecommerce.app.subMenuCliente();
            }
        }
        tabelaClientes.remove(cliente);
        System.out.println("Cliente removido com sucesso!\n");
        Ecommerce.app.subMenuCliente();
    }
}