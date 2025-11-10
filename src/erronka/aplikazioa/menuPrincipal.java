package erronka.aplikazioa;

import erronka.baliabideak.Archivos;
import erronka.zerbitzuak.MenuClientes;
import erronka.zerbitzuak.MenuEmpleados;

public class menuPrincipal {
	
    public void mostrar() {
        while (true) { // bucle infinito hasta salir
            System.out.println();
            System.out.println("----- MENU NAGUSIA -----");
            System.out.println("1. Langileak");
            System.out.println("2. Bezeroak");
            System.out.println("3. Fitxategiak");
            System.out.println("4. Saioa itxi");
            System.out.print("Aukeratu: ");

            int opcion;
            try {
                opcion = Integer.parseInt(GameStopApp.sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Aukera baliogabea. Zenbaki bat idatzi.");
                continue;
            }

            switch (opcion) {
                case 1 -> new MenuEmpleados().mostrar();
                case 2 -> new MenuClientes().mostrar();
                case 3 -> new Archivos().mostrar2();
                case 4 -> cerrarSesion(); // aquí se cierra o se vuelve
                default -> System.out.println("Aukera baliogabea.\n");
            }
        }
    }
    
    
    private void cerrarSesion() {
        System.out.print("Ziur zaude saioa itxi nahi duzula? (B/Ez): ");
        String resp = GameStopApp.sc.nextLine();

        if (resp.equalsIgnoreCase("B")) {
            System.out.println("Saioa itxita. Laster arte.");
            System.exit(0); // sale del programa
        } else if (resp.equalsIgnoreCase("Ez")) {
            System.out.println("Saioarekin jarraitzen da.");
            return; // vuelve al menú
        } else {
            System.out.println("Aukera baliogabea. Idatzi 'B' edo 'Ez'.");
        }
    }
}
