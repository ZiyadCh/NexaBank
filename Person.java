public abstract class Person {
  protected String nom;
  protected String prenom;
  protected String email;
  protected String password;

  public static Person Login() {
    System.out.println("Email:");
    String email = Main.scanner.nextLine();
    System.out.println("Password:");
    String password = Main.scanner.nextLine();

    // finding client
    for (Client c : Main.clients) {
      if (email.equals(c.email) && password.equals(c.password)) {
        System.out.println("yes");
        return c;
      }
    }
    // finding gestionaire
    for (Banker b : Main.bankers) {
      if (email.equals(b.email) && password.equals(b.password)) {
        System.out.println("Bonjour");
        return b;
      }
    }
    // if not found
    System.out.println("Email ou mot de passe incorrect");
    return null;
  }

  public static void Logout() {

  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
