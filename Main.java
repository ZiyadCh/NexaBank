import java.util.HashSet;
import java.util.Scanner;

public class Main {
  public static HashSet<Client> clients = new HashSet<>();
  public static HashSet<Banker> bankers = new HashSet<>();
  public static Scanner scanner = new Scanner(System.in);

  static {
    clients.add(new Client("Jean", "Dupont", "pass123", "jean@nexabank.com", 1));
    clients.add(new Client("Marie", "Curie", "radium", "marie@nexabank.com", 2));
    clients.add(new Client("Pierre", "Martin", "secret", "pierre@nexabank.com", 3));
    clients.add(new Client("Alice", "Durand", "alicepw", "alice@nexabank.com", 4));
    clients.add(new Client("Lucas", "Bernard", "lucas88", "lucas@nexabank.com", 5));
    bankers.add(new Banker("Sophie", "Tremblay", "bankpass", "sophie@nexabank.com", 1));
  }

  public static void main(String[] args) {
    System.out.println("┌────────────────────────────────┐");
    System.out.println("│       select une action:       │");
    System.out.println("├────────────────────────────────┤");
    System.out.println("│1❯ Log In                       │");
    System.out.println("│2❯ quitter                      │");
    System.out.println("└────────────────────────────────┘");
    switch (scanner.nextLine()) {
      case "1":
        Person user = Person.Login();
        if (user instanceof Client) {
          ClientUI((Client) user);
        } else if (user instanceof Banker) {
          BankerUI((Banker) user);
        } else
          System.out.println("incorrect");
        break;

      case "2":
        System.out.println("program closed");
        return;

      default:
        System.out.println("Entrer un nombre correspondant!");
        break;
    }

    scanner.close();
  }

  ////////////////////////////////////////// usergestionaire //////////////////////////////////////////
  private static void BankerUI(Banker banker) {
    boolean running = true;
    while (running) {
      System.out.println("┌────────────────────────────────┐");
      System.out.println("│     select une operation       │");
      System.out.println("├────────────────────────────────┤");
      System.out.println("│1❯ Creer un compte              │");
      System.out.println("│2❯ Bloquer un compte            │");
      System.out.println("│3❯ Modifier un compte           │");
      System.out.println("│4❯ quitter                      │");
      System.out.println("└────────────────────────────────┘");
      switch (scanner.nextLine()) {
        case "1":
          break;

        case "2":
          break;

        case "3":
          break;

        case "4":
          System.out.println("program closed");
          running = false;
          break;

        default:
          System.out.println("Entrer un nombre correspondant!");
          break;
      }
    }
  }

  ////////////////////////////////////////// userclient //////////////////////////////////////////
  public static void ClientUI(Client client) {
    boolean running = true;
    while (running) {
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
          break;

        case "2":
          break;

        case "3":
          break;

        case "4":
          System.out.println("program closed");
          running = false;
          break;

        default:
          System.out.println("Entrer un nombre correspondant!");
          break;
      }
    }
  }
}
