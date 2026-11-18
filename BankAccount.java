public class BankAccount {
 private String firstName;
 private String lastName;
 private int accountID;
 private double balance = 0;

  public BankAccount(String firstName, String lastName, int accountID, double balance){
    try{
      this.firstName = firstName;
      this.lastName = lastName;
      this.accountID = accountID;
      this.balance = balance;
    } catch (Exception e) {
      System.out.println("Error: could not create account");
    }

  }

  // getters

  public String getFirstName() {
    try {
      return firstName;
    } catch (Exception e) {
      return "";
    }
  }

  public String getLastName() {
    try {
      return lastName;
    } catch (Exception e) {
      return "";
    }
  }

  public int getAccountID(){
    return accountID;
  }
  

  public double getBalance(){
    return balance;
  }

  public double deposit(double amount){
    balance += amount;
    return balance;
  }

  public double withdrawal(double amount){
    balance -= amount;
    return balance;
  }

  public void getSummary(){
    System.out.println("First Name: " + firstName);
    System.out.println("Last Name: " + lastName);
    System.out.println("Account id: " + accountID);
    System.out.println("Balance: " + balance);
  }

}
