package Util;


import java.util.Scanner;

public class ExibirMenus {
    Scanner scanner = new Scanner(System.in);

    public void menuPrincipal() {
        System.out.println("---------- Bem vindo ao E-commerce ----------\n" +
                "Escolha uma opção a seguir:\n" +
                "1 -> Cadastro de clientes\n" +
                "2 -> Cadastro de produtos\n" +
                "3 -> Histórico de compras\n" +
                "4 -> Carrinho de compras\n" + // Perguntar qual cliente e já mostrar o carrinho
                "0 -> Sair da aplicação\n");
    }

    public void subMenuCliente() {
        System.out.println("---------- Menu de clientes ----------\n" +
                "Escolha uma opção a seguir:\n" +
                "1 -> Visualizar clientes cadastrados\n" +
                "2 -> Cadastrar cliente\n" +
                "3 -> Remover cliente\n" +
                "0 -> Voltar ao menu anterior\n");
    }

    public void subMenuProdutos() {
        System.out.println("---------- Menu de produtos ----------\n" +
                "Escolha uma opção a seguir:\n" +
                "1 -> Visualizar produtos cadastrados\n" +
                "2 -> Cadastrar cliente\n" +
                "3 -> Remover cliente\n" +
                "4 -> Editar produto\n" +
                "0 -> Voltar ao menu anterior\n");
    }

    public void subMenuCarrinho() {
        System.out.println("---------- Menu do carrinho ----------\n" +
                "Escolha uma opção a seguir:\n" +
                "1 -> Adicionar item\n" +
                "2 -> Remover item\n" +
                "3 -> Ver outro carrinho\n" +
                "0 -> Voltar ao menu anterior\n");
    }
}
