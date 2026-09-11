package services;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import models.Transaction;

public class TransactionService {
  public static HashSet<Transaction> transactions = new HashSet<>();
  public static int tid = 1;

  public static boolean create(String type, String compteSource, String compteDestination) {
    String transactionId = "T" + tid;

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    String newDateTime = date.format(formatter);
    Transaction transaction = new Transaction(transactionId, type, newDateTime, compteSource, compteDestination);

    tid++;
    return true;
  }
}
