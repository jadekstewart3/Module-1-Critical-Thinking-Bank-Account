public class CheckingAccount extends BankAccount{
  double interestRate;
  double overdraftFee = 30.00;

  public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
    super(firstName, lastName, accountID);
    this.interestRate = interestRate;
  }

  public double processWithdrawal(double amount){
    if(amount > getBalance()){
      return withdrawal(amount + overdraftFee);
    }else{
      return withdrawal(amount);
    }
  }

}