public class BankAccount {
 private String firstName;
 private String lastName;
 private int accountID;
 private double balance;

  public BankAccount(String firstName, String lastName, int accountID){
    try{
      this.firstName = firstName;
      this.lastName = lastName;
      this.accountID = accountID;
      this.balance = 0;
    } catch (Exception e) {
      System.out.println("Error: could not create account");
    }

  }
  //setters

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public void setAccountID(int accountID){
    this.accountID = accountID;
  }


  // getters

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
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

  public void accountSummary(){
    System.out.println("First Name: " + firstName);
    System.out.println("Last Name: " + lastName);
    System.out.println("Account id: " + accountID);
    System.out.printf("Balance :%.2f%n ", balance);
  }

}
