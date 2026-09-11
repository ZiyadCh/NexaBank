package services;

import java.util.HashSet;
import models.Client;

public class ClientService {
  public static HashSet<Client> clients = new HashSet<>();

  static {
    clients.add(new Client("Jean", "Dupont", "pass123", "jean", 1));
    clients.add(new Client("Marie", "Curie", "radium", "marie", 2));
    clients.add(new Client("Pierre", "Martin", "secret", "pierre@nexabank.com", 3));
    clients.add(new Client("Alice", "Durand", "alicepw", "alice@nexabank.com", 4));
    clients.add(new Client("Lucas", "Bernard", "lucas88", "lucas@nexabank.com", 5));
  }

  public static Client findById(String clientId) {
    for (Client c : clients) {
      if (c.getIdClient().equals(clientId)) {
        return c;
      }
    }
    return null;
  }
}
