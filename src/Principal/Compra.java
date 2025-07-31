package Principal;

import Util.Aplicacao;

import java.util.List;
import java.util.Scanner;

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

    public static void mostrarHistoricoDeCompras(List<Compra> tabelaCompras) {
        System.out.println("Histórico de compras de qual cliente? ");
        String nomeCliente = scanner.nextLine();
        boolean encontrado = false;
        do {
            for (Compra c : tabelaCompras) {
                if (c.cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                    encontrado = true;
                } else {
                    System.out.println("Cliente não encontrado, digite o nome novamente (\"0\" para sair):");
                    nomeCliente = scanner.nextLine();
                    if (nomeCliente.equalsIgnoreCase("0")) {
                        Ecommerce.app.menuPrincipal();
                    }
                }
            }
        } while (!encontrado);

    }
}
