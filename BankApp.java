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

    panel.add(amountLabel);
    panel.add(amountField);
    panel.add(showButton);
    panel.add(balanceLabel);

    frame.add(panel);

    BankAccount  account = new BankAccount("Zack", "Danger", 8675309);

    showButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        balanceLabel.setText(String.format("Balace: $%.2f", account.getBalance()));
      }
    });
    frame.setVisible(true);
  }
}