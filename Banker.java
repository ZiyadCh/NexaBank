public class Banker extends Person {
  private String idBanker;

  public Banker(String nom, String prenom, String password, String email, int bid) {
    this.idBanker = "B" + bid;
    this.nom = nom;
    this.prenom = prenom;
    this.password = password;
    this.email = email;
  }

  public String getIdBanker() {
    return idBanker;
  }

  public void addClient() {
    System.out.println("Nom:");
    String nom = Main.scanner.nextLine();
    System.out.println("Prenom:");
    String prenom = Main.scanner.nextLine();
    System.out.println("Email:");
    String email = Main.scanner.nextLine();
    System.out.println("Mod de passe:");
    String password = Main.scanner.nextLine();
    Client client = new Client(nom, prenom, password, email, Main.cid);
    Main.clients.add(client);
    Main.cid++;
  }

  public void listClients() {
    System.out.println("\033[H\033[2J");
    String sep = "+----------+--------------+--------------+--------------------+---------+";
    String header = String.format("| %-8s | %-12s | %-12s | %-18s | %-7s |", "ID", "NOM", "PRENOM", "EMAIL", "SOLDE");
    System.out.println(sep);
    System.out.println(header);
    System.out.println(sep);
    for (Client c : Main.clients) {
      System.out.printf("| %-8s | %-12s | %-12s | %-18s | %-7.2f |%n",
        c.getIdClient(), c.getNom(), c.getPrenom(), c.getEmail(), c.getSolde());
    }
    System.out.println(sep);
  }

}
