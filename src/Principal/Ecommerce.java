package Principal;

import Util.Aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ecommerce {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



        Aplicacao app = new Aplicacao();
        // Inicia a aplicação com o menu principal, que chama os outros menus e os métodos necessários
        app.menuPrincipal();
    }


}
