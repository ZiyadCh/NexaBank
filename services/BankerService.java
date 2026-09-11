package services;

import java.util.HashSet;
import models.Banker;

public class BankerService {
  public static HashSet<Banker> bankers = new HashSet<>();

  static {
    bankers.add(new Banker("Sophie", "Tremblay", "bankpass", "sophie", 1));
  }
}
