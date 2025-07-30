package Principal;

// Produtos registrados no e-commerce
public class Produto {
    private String nomeDoProduto;
    private Integer preco;

    public Produto(Integer preco, String nomeDoProduto) {
        setPreco(preco);
        setNomeDoProduto(nomeDoProduto);
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }
}
