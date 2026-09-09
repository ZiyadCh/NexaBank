public class Banker extends Person {
  private String idBanker;

  public Banker(String nom, String prenom, String password, String email, int bid) {
    this.idBanker = "B" + bid;
    this.nom = nom;
    this.prenom = prenom;
    this.password = password;
    this.email = email;
  }

  public String getIdBanker() {
    return idBanker;
  }

  public void addCompte() {
    System.out.println("ID du client:");
    String clientId = Main.scanner.nextLine();
    Client found = null;
    for (Client c : Main.clients) {
      if (c.getIdClient().equals(clientId)) {
        found = c;
        break;
      }
    }
    if (found == null) {
      System.out.println("Client non trouve.");
      return;
    }
    String accountId = "A" + Main.aid;
    Compte compte = new Compte(clientId, accountId);
    Main.comptes.add(compte);
    Main.aid++;
    System.out.println("Compte " + accountId + " cree pour le client " + clientId);
  }

  public void listClients() {
    for (Client c : Main.clients) {
      System.out.println(c.getIdClient() + " | " + c.getNom() + " | " + c.getPrenom() + " | " + c.getEmail());
    }
  }

}
