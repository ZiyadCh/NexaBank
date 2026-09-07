import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
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
