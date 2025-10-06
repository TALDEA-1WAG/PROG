package erronka;

public class Login {
    private static final String USER = "Borja";
    private static final String PASS = "1234";
    
    private static final String USER1 = "Erlantz";
    private static final String PASS1 = "1234";
      
    private static final String USER2 = "Hugo";
    private static final String PASS2 = "1234";
    
    private boolean autenticado = false;

    public void iniciarSesion() {
        do {
            System.out.print("Erabiltzailea: ");
            String u = GameStopApp.sc.nextLine().trim();

            System.out.print("Pasahitza: ");
            String p = GameStopApp.sc.nextLine().trim();

            if ((u.equals(USER) && p.equals(PASS)) ||
                (u.equals(USER1) && p.equals(PASS1)) ||
                (u.equals(USER2) && p.equals(PASS2))) {
                autenticado = true;
                System.out.println("✅ Ongi etorri, " + u + "!\n");
            } else {
                System.out.println("❌ Erabiltzaile edo pasahitz okerra. Saiatu berriro.\n");
            }
        } while (!autenticado);
    }
}
