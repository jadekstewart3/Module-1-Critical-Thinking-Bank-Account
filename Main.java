import java.util.Scanner;

/**
 * Main is the test class for BankAccount and CheckingAccount.
 * It runs a text menu that lets the user view account details,
 * deposit cash, and withdraw cash until they choose to exit.
 */
public class Main {
  // lowest and highest valid menu options
  static final int MIN = 1;
  static final int MAX = 4;
  static Scanner scnr = new Scanner(System.in);
  // test account used for the whole program run
  static CheckingAccount account = new CheckingAccount("Hannah", "Banana", 8675309);

  public static void main(String[] args) {
    // demonstrate setters and getters
    System.out.println("Original account:");
    account.displayAccount();

    account.setFirstName("Hannah Marie");
    account.setLastName("Montana");
    account.setAccountID(1234567);
    System.out.println("Updated account holder: " + account.getFirstName() + " "
        + account.getLastName() + " (ID: " + account.getAccountID() + ")");
    System.out.println("--------------------------------");

    mainMenu();
  }

  /**
   * Shows the menu and keeps asking until the user enters a whole
   * number between min and max. Returns the valid choice.
   */
  public static int getMenuChoice(int min, int max) {
    while (true) { // repeats until a valid choice is returned
      System.out.println("1. Display account details");
      System.out.println("2. Deposit cash");
      System.out.println("3. Withdraw cash");
      System.out.println("4. Exit");
      System.out.println("Please select an option " + min + "-" + max + ": ");
      String userInput = scnr.nextLine().trim();
      try {
        int choice = Integer.parseInt(userInput); // throws if input is not a whole number
        if (choice >= min && choice <= max) {
          return choice;
        }
        // input was a number, but outside the menu range
        System.out.println("Please enter a number between " + min + " and " + max + ".");
      } catch (NumberFormatException e) {
        System.out.println("Please enter a number.");
      }
    }
  }

  /**
   * Displays the given prompt and keeps asking until the user enters
   * a positive number. Whole numbers are accepted and read as doubles.
   * Used by both deposit and withdraw so the validation is not repeated.
   * Returns the valid amount.
   */
  public static double getAmount(String stringPrompt) {
    while (true) { // repeats until a valid amount is returned
      System.out.println(stringPrompt);
      try {
        double amount = Double.parseDouble(scnr.nextLine().trim()); // throws if input is not numeric
        if (amount <= 0) {
          // zero or negative amounts are not allowed
          System.out.println("Error: Number entered must be positive.");
        } else {
          return amount;
        }
      } catch (NumberFormatException e) {
        System.out.println("Error: Please ensure you enter a numeric value.");
      }
    }

  }

  /**
   * Runs the main menu loop and performs the action the user picks.
   * The loop ends when the user chooses option 4 (Exit).
   */
  public static void mainMenu() {
    int choice = 0;
    while (choice != 4) {
      choice = getMenuChoice(MIN, MAX);

      if (choice == 1) {
        // view account details
        account.displayAccount();

      } else if (choice == 2) {
        // deposit: get a valid amount, then add it to the balance
        account.deposit(getAmount("Please enter the amount you would like to deposit: "));

      } else if (choice == 3) {
        // withdraw: processWithdrawal applies the overdraft fee if needed
        account.processWithdrawal(getAmount("Please enter the amount to withdraw: "));
      } else {
        // exit
        System.out.println("Goodbye!");
        scnr.close();
      }
    }
  }
}
