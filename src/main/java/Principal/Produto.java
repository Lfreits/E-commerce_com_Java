package Principal;

import java.util.InputMismatchException;
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

    @Override
    public String toString() {
        return "Produto{" +
                "nomeDoProduto='" + nomeDoProduto + '\'' +
                ", preco=" + preco +
                '}';
    }

    public static void cadastrarProduto(List<Produto> tabelaProdutos) {
        String nome = null;
        Integer preco = null;
        boolean entradaValida = false;
        System.out.println("Informe o nome do produto: ");
        nome = scanner.nextLine();
        System.out.println("Informe o preço do produto: ");
        // Fica perguntando até digitar uma entrada válida
        while (!entradaValida) {
            try {
                preco = scanner.nextInt();
                scanner.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para o preço.");
                scanner.nextLine();
            }
        }
        Produto p = new Produto(preco, nome);
        tabelaProdutos.add(p);
        System.out.println("Produto adicionado com sucesso!");
        Ecommerce.app.subMenuProdutos(); return;
    }
    public static void removerProduto(List<Produto> tabelaProdutos) {
        String nome = null;
        System.out.println("Informe o nome do produto a ser removido: ");
        nome = scanner.nextLine();
        boolean encontrado = false;
        // Fica perguntando até o nome existir
        while (!encontrado) {
            for (Produto p : tabelaProdutos) {
                if (nome.equalsIgnoreCase(p.nomeDoProduto)) {
                    tabelaProdutos.remove(p);
                    System.out.println("Produto removido com sucesso!");
                    encontrado = true;
                    Ecommerce.app.subMenuProdutos(); return;
                }
            }
            if (!encontrado) {
                System.out.println("Produto não encontrado! Informe o nome do produto novamente (\"0\" para sair): ");
                nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("0")) {
                    Ecommerce.app.subMenuProdutos(); return;
                }
            } else {
                break;
            }
        }
        Ecommerce.app.subMenuProdutos(); return;
    }

        public static void editarProduto(List<Produto> tabelaProdutos) {
            String nome = null;
            System.out.println("Informe o nome do produto a ser editado: ");
            nome = scanner.nextLine();
            Produto produtoPraEditar = null;
            boolean encontrado = false;
            boolean opcaoValida = false;
            // Fica perguntando até o nome existir
            while (!encontrado){
                for (Produto p : tabelaProdutos) {
                    //Entra se o produto existir
                    if (nome.equalsIgnoreCase(p.nomeDoProduto)) {
                        produtoPraEditar = p;
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Produto não encontrado! Informe o nome do produto novamente (\"0\" para sair):");
                    nome = scanner.nextLine();
                    if (nome.equalsIgnoreCase("0")) {
                        Ecommerce.app.subMenuProdutos(); return;
                    }
                }
            }
            System.out.println("Produto encontrado! O que deseja editar? (\"Nome\" ou \"preço\") (\"0\" para sair)");
            String resposta = scanner.nextLine();
            // Fica perguntando até uma opção válida
            while (!opcaoValida) {
                if (resposta.equalsIgnoreCase("nome")) {
                    System.out.println("Informe o novo nome do produto:");
                    produtoPraEditar.setNomeDoProduto(scanner.nextLine());
                    opcaoValida = true;
                    break;
                } else if (resposta.equalsIgnoreCase("preço")) {
                    System.out.println("Informe o novo preço do produto:");
                    try {
                        produtoPraEditar.setPreco(scanner.nextInt());
                        scanner.nextLine();
                        opcaoValida = true;
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("Entrada inválida! Digite novamente");
                        scanner.nextLine();
                    }
                } else {
                    System.out.println("Opção inválida. Digite novamente");
                    resposta = scanner.nextLine();
                }
            }
            System.out.println("Produto editado com sucesso!");
            Ecommerce.app.subMenuProdutos(); return;
        }

    public static void visualizarProdutos(List<Produto> tabelaProdutos) {
        System.out.println("Produtos cadastrados no sistema:\n");
        if (tabelaProdutos.isEmpty()) {
            System.out.println("Não existem produtos cadastrados no sistema\n");
            Ecommerce.app.subMenuProdutos(); return;
        } else {
            for (Produto p : tabelaProdutos) {
                System.out.println(p);
            }
            System.out.println("\n");
            Ecommerce.app.subMenuProdutos(); return;
        }
    }
}
