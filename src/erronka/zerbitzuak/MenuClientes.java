package erronka.zerbitzuak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import erronka.aplikazioa.GameStopApp;
import erronka.ereduak.Factura;

public class MenuClientes {
	private void limpiarPantalla() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}
	
    public void mostrar() {
   	 limpiarPantalla();
        System.out.println("\n--- CLIENTES ---");
        System.out.println("1.  Kontaktuak kontsultatu");
        System.out.println("2. Faktura sortu");
        System.out.println("3. Atzera joan");
        System.out.print("Aukeratu: ");
        int op = Integer.parseInt(GameStopApp.sc.nextLine());

        if (op == 1) {
            System.out.print("Sartu ID enplegatua: ");
            String id = GameStopApp.sc.nextLine();
            consultarClientes(id);
        } else if (op == 2) {
            Factura.generarFactura();
        } else if (op == 3) {
            return; // 👉 vuelve directamente al menú principal
        }
    }

    private void consultarClientes(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("LANGILE.txt"))) {
            String linea;
            br.readLine(); // saltar cabecera
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(id + "\t")) {
                    String[] zatiak = linea.split("\t");
                    System.out.println("\nID: " + zatiak[0]);
                    System.out.println("Izena: " + zatiak[1] + " " + zatiak[2]);
                    System.out.println("Helbidea: " + zatiak[3]);
                    System.out.println("Email: " + zatiak[4]);
                    System.out.println();
                    return;
                }
            }
            System.out.println("\nBezeroen IDrekin " + id + " ez da aurkitu.\n");
        } catch (IOException e) {
            System.out.println("Errorea fitxategia irakurtzean.");
        }
    }
}
