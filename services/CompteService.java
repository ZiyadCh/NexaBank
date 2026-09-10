import java.util.HashSet;
import models.Compte;

public class CompteService {

  public static Compte findById(String accountId) {
    for (Compte c : Main.comptes) {
      if (c.getAccountId().equals(accountId)) {
        return c;
      }
    }
    return null;
  }

  public static HashSet<Compte> findByClientId(String clientId) {
    HashSet<Compte> result = new HashSet<>();
    for (Compte c : Main.comptes) {
      if (c.getClientId().equals(clientId)) {
        result.add(c);
      }
    }
    return result;
  }

  public static boolean create(String clientId) {
    String accountId = "A" + Main.aid;
    Compte compte = new Compte(clientId, accountId);
    Main.comptes.add(compte);
    Main.aid++;
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
}
