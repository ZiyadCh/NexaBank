package services;

import models.Client;
import models.Banker;
import models.Person;

public class AuthService {

  public static Person login(String email, String password) {
    for (Client c : ClientService.clients) {
      if (email.equals(c.getEmail()) && password.equals(c.getPassword())) {
        return c;
      }
    }
    for (Banker b : BankerService.bankers) {
      if (email.equals(b.getEmail()) && password.equals(b.getPassword())) {
        return b;
      }
    }
    return null;
  }
}
