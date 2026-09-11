package services;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import models.Transaction;
import services.WriteService;

public class TransactionService {
  public static HashSet<Transaction> transactions = new HashSet<>();
  public static int tid = 1;

  static {
    transactions.add(new Transaction("T1", "deposit", "01/01/2026 10:00", "A1001", null, 500));
    transactions.add(new Transaction("T2", "withdraw", "03/01/2026 14:30", "A1001", null, 100));
    transactions.add(new Transaction("T3", "transfer", "05/01/2026 09:15", "A1001", "A1002", 200));
    transactions.add(new Transaction("T4", "deposit", "08/02/2026 11:45", "A1001", null, 1000));
    tid = 5;
  }

  public static boolean create(String type, String compteSource, String compteDestination, float amount) {
    String transactionId = "T" + tid;

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    String newDateTime = date.format(formatter);
    Transaction transaction = new Transaction(transactionId, type, newDateTime, compteSource, compteDestination,
        amount);
    transactions.add(transaction);
    tid++;
    ///
    WriteService.writeTransaction(transaction);
    return true;
  }
}
