package erronka;

import java.io.*;
import java.util.*;

public class MenuEmpleados {
    public void mostrar() {
        System.out.println("\n--- LANGILEAK  ---");
        System.out.println("1. Enplegatuaren datuak kontsultatu");
        System.out.println("2. Nagusi baten enplegatuak zerrendatzea");
        System.out.print("Hautatu: ");
        int op = Integer.parseInt(GameStopApp.sc.nextLine());

        if (op == 1) {
            System.out.print("Sartu ID enplegatua: ");
            String id = GameStopApp.sc.nextLine();
            consultarEmpleado(id);
        } else if (op == 2) {
            System.out.print("Sartu ID nagusia: ");
            String jefe = GameStopApp.sc.nextLine();
            System.out.println("Funtzioa ez dago eskuragarri: fitxategiak ez du nagusi-enplegatu harremanik.");
        }
    }

    private void consultarEmpleado(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("LANGILE.txt"))) {
            String linea;
            br.readLine(); // saltar cabecera
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(id + "\t")) {
                    String[] partes = linea.split("\t");
                    System.out.println("\nID: " + partes[0]);
                    System.out.println("Izena: " + partes[1] + " " + partes[2]);
                    System.out.println("Helbidea: " + partes[3]);
                    System.out.println("Email: " + partes[4]);
                    System.out.println();
                    return;
                }
            }
            System.out.println("\nEnplegatua IDrekin" + id + "ez da aurkitu.\n");
        } catch (IOException e) {
            System.out.println("Errorea fitxategia irakurtzean.");
        }
    }
}