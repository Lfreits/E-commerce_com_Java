package Util;

import Principal.Cliente;
import Principal.Compra;
import Principal.ItemCompra;
import Principal.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Aplicacao {

    List<Cliente> tabelaClientes = new ArrayList<>();
    List<Produto> tabelaProdutos = new ArrayList<>();
    List<Compra> tabelaCompras = new ArrayList<>();
    List<ItemCompra> tabelaCarrinho = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    ExibirMenus menu = new ExibirMenus();

    public void menuPrincipal() {
        menu.menuPrincipal();
        switch (scanner.nextInt()) {
            case 1: subMenuCliente(); break;
            case 2: subMenuProdutos(); break;
            case 3: Compra.mostrarHistoricoDeCompras(tabelaCompras); break;
            case 4: subMenuCarrinho(); break;
            case 0: exit(); break;
        }
    }

    public void subMenuCliente() {
        menu.subMenuCliente();
        switch (scanner.nextInt()) {
            case 1: Cliente.visualizarClientes(tabelaClientes); break;
            case 2: Cliente.cadastrarCliente(tabelaClientes); break;
            case 3: Cliente.removerCliente(tabelaClientes); break;
            case 0: menuPrincipal(); break;
        }
    }

    public void subMenuProdutos() {
        menu.subMenuProdutos();
        switch (scanner.nextInt()) {
            case 1: Produto.visualizarProdutos(tabelaProdutos); break;
            case 2: Produto.cadastrarProduto(tabelaProdutos); break;
            case 3: Produto.removerProduto(tabelaProdutos); break;
            case 4: Produto.editarProduto(tabelaProdutos); break;
            case 0: menuPrincipal(); break;
        }
    }

    public void subMenuCarrinho() {
        menu.subMenuCarrinho();
        switch (scanner.nextInt()) {
            case 1: ItemCompra.adicionarItemNoCarrinho(tabelaCarrinho, tabelaProdutos); break;
            case 2: ItemCompra.removerItemNoCarrinho(tabelaCarrinho, tabelaProdutos); break;
            case 3: subMenuCarrinho();
            case 4: ItemCompra.comprarItensDoCarrinho(tabelaCarrinho, tabelaCompras);
            case 0: menuPrincipal(); break;
        }
    }
}
