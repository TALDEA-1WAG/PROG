
package erronka.ereduak;


import java.io.*;
import java.util.*;

public class Factura {
	public static void generarFactura() {
	    Scanner sc = new Scanner(System.in);

	    System.out.print("Sartu eskaera zenbakia (ID_ESKARI): ");
	    String eskaeraId = sc.nextLine();

	    String bezeroId = "";
	    try (BufferedReader br = new BufferedReader(new FileReader("ESKARI.txt"))) {
	        String lerroa;
	        while ((lerroa = br.readLine()) != null) {
	            String[] zatiak = lerroa.split("\t");
	            if (zatiak[0].equals(eskaeraId)) {
	                bezeroId = zatiak[1];
	                break;
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Errorea ESKARI.txt fitxategia irakurtzean: " + e.getMessage());
	    }

	    
	    String bezeroa = "";
	    try (BufferedReader br = new BufferedReader(new FileReader("BEZERO.txt"))) {
	        String lerroa;
	        while ((lerroa = br.readLine()) != null) {
	            String[] zatiak = lerroa.split("\t");
	            if (zatiak[0].equals(bezeroId)) {
	                bezeroa = zatiak[1] + " " + zatiak[2];
	                break;
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Errorea BEZERO.txt fitxategia irakurtzean: " + e.getMessage());
	    }

	    double guztira = 0;
	    String faktura = "FAKTURA\n";
	    faktura += "Eskaera zk.: " + eskaeraId + "\n";
	    faktura += "Bezeroa: " + bezeroa + "\n\n";
	    faktura += "Produktua\tKopurua\tSalneurria\tGuztira\n";

	    try (BufferedReader br = new BufferedReader(new FileReader("ESKARI_LERRO.txt"))) {
	        String lerroa;
	        while ((lerroa = br.readLine()) != null) {
	            String[] zatiak = lerroa.split("\t");
	            if (zatiak[0].equals(eskaeraId)) {
	                String idProduktu = zatiak[2];
	                int kopurua = Integer.parseInt(zatiak[3]);
	                double salneurria = Double.parseDouble(zatiak[4].replace(",", "."));
	                double subtotal = kopurua * salneurria;
	                guztira += subtotal;

	                faktura += idProduktu + "\t" + kopurua + "\t" +
	                           String.format("%.2f", salneurria) + "€\t" +
	                           String.format("%.2f", subtotal) + "€\n";
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Errorea ESKARI_LERRO.txt fitxategia irakurtzean: " + e.getMessage());
	    }

	    faktura += "\nGUZTIRA: " + String.format("%.2f", guztira) + " €\n";

	    try (FileWriter fw = new FileWriter("faktura_" + eskaeraId + ".txt")) {
	        fw.write(faktura);
	    } catch (IOException e) {
	        System.out.println("Errorea faktura gordetzean: " + e.getMessage());
	    }

	    System.out.println("\n--- FAKTURA ---\n");
	    System.out.println(faktura);
	}
}
