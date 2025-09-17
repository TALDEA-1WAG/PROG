package erronka;


public class Login {
    private static final String USER = "Borja";
    private static final String PASS = "1234";
    private boolean autenticado = false;

    public void iniciarSesion() {
        while (!autenticado) {
            System.out.print("Usuario: ");
            String u = GameStopApp.sc.nextLine();
            System.out.print("Contraseña: ");
            String p = GameStopApp.sc.nextLine();

            if (u.trim().equals(USER) && p.trim().equals(PASS)) {
                autenticado = true;
                System.out.println("✅ Bienvenido " + USER + "\n");
            } else {
                System.out.println("❌ Credenciales incorrectas. Intente de nuevo.\n");
            }
        }
    }
}
