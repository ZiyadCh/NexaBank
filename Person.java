public abstract class Person {
  protected String nom;
  protected String prenom;
  protected String email;
  protected String password;

  public static String Login() {
    System.out.println("Email:");
    String email = Main.scanner.nextLine();
    System.out.println("Password:");
    String password = Main.scanner.nextLine();
    // finding client
    for (Client c : Main.clients) {
      if (email.equals(c.email) && password.equals(c.password)) {
        System.out.println("Bonjour");
        return "client";
      }
    }
    // finding gestionaire
    for (Banker b : Main.bankers) {
      if (email.equals(b.email) && password.equals(b.password)) {
        System.out.println("Bonjour");
        return "banker";
      }
    }
    return "Email ou mot de passe incorrect";
  }

  public static void Logout() {

  }

}
