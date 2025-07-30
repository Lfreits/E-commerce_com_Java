package Principal;

// Compra finalizada
public class Compra {
    private ItemCompra itensComprados;
    private Cliente cliente;

    // Registra compra finalizada
    public Compra(ItemCompra itensComprados, Cliente cliente) {
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
}
