
public class Transaction {

  private String transactionId;
  private String type;
  private String date;
  private String compteSource;
  private String compteDestination;

  public Transaction(String transactionId, String type, String date, String compteSource, String compteDestination) {
    this.transactionId = transactionId;
    this.type = type;
    this.date = date;
    this.compteSource = compteSource;
    this.compteDestination = compteDestination;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getCompteSource() {
    return compteSource;
  }

  public void setCompteSource(String compteSource) {
    this.compteSource = compteSource;
  }

  public String getCompteDestination() {
    return compteDestination;
  }

  public void setCompteDestination(String compteDestination) {
    this.compteDestination = compteDestination;
  }

}
