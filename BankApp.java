import javax.swing.*;
import java.awt.event.*;

/**
 * BankApp is the GUI for the bank program.
 * It asks the user for a starting balance, creates a CheckingAccount,
 * and lets the user deposit, withdraw, and view the balance using buttons.
 */
public class BankApp {
  public static void main(String[] args){
    // set up the main window
    JFrame frame = new JFrame("Bank Balance");
    frame.setSize(350, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // the panel holds all of the components shown in the window
    JPanel panel = new JPanel();

    // create the labels, text field, and buttons
    JLabel amountLabel = new JLabel("Amount: ");
    JTextField amountField = new JTextField(10);
    JButton showButton = new JButton("Show Balance");
    JLabel balanceLabel = new JLabel("Balance: $0.0");
    JButton depositButton = new JButton("Deposit");
    JButton withdrawButton = new JButton("Withdraw");
    JButton exitButton = new JButton("Exit");

    // add each component to the panel in the order they should appear
    panel.add(amountLabel);
    panel.add(amountField);
    panel.add(showButton);
    panel.add(balanceLabel);
    panel.add(depositButton);
    panel.add(withdrawButton);
    panel.add(exitButton);


    frame.add(panel);

    // ask for a starting balance until the user enters a valid number greater than 0
    boolean valid = false;
    double starting = 0;

    while(!valid){
        try{
          String input = JOptionPane.showInputDialog("Enter your starting balance: ");
          // input is null when the user clicks Cancel or closes the dialog, so exit the program
          if(input == null){
            System.exit(0);
          }

          // throws NumberFormatException if the input is not a number
          starting = Double.parseDouble(input);
        if(starting > 0){
          valid = true;
        } else {
          JOptionPane.showMessageDialog(null, "Please enter a number greater than 0.");
        }
      } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a number greater than 0.");
      }
    }
    // create the account and add the starting balance to it
    CheckingAccount account = new CheckingAccount("Zack", "Danger", 8675309);
    account.deposit(starting);
    balanceLabel.setText(String.format("Balance: $%.2f", account.getBalance()));


    // Show Balance button: displays the current balance in the balance label
    showButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        balanceLabel.setText(String.format("Balance: $%.2f", account.getBalance()));
      }
    });

    // Deposit button: reads the amount field, deposits it, and updates the balance label
    depositButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        try {
          double amount = Double.parseDouble(amountField.getText());
          if(amount > 0){
            account.deposit(amount);
            balanceLabel.setText(String.format("Balance: $%.2f", account.getBalance()));
          } else {
            balanceLabel.setText("Please enter a positive number to deposit.");
          }
        } catch(NumberFormatException ex){
          // the amount field was empty or not a number
          balanceLabel.setText("Please enter a valid number.");
        }
      }
    });

    // Withdraw button: reads the amount field, withdraws it using the
    // CheckingAccount rules, and updates the balance label
    withdrawButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        try{
          double amount = Double.parseDouble(amountField.getText());
          // processWithdrawal() returns a message (including any overdraft fee), so show it to the user
          if(amount > 0){
            String message = account.processWithdrawal(amount);
            JOptionPane.showMessageDialog(null, message);
            balanceLabel.setText(String.format("Balance: $%.2f", account.getBalance()));
          } else {
            balanceLabel.setText("Please enter a positive number to withdraw.");
          }
        } catch(NumberFormatException ex){
          // the amount field was empty or not a number
          balanceLabel.setText("Please enter a valid number.");
        }
      }
    });

    // Exit button: shows the final balance in a dialog, then closes the program
    exitButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, String.format("Final balance: $%.2f", account.getBalance()));
        System.exit(0);
      }
    });

    // show the window only after everything is set up
    frame.setVisible(true);
  }
}
