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
    String accountId = "A" + aid;
    Compte compte = new Compte(clientId, accountId);
    comptes.add(compte);
    aid++;
    return true;
  }

  public static boolean deposit(Compte compte, float amount) {
    if (amount < 0) {
      return false;
    }
    compte.setSolde(compte.getSolde() + amount);
    return true;
  }

  public static boolean withdraw(Compte compte, float amount) {
    if (compte.getSolde() < amount) {
      return false;
    }
    compte.setSolde(compte.getSolde() - amount);
    return true;
  }

  public static boolean transfer(Compte source, String targetId, float amount) {
    if (source.getSolde() < amount) {
      return false;
    }
    Compte target = findById(targetId);
    if (target == null) {
      return false;
    }
    source.setSolde(source.getSolde() - amount);
    target.setSolde(target.getSolde() + amount);
    return true;
  }

  public void ban(Compte compte) {
    compte.setActive(false);
    return;
  }

}
