package erronka;

public class Login {
    private static final String USER = "Borja";
    private static final String PASS = "1234";
    private boolean autenticado = false;

    public void iniciarSesion() {
        do {
            System.out.print("Erabiltzailea: ");
            String u = GameStopApp.sc.nextLine();

            System.out.print("Pasahitza: ");
            String p = GameStopApp.sc.nextLine();

            if (u.trim().equals(USER) && p.trim().equals(PASS)) {
                autenticado = true;
                System.out.println("✅ Ongi etorri, " + USER + "!\n");
            } else {
                System.out.println("❌ Erabiltzaile edo pasahitz okerra. Saiatu berriro.\n");
            }
        } while (!autenticado);
    }
}
