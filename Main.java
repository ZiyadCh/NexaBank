import java.util.Scanner;

import models.Client;
import models.Banker;
import models.Compte;
import models.Person;
import models.Transaction;
import services.AuthService;
import services.ClientService;
import services.CompteService;
import services.TransactionService;
import utils.DisplayUtils;
import utils.InputUtils;

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
        DisplayUtils.error("Entrer un nombre correspondant!");
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
      DisplayUtils.error("Email ou mot de passe incorrect");
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
          modifyUserUi();
          break;

        case "4":
          listTransactionsUI();
          break;

        case "5":
          System.out.println("Au revoir");
          running = false;
          break;

        default:
          DisplayUtils.error("Entrer un nombre correspondant!");
          break;
      }
    }
  }

  private static void modifyUserUi() {
    listClientsUI();
    System.out.println("Id de client pour modifier");
    String clientId = scanner.nextLine();
    Client client = ClientService.findById(clientId);
    if (client == null) {
      System.out.println("Client non trouve.");
      return;
    }
    System.out.println("Nouveau nom:");
    String nom = scanner.nextLine();
    System.out.println("Nouveau prenom:");
    String prenom = scanner.nextLine();

    ClientService.modify(client, nom, prenom);

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

  private static void listClientsUI() {
    System.out.println("Liste des clients:");
    System.out.println("───────────────────────────────");
    for (Client c : ClientService.clients) {
      System.out.println("ID: " + c.getIdClient());
      System.out.println("Nom: " + c.getNom());
      System.out.println("Prenom: " + c.getPrenom());
      System.out.println("Email: " + c.getEmail());
      System.out.println("───────────────────────────────");
    }
  }

  private static void listTransactionsUI() {
    System.out.println("Entrer Numero de compte");
    String compteSource = scanner.nextLine();
    System.out.println("Transactions du compte " + compteSource + ":");
    System.out.println("───────────────────────────────");
    for (Transaction t : TransactionService.transactions) {
      if (t.getCompteSource().equals(compteSource)) {
        System.out.println("ID: " + t.getTransactionId());
        System.out.println("Type: " + t.getType());
        System.out.println("Date: " + t.getDate());
        System.out.println("Compte source: " + t.getCompteSource());
        System.out.println("Compte destination: " + t.getCompteDestination());
        System.out.println("───────────────────────────────");
      }
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
          DisplayUtils.error("Entrer un nombre correspondant!");
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
    float amount = InputUtils.readAmount(scanner);
    if (amount < 0) {
      DisplayUtils.error("le montant ne peut pas etre negatif!!");
      return;
    }
    if (CompteService.deposit(c, amount)) {
      System.out.println("Montant deposer avec succes!");
    }
  }

  private static void withdrawUI(Compte c) {
    System.out.println("Entrer Montant:");
    float amount = InputUtils.readAmount(scanner);
    if (!CompteService.withdraw(c, amount)) {
      DisplayUtils.error("vous ne posseder pas ce montant!!");
      return;
    }
    System.out.println("Montant retirer avec succes!");
  }

  private static void transferUI(Compte c) {
    System.out.println("Entrer nombre du compte:");
    String targetId = scanner.nextLine();
    System.out.println("Entrer Montant:");
    float amount = InputUtils.readAmount(scanner);

    if (!CompteService.transfer(c, targetId, amount)) {
      DisplayUtils.error("vous ne posseder pas ce montant!!");
      return;
    }
    System.out.println("Virement effectue avec succes!");
  }
}
