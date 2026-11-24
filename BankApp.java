import javax.swing.*;

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
    frame.setVisible(true);
  }
}