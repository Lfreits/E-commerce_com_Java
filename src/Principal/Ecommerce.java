package Principal;

import Util.Aplicacao;
import java.util.Scanner;

public class Ecommerce {

    public static Scanner scanner = new Scanner(System.in);
    public static Aplicacao app = new Aplicacao();

    public static void main(String[] args) {
        // Inicia a aplicação com o menu principal, que chama os outros menus e os métodos necessários
        app.menuPrincipal();
    }


}
