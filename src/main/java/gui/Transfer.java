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
final class Transfer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Font labelFont = new Font("Dialog", Font.BOLD, 14);
	private JLabel transferLabel, transferAmountLabel,transferAccountLabel;
	private JTextField transferAmountField,transferAccountField;
	private JButton backButton, transferButton;
	private double transferAmount;
	private int transferAccount;

	public Transfer() {
		super(null);

		transferLabel = new JLabel("Transfer");
		transferLabel.setFont(labelFont);
		transferLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transferLabel.setVerticalAlignment(SwingConstants.CENTER);
		transferLabel.setBounds(150, 10, 200, 50);
		
		transferAccountLabel = new JLabel("Transfer Account:");
		transferAccountLabel.setFont(labelFont);
		transferAccountLabel.setVerticalAlignment(SwingConstants.CENTER);
		transferAccountLabel.setBounds(75, 85, 200, 50);

		transferAmountLabel = new JLabel("Transfer Amount:");
		transferAmountLabel.setFont(labelFont);
		transferAmountLabel.setVerticalAlignment(SwingConstants.CENTER);
		transferAmountLabel.setBounds(75, 150, 200, 50);

		transferAccountField = new JTextField();
		transferAccountField.setFont(labelFont);
		transferAccountField.setToolTipText("Enter the account you want to transfer.");
		transferAccountField.setBounds(225, 85, 200, 50);
		
		transferAmountField = new JTextField();
		transferAmountField.setFont(labelFont);
		transferAmountField.setToolTipText("Enter the amount you want to transfer.");
		transferAmountField.setBounds(225, 150, 200, 50);

		backButton = new JButton("Back");
		backButton.setToolTipText("Return to the account menu.");
		backButton.setBounds(75, 285, 150, 50);

		transferButton = new JButton("Transfer");
		transferButton.setToolTipText("Transfer the desired amount into your account.");
		transferButton.setBounds(275, 285, 150, 50);

		this.add(transferLabel);
		this.add(transferAmountLabel);
		this.add(transferAmountField);
		this.add(transferAccountLabel);
		this.add(transferAccountField);
		this.add(backButton);
		this.add(transferButton);

	}

	public JLabel getTransferLabel() {
		return this.transferLabel;
	}

	public JLabel getTransferAmountLabel() {
		return this.transferAmountLabel;
	}

	public JTextField getTransferAmountField() {
		return this.transferAmountField;
	}
	
	public JLabel getTransferAccountLabel() {
		return this.transferAccountLabel;
	}

	public JTextField getTransferAccountField() {
		return this.transferAccountField;
	}

	public JButton getBackButton() {
		return this.backButton;
	}

	public JButton getTransferButton() {
		return this.transferButton;
	}

	public double getTransferAmount() {
		try {
			this.transferAmount = Double.parseDouble(transferAmountField.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		return this.transferAmount;
	}
	
	public int getTransferAccount() {
		try {
			this.transferAccount = Integer.parseInt(transferAccountField.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		return this.transferAccount;
	}

}