public class CheckingAccount extends BankAccount{
  private double interestRate;
  private final double overdraftFee = 30.00;

  public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
    super(firstName, lastName, accountID);
    this.interestRate = interestRate;
  }

  public CheckingAccount(String firstName, String lastName, int accountID){
    this(firstName, lastName, accountID, 0.02); //default rate
  }

  public double processWithdrawal(double amount){
    if(amount > getBalance()){
      withdrawal(amount + overdraftFee);
      System.out.printf("You have overdrafted your account. Overdraft fee of $%.2f applied! Balance: $%.2f%n", overdraftFee, getBalance());
      return getBalance();
    }else{
      return withdrawal(amount);
    }
  }

  public void displayAccount(){
    super.accountSummary();
    System.out.println("Interest Rate: " + interestRate);
    System.out.println("--------------------------------");
  }

}