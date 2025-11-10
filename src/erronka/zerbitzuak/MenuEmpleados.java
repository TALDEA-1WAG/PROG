package erronka.zerbitzuak;

import java.io.*;


import erronka.aplikazioa.GameStopApp;

public class MenuEmpleados {
	
	// "Ezabatu" pantaila, lerro huts asko inprimatuz.
	private void limpiarPantalla() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}
	
	// Langile-menua erakutsi eta aukerak kudeatu.
    public void mostrar() {
    	 limpiarPantalla();
        System.out.println("\n--- LANGILEAK ---");
        System.out.println("1. Langile baten datuak kontsultatu"); 
        System.out.println("2. Nagusi baten langileen zerrenda erakutsi"); 
        System.out.println("3. Atzera joan"); // 👈 nueva opción
        System.out.print("Aukeratu: "); 

        try {
            int op = Integer.parseInt(GameStopApp.sc.nextLine()); 

            if (op == 1) { 
                System.out.print("Sartu langilearen IDa: "); 
                String id = GameStopApp.sc.nextLine(); 
                consultarEmpleado(id); 
            } else if (op == 2) { 
                System.out.print("Sartu nagusiaren IDa: "); 
                String jefeIdStr = GameStopApp.sc.nextLine(); 
                listarEmpleadosDeJefe(jefeIdStr); 
            } else if (op == 3) {
                return; // 👈 vuelve al menú principal
            }
        } catch (NumberFormatException e) { 
            System.out.println("Aukera ez da baliozkoa. Mesedez, idatzi zenbaki bat."); 
        }
    }

    // 'LANGILE.txt' fitxategia irakurri eta zehaztutako IDa duen langilea bilatu.
    private void consultarEmpleado(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("LANGILE.txt"))) { 
            String linea;
            br.readLine(); // Goiburuko lerroa saltatu 
            while ((linea = br.readLine()) != null) { 
            	// Konparatu lerroaren hasiera bilatutako IDa eta tabuladorearekin
                if (linea.startsWith(id + "\t")) { 
                    String[] partes = linea.split("\t"); 
                    System.out.println("\nID: " + partes[0]); 
                    System.out.println("Izen-abizena: " + partes[1] + " " + partes[2]); 
                    System.out.println("Telefonoa: " + partes[4]); 
                    System.out.println("Alta-eguna: " + partes[5]); 
                    System.out.println(); 
                    return; 
                }
            }
            System.out.println("\nEz da aurkitu langilerik ID " + id + " honekin.\n"); 
        } catch (IOException e) { 
            System.out.println("Errorea fitxategia irakurtzean."); 
        }
    }

    // Nagusiaren ID bera duten langile guztiak zerrendatu 'LANGILE.txt' fitxategian.
    private void listarEmpleadosDeJefe(String jefeIdStr) {
        try {
            int idNagusi = Integer.parseInt(jefeIdStr); 
            System.out.println("\n--- LANGILE ZERRENDA ---"); 
            System.out.println("Langileak nagusiaren IDarekin: " + idNagusi);

            boolean encontrado = false; 
            try (BufferedReader br = new BufferedReader(new FileReader("LANGILE.txt"))) {
                String linea;
                br.readLine(); // Goiburuko lerroa saltatu

                while ((linea = br.readLine()) != null) { 
                    String[] partes = linea.split("\t"); 
                    if (partes.length >= 7 && partes[6].equals(jefeIdStr)) {
                        System.out.println("  - " + partes[1] + " " + partes[2] + ", Emaila: " + partes[3]);
                        encontrado = true; 
                    }
                }
            } catch (IOException e) { 
                System.out.println("Errorea LANGILE.txt fitxategia irakurtzean."); 
                return;
            }

            if (!encontrado) { 
                System.out.println("Ez da aurkitu langilerik nagusi horren menpe.");
            }

        } catch (NumberFormatException e) { 
            System.out.println("Nagusi IDa ez da baliozkoa. Mesedez, idatzi zenbaki bat."); 
        }
    }
}
