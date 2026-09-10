import java.util.HashSet;

public class Compte {
  private float solde;
  private boolean active;
  private HashSet<Transaction> transactionHistory;
  private String ClientId;
  private String AccountId;

  public String getAccountId() {
    return AccountId;
  }

  public void setAccountId(String accountId) {
    AccountId = accountId;
  }

  public String getClientId() {
    return ClientId;
  }

  public void setClientId(String clientId) {
    ClientId = clientId;
  }

  public Compte(String clientId, String accountId) {
    this.solde = 0;
    this.active = true;
    this.ClientId = clientId;
    this.AccountId = accountId;
    this.transactionHistory = new HashSet<>();
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

  //////////////////////////// actual operations
  public void deposit() {
    System.out.println("Entrer Montant:");
    float amount = Main.scanner.nextFloat();
    Main.scanner.nextLine();
    this.solde += amount;
    System.out.println("Montant deposer avec succes!");
  }
}
