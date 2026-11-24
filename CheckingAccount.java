/**
 * CheckingAccount is a subclass of BankAccount.
 * It adds an interest rate and allows overdrafts,
 * charging a flat fee whenever a withdrawal exceeds the balance.
 */
public class CheckingAccount extends BankAccount{
  private double interestRate;
  private final double overdraftFee = 30.00; // flat fee charged on every overdraft

  // Creates a checking account with a specific interest rate.
  // super(...) passes the shared fields up to the BankAccount constructor.
  public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
    super(firstName, lastName, accountID);
    this.interestRate = interestRate;
  }

  // Creates a checking account using the default interest rate.
  // this(...) reuses the constructor above instead of repeating its code.
  public CheckingAccount(String firstName, String lastName, int accountID){
    this(firstName, lastName, accountID, 0.02); //default rate
  }

  /**
   * Withdraws money from the account. If the amount is more than the
   * current balance, the overdraft fee is added to the withdrawal and
   * a message shows the fee and the new (negative) balance.
   * Returns the updated balance.
   */
  public String processWithdrawal(double amount){
    if(amount > getBalance()){
      // overdraft: take out the amount plus the fee in a single withdrawal
      withdrawal(amount + overdraftFee);
      return String.format("Overdraft fee of $%.2f applied. Balance: $%.2f", overdraftFee, getBalance());
    }else{
      // enough money in the account: normal withdrawal, no fee
      withdrawal(amount);
      return String.format("You have a remaining balance of $%.2f \n", getBalance());
    }
  }

  // Prints the inherited account details, then the checking-specific interest rate
  public void displayAccount(){
    super.accountSummary();
    System.out.println("Interest Rate: " + interestRate);
    System.out.println("--------------------------------");
  }

}
