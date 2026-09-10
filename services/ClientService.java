import models.Client;

public class ClientService {

  public static Client findById(String clientId) {
    for (Client c : Main.clients) {
      if (c.getIdClient().equals(clientId)) {
        return c;
      }
    }
    return null;
  }
}
