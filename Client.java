
public class Client extends Person {
  private String idClient;
  private float solde = 0;

  public Client(String nom, String prenom, String password, String email, int cid) {
    this.idClient = "C" + cid;
    this.nom = nom;
    this.prenom = prenom;
    this.password = password;
    this.email = email;
  }

  public float getSolde() {
    return solde;
  }

  public void setSolde(float solde) {
    this.solde = solde;
  }

  public String getIdClient() {
    return idClient;
  }

  public void setIdClient(String idClient) {
    this.idClient = idClient;
  }

}
