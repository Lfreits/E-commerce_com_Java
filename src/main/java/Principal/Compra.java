package Principal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static Principal.Ecommerce.scanner;

// Compra finalizada
public class Compra {
    private List<Produto> itensComprados = new LinkedList<Produto>();
    private Cliente cliente;

    // Registra compra finalizada
    public Compra(ItemCompra itens) {
        setItensComprados(itens);
        setCliente(itens.getCliente());
    }

    public List<Produto> getItensComprados() {
        return itensComprados;
    }

    public void setItensComprados(ItemCompra itensComprados) {
        this.itensComprados = itensComprados.getItensDoCarrinho();
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
                if (c.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {

                    // Teste temporário
                    System.out.println(c);

                    if (c.itensComprados.isEmpty()) {
                        System.out.println("Sem itens comprados por esse cliente");
                        encontrado = true;
                        break;
                    }
                    System.out.println(c.getItensComprados());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Cliente não encontrado, digite o nome novamente (\"0\" para sair):");
                nomeCliente = scanner.nextLine();
                if (nomeCliente.equalsIgnoreCase("0")) {
                    System.out.println("\n");
                    Ecommerce.app.menuPrincipal(); return;
                }
            }
        }
        System.out.println("\n");
        Ecommerce.app.menuPrincipal(); return;
    }
}
