package Util;

import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Menus {
    Scanner scanner = new Scanner(System.in);
    ExibirMenus menu = new ExibirMenus();

    public void menuPrincipal() {
        menu.menuPrincipal();
        switch (scanner.nextInt()) {
            case 1: menu.subMenuCliente();
            case 2: menu.subMenuProdutos();
            case 3: ; // Perguntar qual cliente e já mostrar o carrinho
            case 4: menu.subMenuCarrinho();
            case 0: exit();
        }
    }

    public void subMenuCliente() {
        switch (scanner.nextInt()) {
            case 1: // Visualizar clientes cadastrados
            case 2: // Cadastrar cliente
            case 3: // Remover cliente
            case 0: menu.menuPrincipal();
        }
    }

    public void subMenuProdutos() {
        switch (scanner.nextInt()) {
            case 1: // Visualizar produtos cadastrados
            case 2: // Cadastrar produto
            case 3: // Remover produto
            case 4: // Editar produto
            case 0: menu.menuPrincipal();
        }
    }

    public void subMenuCarrinho() {
        switch (scanner.nextInt()) {
            case 1: // Adicionar item
            case 2: // Remover item
            case 3: // Ver outro carrinho
            case 0: menu.menuPrincipal();
        }
    }
}
