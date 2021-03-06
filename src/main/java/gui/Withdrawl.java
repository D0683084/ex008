package gui;



import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("javadoc")
public
final class Withdrawl extends JPanel {


	private static final long serialVersionUID = 1L;
	private static Font labelFont = new Font("Dialog", Font.BOLD, 14);
	private JLabel withdrawlLabel, withdrawtlAmountLabel;
	private JTextField withdrawlAmountField;
	private JButton backButton, withdrawlButton;
	private double withdrawlAmount;


	public Withdrawl() {
		super(null);

		withdrawlLabel = new JLabel("Withdrawl");
		withdrawlLabel.setFont(labelFont);
		withdrawlLabel.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawlLabel.setVerticalAlignment(SwingConstants.CENTER);
		withdrawlLabel.setBounds(150, 10, 200, 50);

		withdrawtlAmountLabel = new JLabel("Withdrawl Amount:");
		withdrawtlAmountLabel.setFont(labelFont);
		withdrawtlAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		withdrawtlAmountLabel.setBounds(75, 137, 200, 50);

		withdrawlAmountField = new JTextField();
		withdrawlAmountField.setFont(labelFont);
		withdrawlAmountField.setToolTipText("Enter the amount you want to withdrawl to your account.");
		withdrawlAmountField.setBounds(225, 138, 200, 50);

		backButton = new JButton("Back");
		backButton.setToolTipText("Return to the account menu.");
		backButton.setBounds(75, 285, 150, 50);

		withdrawlButton = new JButton("Withdrawl");
		withdrawlButton.setToolTipText("Withdrawl the desired amount into your account.");
		withdrawlButton.setBounds(275, 285, 150, 50);

		this.add(withdrawlLabel);
		this.add(withdrawtlAmountLabel);
		this.add(withdrawlAmountField);
		this.add(backButton);
		this.add(withdrawlButton);

	}

	public JLabel getWithdrawlLabel() {
		return this.withdrawlLabel;
	}

	public JLabel getWithdrawlAmountLabel() {
		return this.withdrawtlAmountLabel;
	}

	public JTextField getWithdrawlAmountField() {
		return this.withdrawlAmountField;
	}

	public JButton getBackButton() {
		return this.backButton;
	}

	public JButton getWithdrawlButton() {
		return this.withdrawlButton;
	}

	public double getWithdrawlAmount() {
		try {
			this.withdrawlAmount = Double.parseDouble(withdrawlAmountField.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		return this.withdrawlAmount;
	}

}