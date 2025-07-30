package Util;

import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Menus {
    Scanner scanner = new Scanner(System.in);

    public void menuPrincipal() {
        ExibirMenus menu = new ExibirMenus();
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

    }

    public void subMenuProdutos() {

    }

    public void subMenuCarrinho() {

    }
}
