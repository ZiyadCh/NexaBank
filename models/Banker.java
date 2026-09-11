package models;

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

  public void setIdBanker(String idBanker) {
    this.idBanker = idBanker;
  }
}
