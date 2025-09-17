package erronka;

public class menuPrincipal {
    public void mostrar() {
        int opcion;
        do {
            System.out.println("----- MENÚ PRINCIPAL -----");
            System.out.println("1. Langileak (Empleados)");
            System.out.println("2. Bezeroak (Clientes)");
            System.out.println("3. Fitxategiak (Archivos)");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione opción: ");
            opcion = Integer.parseInt(GameStopApp.sc.nextLine());

            switch (opcion) {
                case 1 -> new MenuEmpleados().mostrar();
                case 2 -> new MenuClientes().mostrar();
                case 3 -> Archivos.mostrarArchivos();
                case 4 -> cerrarSesion();
                default -> System.out.println("⚠️ Opción inválida.\n");
            }
        } while (opcion != 4);
    }

    private void cerrarSesion() {
        System.out.print("¿Seguro que desea cerrar sesión? (S/N): ");
        String resp = GameStopApp.sc.nextLine();
        if (resp.equalsIgnoreCase("S")) {
            System.out.println("👋 Sesión cerrada. Hasta pronto.");
            System.exit(0);
        }
    }
}
