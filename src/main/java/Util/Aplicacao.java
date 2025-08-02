package Util;

import Principal.Cliente;
import Principal.Compra;
import Principal.ItemCompra;
import Principal.Produto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    List<Cliente> tabelaClientes = new ArrayList<Cliente>();
    List<Produto> tabelaProdutos = new ArrayList<Produto>();
    List<Compra> tabelaCompras = new ArrayList<Compra>();
    List<ItemCompra> tabelaCarrinho = new ArrayList<ItemCompra>();


    Scanner scanner = new Scanner(System.in);
    ExibirMenus menu = new ExibirMenus();

    public void menuPrincipal() {
        menu.menuPrincipal();
        try {
            switch (scanner.nextInt()) {
                case 1: subMenuCliente(); break;
                case 2: subMenuProdutos(); break;
                case 3: Compra.mostrarHistoricoDeCompras(tabelaCompras); break;
                case 4: subMenuCarrinho(); break;
                case 0: System.exit(0);; break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.\n");
            scanner.nextLine();
            menuPrincipal();
        }
    }

    public void subMenuCliente() {
        menu.subMenuCliente();
        try {
            switch (scanner.nextInt()) {
                case 1: Cliente.visualizarClientes(tabelaClientes); break;
                case 2: Cliente.cadastrarCliente(tabelaClientes, tabelaCarrinho, tabelaCompras); break;
                case 3: Cliente.removerCliente(tabelaClientes, tabelaCarrinho, tabelaCompras); break;
                case 0: menuPrincipal(); break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.\n");
            scanner.nextLine();
            subMenuCliente();
        }
    }

    public void subMenuProdutos() {
        menu.subMenuProdutos();
        try {
            switch (scanner.nextInt()) {
                case 1: Produto.visualizarProdutos(tabelaProdutos); break;
                case 2: Produto.cadastrarProduto(tabelaProdutos); break;
                case 3: Produto.removerProduto(tabelaProdutos); break;
                case 4: Produto.editarProduto(tabelaProdutos); break;
                case 0: menuPrincipal(); break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.\n");
            scanner.nextLine();
            subMenuProdutos();
        }
    }

    public void subMenuCarrinho() {
        menu.subMenuCarrinho();
        try {
            switch (scanner.nextInt()) {
                case 1: ItemCompra.adicionarItemNoCarrinho(tabelaCarrinho, tabelaProdutos); break;
                case 2: ItemCompra.removerItemNoCarrinho(tabelaCarrinho, tabelaProdutos); break;
                case 3: ItemCompra.verCarrinho(tabelaCarrinho); break;
                case 4: ItemCompra.comprarItensDoCarrinho(tabelaCarrinho, tabelaCompras);
                case 0: menuPrincipal(); break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.\n");
            scanner.nextLine();
            subMenuCarrinho();
        }
    }
}
