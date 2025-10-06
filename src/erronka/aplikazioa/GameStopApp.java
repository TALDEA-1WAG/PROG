package erronka.aplikazioa;

import java.util.Scanner;

import erronka.ereduak.Estrella;
import erronka.zerbitzuak.Login;

public class GameStopApp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Login login = new Login();
        login.iniciarSesion();

        Estrella.mostrarEstrella();

        menuPrincipal menu = new menuPrincipal();
        menu.mostrar();
    }
}
