import java.util.HashSet;

public class Compte {
  private float solde;
  private boolean active;
  private HashSet<Transaction> transactionHistory;

  public Compte() {
    this.solde = 0;
    this.active = true;
  }

  public float getSolde() {
    return solde;
  }

  public void setSolde(float solde) {
    this.solde = solde;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public HashSet<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

}
