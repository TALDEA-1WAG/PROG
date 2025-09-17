package erronka;




public class MenuClientes {
    public void mostrar() {
        System.out.println("\n--- CLIENTES ---");
        System.out.println("1. Consultar contactos");
        System.out.println("2. Generar factura");
        System.out.print("Seleccione: ");
        int op = Integer.parseInt(GameStopApp.sc.nextLine());

        if (op == 1) {
            System.out.print("Ingrese ID cliente: ");
            String id = GameStopApp.sc.nextLine();
            System.out.println("Contactos del cliente " + id + ": (simulación)\n");
        } else if (op == 2) {
            Factura.generarFactura();
        }
    }
}
