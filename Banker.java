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

  public void addClient() {
    System.out.println("Nom:");
    String nom = Main.scanner.nextLine();
    System.out.println("Prenom:");
    String prenom = Main.scanner.nextLine();
    System.out.println("Email:");
    String email = Main.scanner.nextLine();
    System.out.println("Mod de passe:");
    String password = Main.scanner.nextLine();
    Client client = new Client(nom, prenom, password, email, Main.cid);
    Main.clients.add(client);
    Main.cid++;
  }

  public void listClients() {
    for (Client c : Main.clients) {
      System.out.println("id: " + c.getIdClient());
      System.out.println("nom: " + c.getNom());
      System.out.println("prenom: " + c.getPrenom());
      System.out.println("email: " + c.getEmail());
      System.out.println("solde: " + c.getSolde());
    }
  }

}
