public abstract class Person {
  protected String nom;
  protected String prenom;
  protected String email;
  protected String password;

  public static void Login() {
    System.out.println("Email:");
    String email = Main.scanner.nextLine();
    System.out.println("Password:");
    String password = Main.scanner.nextLine();
    for (Client c : Main.clients) {
      if (email.equals(c.email) && password.equals(c.password)) {
        System.out.println("Bonjour");
        return;
      }
    }
    System.out.println("Email ou mot de passe incorrect");
    return;
  }

  public static void Logout() {

  }

}
