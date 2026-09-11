package services;

import java.io.FileWriter;
import java.io.IOException;

import models.Transaction;
import utils.DisplayUtils;

public class WriteService {
  public static void writeTransaction(Transaction transaction) {

    try {
      FileWriter fw = new FileWriter("transaction" + transaction.getTransactionId() + ".txt");
      fw.write("───────────────────────────────\n");
      fw.write("Date: " + transaction.getDate() + "\n");
      fw.write("Type: " + transaction.getType() + "\n");
      fw.write("Montant: " + transaction.getAmount() + " DH\n");
      fw.write("Compte Source: " + transaction.getCompteSource() + "\n");
      fw.write("Compte Destination: " + transaction.getCompteDestination() + "\n");
      fw.write("───────────────────────────────\n");
      fw.close();
    } catch (IOException e) {
      DisplayUtils.error("Error Writing!!!");
    }
  }
}
