import java.util.Scanner;

public class Main {
  // deposit money
  //withdraw money
  //view account details
  //exit
  static final int MIN = 1;
  static final int MAX = 4;
  static Scanner scnr = new Scanner(System.in);
  static CheckingAccount account = new CheckingAccount("Hannah", "Banana", 8675309);

  public static void main(String[] args){
    mainMenu();
  }

  public static int getMenuChoice(int min, int max){
    while(true){
      System.out.println("1. Display account details");
      System.out.println("2. Deposit cash");
      System.out.println("3. Withdraw cash");
      System.out.println("4. Exit");
      System.out.println("Please select an option " + min + "-" + max + ": ");
      String userInput = scnr.nextLine().trim();
      try{
        int choice = Integer.parseInt(userInput);
        if(choice >= min && choice <= max){
          return choice;
        }
        System.out.println("Please enter a number between" + min + " and" + max + ".");
      } catch (NumberFormatException e ){
          System.out.println("Please enter a number.");
      }
    }
  }

  public static void mainMenu(){
    int choice = 0;
    while(choice != 4){
      choice = getMenuChoice(MIN, MAX);

      if(choice == 1){
        account.displayAccount();

      } else if(choice == 2){
        while(true){
          System.out.println("Please enter the amount you would like to deposit: ");
          try {
            double depositAmount = Double.parseDouble(scnr.nextLine().trim());
            account.deposit(depositAmount);
            break;
          } catch (NumberFormatException e){
            System.out.println("Error: Please ensure you enter a numeric value.");
          }
        }
      } else if(choice == 3){
        System.out.println("Please enter the amount to withdraw: ");
        double withdrawAmount = Double.parseDouble(scnr.nextLine().trim());
        account.withdrawal(withdrawAmount);
      } else {
        System.out.println("Goodbye!");
        scnr.close();
      }
    }
  }
}