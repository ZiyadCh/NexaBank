package utils;

public final class DisplayUtils {

  public static void error(String message) {
    System.out.println("─── ERROR ──────────────────────────");
    System.out.println(message);
    System.out.println("─────────────────────────────────────");
  }

  private DisplayUtils() {
  }
}
