import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  //clients list
  public static ArrayList<Client> clients;
  public static ArrayList<Banker> bankers ;
  //global scanner
  public static Scanner scanner = new Scanner(System.in);
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
          
        // Client.Login();
          break;



        case "2":
          System.out.println("program closed");
          running = true;
          break;

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
