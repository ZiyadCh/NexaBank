import java.util.Scanner;

import models.Client;
import models.Banker;
import models.Compte;
import models.Person;
import services.AuthService;
import services.CompteService;

public class Main {
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("┌────────────────────────────────┐");
    System.out.println("│       select une action:       │");
    System.out.println("├────────────────────────────────┤");
    System.out.println("│1❯ Log In                       │");
    System.out.println("│2❯ quitter                      │");
    System.out.println("└────────────────────────────────┘");

    switch (scanner.nextLine()) {
      case "1":

        Person user = loginUI();
        if (user instanceof Client) {
          ClientUI((Client) user);
        } else if (user instanceof Banker) {
          BankerUI((Banker) user);
        }
        break;

      case "2":
        System.out.println("program closed");
        return;

      default:
        System.out.println("─── ERROR ──────────────────────────");
        System.out.println("Entrer un nombre correspondant!");
        System.out.println("─────────────────────────────────────");
        break;
    }

    scanner.close();
  }

  private static Person loginUI() {
    System.out.println("Email:");
    String email = scanner.nextLine();
    System.out.println("Password:");
    String password = scanner.nextLine();

    Person user = AuthService.login(email, password);
    if (user == null) {
      System.out.println("─── ERROR ──────────────────────────");
      System.out.println("Email ou mot de passe incorrect");
      System.out.println("─────────────────────────────────────");
    }
    return user;
  }

  private static void BankerUI(Banker banker) {
    boolean running = true;
    while (running) {
      System.out.println("┌────────────────────────────────┐");
      System.out.println("│     select une operation       │");
      System.out.println("├────────────────────────────────┤");
      System.out.println("│1❯ Creer un compte              │");
      System.out.println("│2❯ Bloquer un compte            │");
      System.out.println("│3❯ Modifier un compte           │");
      System.out.println("│4❯ Consulter releve d'un compte │");
      System.out.println("│5❯ Quitter                      │");
      System.out.println("└────────────────────────────────┘");
      switch (scanner.nextLine()) {
        case "1":
          createAccountUI();
          break;

        case "2":
          banUserUI();
          break;

        case "3":
          break;

        case "5":
          System.out.println("Au revoir");
          running = false;
          break;

        default:
          System.out.println("─── ERROR ──────────────────────────");
          System.out.println("Entrer un nombre correspondant!");
          System.out.println("─────────────────────────────────────");
          break;
      }
    }
  }

  private static void banUserUI() {
    listComptesUI();
    System.out.println("Numero de compte pour cloturer:");
    String accountId = scanner.nextLine();

    Compte compte = CompteService.ban(accountId);
    if (compte == null) {
      System.out.println("Compte non trouve.");
      return;
    }
    if (compte.isActive()) {
      System.out.println("Compte " + accountId + " debloque.");
    } else {
      System.out.println("Compte " + accountId + " bloque.");
    }
  }

  private static void createAccountUI() {
    System.out.println("ID du client:");
    String clientId = scanner.nextLine();

    boolean created = CompteService.create(clientId);
    if (!created) {
      System.out.println("Client non trouve.");
      return;
    }
    System.out.println("Compte cree pour le client " + clientId);
  }

  private static void listComptesUI() {
    System.out.println("Liste des comptes:");
    System.out.println("───────────────────────────────");
    for (Compte compte : CompteService.comptes) {
      System.out.println("Compte ID: " + compte.getAccountId());
      System.out.println("Client ID: " + compte.getClientId());
      System.out.println("Solde: " + compte.getSolde());
      System.out.println("Active:" + compte.isActive());
      System.out.println("───────────────────────────────");
    }
  }

  public static void ClientUI(Client client) {
    boolean running = true;
    while (running) {
      Compte c = selectCompteUI(client.getIdClient());
      if (c == null) {
        running = false;
        break;
      }
      System.out.println("┌────────────────────────────────┐");
      System.out.println("│     select une transaction:    │");
      System.out.println("├────────────────────────────────┤");
      System.out.println("│1❯ Depot                        │");
      System.out.println("│2❯ Retirer                      │");
      System.out.println("│3❯ Virement                     │");
      System.out.println("│4❯ quitter                      │");
      System.out.println("└────────────────────────────────┘");
      switch (scanner.nextLine()) {
        case "1":
          depositUI(c);
          break;

        case "2":
          withdrawUI(c);
          break;

        case "3":
          transferUI(c);
          break;

        case "4":
          System.out.println("program closed");
          running = false;
          break;

        default:
          System.out.println("─── ERROR ──────────────────────────");
          System.out.println("Entrer un nombre correspondant!");
          System.out.println("─────────────────────────────────────");
          break;
      }
    }
  }

  private static Compte selectCompteUI(String clientId) {
    System.out.println("Votre comptes:");
    System.out.println("───────────────────────────────");
    boolean hasAccount = false;
    for (Compte compte : CompteService.findByClientId(clientId)) {
      System.out.println("Compte ID: " + compte.getAccountId());
      System.out.println("Solde: " + compte.getSolde());
      System.out.println("───────────────────────────────");
      hasAccount = true;
    }
    if (!hasAccount) {
      System.out.println("Aucun compte trouvee!");
      return null;
    }
    System.out.println("Entrer nombre du compte desire");
    String id = scanner.nextLine();

    Compte compte = CompteService.findById(id);
    if (compte == null) {
      System.out.println("Compte non trouvee!");
    }
    return compte;
  }

  private static void depositUI(Compte c) {
    System.out.println("Entrer Montant:");
    float amount = readAmount();
    if (amount < 0) {
      System.err.println("─── ERROR ──────────────────────────");
      System.err.println("le montant ne peut pas etre negatif!!");
      System.err.println("─────────────────────────────────────");
      return;
    }
    if (CompteService.deposit(c, amount)) {
      System.out.println("Montant deposer avec succes!");
    }
  }

  private static void withdrawUI(Compte c) {
    System.out.println("Entrer Montant:");
    float amount = readAmount();
    if (!CompteService.withdraw(c, amount)) {
      System.err.println("─── ERROR ──────────────────────────");
      System.err.println("vous ne posseder pas ce montant!!");
      System.err.println("─────────────────────────────────────");
      return;
    }
    System.out.println("Montant retirer avec succes!");
  }

  private static void transferUI(Compte c) {
    System.out.println("Entrer nombre du compte:");
    String targetId = scanner.nextLine();
    System.out.println("Entrer Montant:");
    float amount = readAmount();

    if (!CompteService.transfer(c, targetId, amount)) {
      System.err.println("─── ERROR ──────────────────────────");
      System.err.println("vous ne posseder pas ce montant!!");
      System.err.println("─────────────────────────────────────");
      return;
    }
    System.out.println("Virement effectue avec succes!");
  }

  private static float readAmount() {
    float amount = scanner.nextFloat();
    scanner.nextLine();
    return amount;
  }
}
