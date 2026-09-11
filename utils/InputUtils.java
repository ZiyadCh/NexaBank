package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputUtils {

  public static float readAmount(Scanner scanner) {
    while (true) {
      try {
        float amount = scanner.nextFloat();
        scanner.nextLine();
        return amount;
      } catch (InputMismatchException e) {
        scanner.nextLine();
        DisplayUtils.error("Entrer un nombre!!");
      }
    }
  }

  private InputUtils() {}
}
