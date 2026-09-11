package services;

import java.util.HashSet;
import models.Compte;

public class CompteService {
  public static HashSet<Compte> comptes = new HashSet<>();
  public static int aid = 1;

  static {
    comptes.add(new Compte("C1", "1001"));
    comptes.add(new Compte("C1", "1002"));
    comptes.add(new Compte("C2", "1003"));
  }

  public static Compte findById(String accountId) {
    for (Compte c : comptes) {
      if (c.getAccountId().equals(accountId)) {
        return c;
      }
    }
    return null;
  }

  public static HashSet<Compte> findByClientId(String clientId) {
    HashSet<Compte> result = new HashSet<>();
    for (Compte c : comptes) {
      if (c.getClientId().equals(clientId)) {
        result.add(c);
      }
    }
    return result;
  }

  public static boolean create(String clientId) {
    if (ClientService.findById(clientId) == null) {
      return false;
    }
    String accountId = "A" + aid;
    Compte compte = new Compte(clientId, accountId);
    comptes.add(compte);
    aid++;
    return true;
  }

  public static boolean deposit(Compte compte, float amount) {
    if (!compte.isActive()) {
      return false;
    }
    if (amount < 0) {
      return false;
    }
    compte.setSolde(compte.getSolde() + amount);
    TransactionService.create("deposit", compte.getAccountId(), null);
    return true;
  }

  public static boolean withdraw(Compte compte, float amount) {
    if (!compte.isActive()) {
      return false;
    }
    if (compte.getSolde() < amount) {
      return false;
    }
    compte.setSolde(compte.getSolde() - amount);
    TransactionService.create("withdraw", compte.getAccountId(), null);
    return true;
  }

  public static boolean transfer(Compte source, String targetId, float amount) {
    if (!source.isActive()) {
      return false;
    }
    if (source.getSolde() < amount) {
      return false;
    }
    Compte target = findById(targetId);
    if (target == null) {
      return false;
    }
    if (!target.isActive()) {
      return false;
    }
    source.setSolde(source.getSolde() - amount);
    target.setSolde(target.getSolde() + amount);
    TransactionService.create("virement", source.getAccountId(), target.getAccountId());
    return true;
  }

  public static Compte ban(String accountId) {
    Compte compte = findById(accountId);
    if (compte == null) {
      return null;
    }
    compte.setActive(!compte.isActive());
    return compte;
  }

}
