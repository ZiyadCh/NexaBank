package models;

import java.util.HashSet;

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
}
