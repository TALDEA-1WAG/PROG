package erronka.baliabideak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import erronka.aplikazioa.GameStopApp;

public class Archivos {
	private void limpiarPantalla() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}
	
	public void mostrar2() {
	   	 limpiarPantalla();
	        System.out.println("\n--- FITXATEGIAK ---");
	        System.out.println("1. Saltutako unitateak ikusi");
	        System.out.println("2. Stocka kontsultatu");
	        System.out.println("3. Atzera joan");
	        System.out.print("Seleccione: ");
	        int op = Integer.parseInt(GameStopApp.sc.nextLine());

	        if (op == 1) {
	        	mostrar();
	        } else if (op == 2) {
	        	System.out.print("Sartu produktuaren IDa: ");
	            int idProduktu = Integer.parseInt(GameStopApp.sc.nextLine());
	            int vendidos = contarVendidos(idProduktu);
	            mostrarStock(vendidos);
	        } else if (op == 3) {
	            return; // 👉 vuelve directamente al menú principal
	        }
	    }

    public void mostrar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Sartu produktuaren IDa: ");
        int idProduktu = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        int vendidos = contarVendidos(idProduktu);

        if (vendidos > 0) {
            System.out.println("Produktuaren IDa: " + idProduktu);
            System.out.println("Saltutako unitateak: " + vendidos);
        } else {
            System.out.println("Ez da aurkitu ID hori duen salmentarik.");
        }

        
        System.out.println();

    }

    
    private int contarVendidos(int idProduktu) {
        int total = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("ESKARI_LERRO.txt"))) {
            br.readLine(); // saltar cabecera
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\t");
                if (datos.length < 4) continue;

                try {
                    int id = Integer.parseInt(datos[2]);
                    int cantidad = Integer.parseInt(datos[3]);
                    if (id == idProduktu) {
                        total += cantidad;
                    }
                } catch (NumberFormatException ignored) {}
            }
        } catch (IOException e) {
            System.out.println("Errorea: ezin izan da 'ESKARI_LERRO.txt' fitxategia irakurri.");
        }
        return total;
    }
    
    

    private void mostrarStock(int vendidos) {
        Random random = new Random();

        int stockInicial = 500 + random.nextInt(1501); 
        int stockRestante = Math.max(0, stockInicial - vendidos);

        System.out.println("Stock hasiera: " + stockInicial);
        System.out.println("Stock geratzen da: " + stockRestante + " unitate");
    
        System.out.println();
    } 
}
