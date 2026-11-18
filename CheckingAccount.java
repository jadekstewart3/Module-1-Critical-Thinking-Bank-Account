public class CheckingAccount extends BankAccount{
  double interestRate;
  double overdraftFee;

  public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
    super(firstName, lastName, accountID);
    this.interestRate = interestRate;
  }

}