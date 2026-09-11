package services;

import java.io.FileWriter;
import java.io.IOException;

import models.Transaction;
import utils.DisplayUtils;

public class WriteService {
  public static void writeTransaction(Transaction transaction) {

    try {
      FileWriter fw = new FileWriter("transaction" + transaction.getTransactionId() + ".txt");
      fw.write("ID: " + transaction.getTransactionId() + "\n");
      fw.write("Type: " + transaction.getType() + "\n");
      fw.write("Date: " + transaction.getDate() + "\n");
      fw.write("Source: " + transaction.getCompteSource() + "\n");
      fw.write("Dest: " + transaction.getCompteDestination() + "\n");
      fw.write("Montant: " + transaction.getAmount() + "\n");
      fw.close();
    } catch (IOException e) {
      DisplayUtils.error("Error Writing!!!");
    }
  }
}
