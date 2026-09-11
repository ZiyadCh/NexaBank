package services;

import java.util.HashSet;
import models.Client;

public class ClientService {
  public static HashSet<Client> clients = new HashSet<>();

  public static Client findById(String clientId) {
    for (Client c : clients) {
      if (c.getIdClient().equals(clientId)) {
        return c;
      }
    }
    return null;
  }
}
