package erronka;

public class menuPrincipal {
	
    public void mostrar() {
        int opcion;
        do {
        	System.out.println();
            System.out.println("----- MENU NAGUSIA -----");
            System.out.println("1. Langileak");
            System.out.println("2. Bezeroak");
            System.out.println("3. Fitxategiak");
            System.out.println("4. Saioa itxi");
            System.out.print("Aukeratu aukera: ");
            opcion = Integer.parseInt(GameStopApp.sc.nextLine());

            switch (opcion) {
                case 1 -> new MenuEmpleados().mostrar();
                case 2 -> new MenuClientes().mostrar();
                case 3 -> new Archivos().mostrar2();
                case 4 -> cerrarSesion();
                default -> System.out.println("⚠️ Aukera baliogabea.\n");
            }
        } while (opcion != 4);
    }

    private void cerrarSesion() {
        System.out.print("Ziur zaude saioa itxi nahi duzula? (B/Ez): ");
        String resp = GameStopApp.sc.nextLine();
        if (resp.equalsIgnoreCase("B")) {
            System.out.println("👋 Saioa itxita. Laster arte.");
            System.exit(0);
        }
    }
}
