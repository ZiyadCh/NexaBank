import java.util.HashSet;
import java.util.InputMismatchException;

public class Compte {
  private float solde;
  private boolean active;
  private HashSet<Transaction> transactionHistory;
  private String ClientId;
  private String AccountId;

  public Compte(String clientId, String accountId) {
    this.solde = 0;
    this.active = true;
    this.ClientId = clientId;
    this.AccountId = accountId;
    this.transactionHistory = new HashSet<>();
  }

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
    float amount = 0;
    try {
      amount = Main.scanner.nextFloat();
      if (amount < 0) {
        System.err.println("─── ERROR ──────────────────────────");
        System.err.println("le montant ne peut pas etre negatif!!");
        System.err.println("─────────────────────────────────────");
        return;
      }
      this.solde += amount;
      System.out.println("Montant deposer avec succes!");
    } catch (InputMismatchException e) {
      System.err.println("─── ERROR ──────────────────────────");
      System.err.println("enter a number!!!");
      System.err.println("─────────────────────────────────────");
    } finally {
      Main.scanner.nextLine();
    }
  }

  public void withdraw() {
    System.out.println("Entrer Montant:");
    float amount = 0;
    try {
      amount = Main.scanner.nextFloat();
      if (this.solde < amount) {
        System.err.println("─── ERROR ──────────────────────────");
        System.err.println("vous ne posseder pas ce montant!!");
        System.err.println("─────────────────────────────────────");
        return;
      }
      this.solde -= amount;
      System.out.println("Montant deposer avec succes!");
    } catch (InputMismatchException e) {
      System.err.println("─── ERROR ──────────────────────────");
      System.err.println("enter a number!!!");
      System.err.println("─────────────────────────────────────");
    } finally {
      Main.scanner.nextLine();
    }
  }

  public void pay() {
    System.out.println("Entrer nombre du compte:");
    String cid = Main.scanner.nextLine();
    System.out.println("Entrer Montant:");
    float amount = Main.scanner.nextFloat();
    Main.scanner.nextLine();

    if (this.solde < amount) {
      System.err.println("─── ERROR ──────────────────────────");
      System.err.println("vous ne posseder pas ce montant!!");
      System.err.println("─────────────────────────────────────");
      return;
    }

    for (Compte compte : Main.comptes) {
      float s = compte.getSolde();
      if (compte.getAccountId().equals(cid)) {
        compte.setSolde(s += amount);
        this.solde -= amount;
        return;
      }
    }
    System.out.println("compte pas trouve");

  }
}
