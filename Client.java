
public class Client extends Person {
  private String idClient;

  public Client(String nom, String prenom, String password, String email, int cid) {
    this.idClient = "C" + cid;
    this.nom = nom;
    this.prenom = prenom;
    this.password = password;
    this.email = email;
  }

  public String getIdClient() {
    return idClient;
  }

  public void setIdClient(String idClient) {
    this.idClient = idClient;
  }

  public Compte getCompte() {
    System.out.println("Votre comptes:");
    System.out.println("───────────────────────────────");
    for (Compte compte : Main.comptes) {
      if (compte.getClientId().equals(this.idClient)) {
        System.out.println("Compte ID: " + compte.getAccountId());
        System.out.println("Solde: " + compte.getSolde());
        System.out.println("───────────────────────────────");
      }
    }
    System.out.println("Entrer nombre do compte desire");
    String id = Main.scanner.nextLine();

    for (Compte compte : Main.comptes) {
      if (compte.getAccountId().equals(id)) {
        return compte;
      }
    }
    System.out.println("Compte non trouvee!");

    return null;
  }

}
