public class Banker extends Person {
  private String idBanker;

  public Banker(String nom, String prenom, String password, String email, int cid) {
    this.idBanker = "B" + cid;
    this.nom = nom;
    this.prenom = prenom;
    this.password = password;
    this.email = email;
  }

  public String getIdBanker() {
    return idBanker;
  }

  public static void addClient(String nom, String prenom, String email, String password, int cid) {
    Client client = new Client(nom, prenom, password, email, cid);
    Main.clients.add(client);
  }

}
