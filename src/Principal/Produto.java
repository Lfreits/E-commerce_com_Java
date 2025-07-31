package Principal;

import java.util.List;

import static Principal.Ecommerce.scanner;

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

    public static void cadastrarProduto(List<Produto> tabelaProdutos) {
        String nome = null;
        Integer preco = null;
        System.out.println("Informe o nome do produto: ");
        nome = scanner.nextLine();
        System.out.println("Informe o preço do produto: ");
        preco = scanner.nextInt();
        Produto p = new Produto(preco, nome);
        tabelaProdutos.add(p);
        System.out.println("Produto adicionado com sucesso!");
        Ecommerce.app.subMenuProdutos();
    }
    public static void removerProduto(List<Produto> tabelaProdutos) {
        String nome = null;
        System.out.println("Informe o nome do produto a ser removido: ");
        nome = scanner.nextLine();
        Produto produtoPraRemover;
        for (Produto p : tabelaProdutos) {
            if (nome.equalsIgnoreCase(p.nomeDoProduto)) {
                produtoPraRemover = p;
                tabelaProdutos.remove(p);
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }
        }
        Ecommerce.app.subMenuProdutos();
    }

    public static void editarProduto(List<Produto> tabelaProdutos) {
        String nome = null;
        System.out.println("Informe o nome do produto a ser editado: ");
        nome = scanner.nextLine();
        Produto produtoPraEditar = null;
        for (Produto p : tabelaProdutos) {
            if (nome.equalsIgnoreCase(p.nomeDoProduto)) {
                produtoPraEditar = p;
            } else {
                System.out.println("Produto não encontrado!");
                Ecommerce.app.subMenuProdutos();
            }
        }
        System.out.println("Produto encontrado! O que deseja editar? (\"Nome\" ou \"preço\")");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("nome")) {
            System.out.println("Informe o novo nome do produto:");
            produtoPraEditar.setNomeDoProduto(scanner.nextLine());
        } else if (resposta.equalsIgnoreCase("preço")) {
            System.out.println("Informe o novo preço do produto:");
            produtoPraEditar.setPreco(scanner.nextInt());
        }
        while (!resposta.equalsIgnoreCase("nome") && !resposta.equalsIgnoreCase("preço")) {
            System.out.println("Opção inválida! O que deseja editar? (\"Nome\" ou \"preço\")");
            resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("nome")) {
                System.out.println("Informe o novo nome do produto:");
                produtoPraEditar.setNomeDoProduto(scanner.nextLine());
                System.out.println("Nome do produto alterado com sucesso!");
            } else if (resposta.equalsIgnoreCase("preço")) {
                System.out.println("Informe o novo preço do produto:");
                produtoPraEditar.setPreco(scanner.nextInt());
                System.out.println("Preço do produto alterado com sucesso!");
            }
        }
        Ecommerce.app.subMenuProdutos();
    }

    public static void visualizarProdutos(List<Produto> tabelaProdutos) {
        System.out.println("Produtos cadastrados no sistema:\n");
        for (Produto p : tabelaProdutos) {
            System.out.println(p);
        }
    }

}
