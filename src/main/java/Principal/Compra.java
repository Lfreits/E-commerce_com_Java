package Principal;

import java.util.List;
import static Principal.Ecommerce.scanner;

// Compra finalizada
public class Compra {
    private ItemCompra itensComprados;
    private Cliente cliente;

    // Registra compra finalizada
    public Compra(ItemCompra itensComprados) {
        setItensComprados(itensComprados);
        setCliente(cliente);
    }

    public ItemCompra getItensComprados() {
        return itensComprados;
    }

    public void setItensComprados(ItemCompra itensComprados) {
        this.itensComprados = itensComprados;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "itensComprados=" + itensComprados +
                ", cliente=" + cliente +
                '}';
    }

    public static void mostrarHistoricoDeCompras(List<Compra> tabelaCompras) {
        System.out.println("Histórico de compras de qual cliente? ");
        String nomeCliente = scanner.nextLine();
        boolean encontrado = false;
        // Fica perguntando até encontrar o cliente
        while (!encontrado) {
            for (Compra c : tabelaCompras) {
                if (c.cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                    System.out.println(c.itensComprados);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Cliente não encontrado, digite o nome novamente (\"0\" para sair):");
                nomeCliente = scanner.nextLine();
                if (nomeCliente.equalsIgnoreCase("0")) {
                    Ecommerce.app.menuPrincipal();
                }
            }
        }
        System.out.println("\n");
        Ecommerce.app.menuPrincipal();
    }
}
