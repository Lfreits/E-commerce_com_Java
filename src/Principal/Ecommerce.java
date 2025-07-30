package Principal;

import Util.Menus;
import java.util.Scanner;

public class Ecommerce {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menus menu = new Menus();
        // Inicia a aplicação com o menu principal, que chama os outros menus e os métodos necessários
        menu.menuPrincipal();
    }


}
