package erronka;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Factura {
    public static void generarFactura() {
        try {
            FileWriter fw = new FileWriter("factura.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("******** FACTURA ********");
            pw.println("Cliente: Demo");
            pw.println("Producto: Videojuego");
            pw.println("Precio: 49.99 €");
            pw.println("IVA (21%): 10.50 €");
            pw.println("TOTAL: 60.49 €");
            pw.close();

            System.out.println("✅ Factura generada en factura.txt\n");
        } catch (IOException e) {
            System.out.println("❌ Error al generar factura.");
        }
    }
}

