/**
 * BankAccount is the superclass for all account types.
 * It stores the account holder's name, account ID, and balance,
 * and provides basic deposit and withdrawal operations.
 */
public class BankAccount {
 private String firstName;
 private String lastName;
 private int accountID;
 private double balance;

  /**
   * Creates a new account for the given holder. Every new account
   * starts with a balance of zero.
   */
  public BankAccount(String firstName, String lastName, int accountID){
    this.firstName = firstName;
    this.lastName = lastName;
    this.accountID = accountID;
    this.balance = 0.0;
  }

  //setters - allow account details to be changed after creation

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public void setAccountID(int accountID){
    this.accountID = accountID;
  }

  // getters - give read-only access to the private fields

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAccountID(){
    return accountID;
  }

  // balance has no setter; it only changes through deposit() and withdrawal()
  public double getBalance(){
    return balance;
  }

  /**
   * Adds the given amount to the balance.
   * Returns the updated balance.
   */
  public double deposit(double amount){
    balance += amount;
    return balance;
  }

  /**
   * Subtracts the given amount from the balance.
   * No overdraft check is done here; subclasses can add their own rules.
   * Returns the updated balance.
   */
  public double withdrawal(double amount){
    balance -= amount;
    return balance;
  }

  // Prints all account information
  public void accountSummary(){
    System.out.println("First Name: " + firstName);
    System.out.println("Last Name: " + lastName);
    System.out.println("Account id: " + accountID);
    System.out.printf("Balance: $%.2f%n", balance);
  }

}
