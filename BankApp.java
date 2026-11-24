import javax.swing.*;
import java.awt.event.*;

public class BankApp {
  public static void main(String[] args){
    JFrame frame = new JFrame("Bank Balance");
    frame.setSize(350, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();

    JLabel amountLabel = new JLabel("Amount: ");
    JTextField amountField = new JTextField(10);
    JButton showButton = new JButton("Show Balance");
    JLabel balanceLabel = new JLabel("Balance: $0.0");
    JButton depositButton = new JButton("Deposit");
    JButton withdrawButton = new JButton("Withdraw");
    JButton exitButton = new JButton("Exit");

    panel.add(amountLabel);
    panel.add(amountField);
    panel.add(showButton);
    panel.add(balanceLabel);
    panel.add(depositButton);
    panel.add(withdrawButton);
    panel.add(exitButton);
  

    frame.add(panel);

    String input = JOptionPane.showInputDialog("Enter your starting balance: ");
    double starting = Double.parseDouble(input);
    CheckingAccount account = new CheckingAccount("Zack", "Danger", 8675309);
    account.deposit(starting);

    showButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        balanceLabel.setText(String.format("Balace: $%.2f", account.getBalance()));
      }
    });

    depositButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        try {
          double amount = Double.parseDouble(amountField.getText());
          account.deposit(amount);
          balanceLabel.setText(String.format("Balace: $%.2f", account.getBalance()));
        } catch(NumberFormatException ex){
          balanceLabel.setText("Please enter a valid number.");
        }
      }
    });

    withdrawButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        try{
          double amount = Double.parseDouble(amountField.getText());
          account.processWithdrawal(amount);
        } catch(NumberFormatException ex){
          balanceLabel.setText("Please enter a valid number.");
        }
      }
    });

    exitButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showInputDialog(null, String.format("Final balance: $%.2f", account.getBalance()));
        System.exit(0);
      }
    });

    frame.setVisible(true);
  }
}