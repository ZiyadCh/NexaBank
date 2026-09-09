import java.util.ArrayList;
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
  }

  public static void main(String[] args) {
    boolean running = false;

    while (!running) {
      System.out.println("┌────────────────────────────────┐");
      System.out.println("│       select une action:       │");
      System.out.println("├────────────────────────────────┤");
      System.out.println("│1❯ Log In                       │");
      System.out.println("│2❯ quitter                      │");
      System.out.println("└────────────────────────────────┘");
      switch (scanner.nextLine()) {
        case "1":
          Person.Login();
          break;

        case "2":
          System.out.println("program closed");
          return;

        default:
          System.out.println("Entrer un nombre correspondant!");
          break;
      }
    }

    // menu
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
    scanner.close();
  }
}
