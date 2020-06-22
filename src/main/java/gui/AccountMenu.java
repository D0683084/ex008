package gui;

/**
 * @author Joshua Ciffer
 * @version 12/06/2017
 */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("javadoc")
public
final class AccountMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Font labelFont = new Font("Dialog", Font.BOLD, 14);
	private JLabel accountMenuLabel;
	private JButton makeDepositButton, makeWithdrawalButton, makeTransferButton, checkBalanceButton, changepinButton, logoutButton;

	public AccountMenu() {
		super(null);

		accountMenuLabel = new JLabel("Account Menu");
		accountMenuLabel.setFont(labelFont);
		accountMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountMenuLabel.setVerticalAlignment(SwingConstants.CENTER);
		accountMenuLabel.setBounds(150, 10, 200, 50);

		makeDepositButton = new JButton("Deposit");
		makeDepositButton.setToolTipText("Make a deposit to your account.");
		makeDepositButton.setBounds(150, 71, 200, 50);

		makeWithdrawalButton = new JButton("Withdrawl");
		makeWithdrawalButton.setToolTipText("Make a withdrawal from your account.");
		makeWithdrawalButton.setBounds(150, 132, 200, 50);

		makeTransferButton = new JButton("Transfer");
		makeTransferButton.setToolTipText("Make a transfer from your account to another account.");
		makeTransferButton.setBounds(150, 212, 200, 50);

		checkBalanceButton = new JButton("Check Balance");
		checkBalanceButton.setToolTipText("Check your account balance.");
		checkBalanceButton.setBounds(150, 273, 200, 50);
		
		checkBalanceButton = new JButton("Check Balance");
		checkBalanceButton.setToolTipText("Check your account balance.");
		checkBalanceButton.setBounds(150, 273, 200, 50);

		changepinButton = new JButton("Change Pin");
		changepinButton.setToolTipText("Change your account pin.");
		changepinButton.setBounds(150, 334, 200, 50);

		logoutButton = new JButton("Logout");
		logoutButton.setToolTipText("Logout from your account.");
		logoutButton.setBounds(150, 418, 200, 50);

		this.add(accountMenuLabel);
		this.add(makeDepositButton);
		this.add(makeWithdrawalButton);
		this.add(makeTransferButton);
		this.add(checkBalanceButton);
		this.add(changepinButton);
		this.add(logoutButton);
	}

	public JLabel getAccountMenuLabel() {
		return this.accountMenuLabel;
	}

	public JButton getMakeDepositButton() {
		return this.makeDepositButton;
	}

	public JButton getMakeWithdrawlButton() {
		return this.makeWithdrawalButton;
	}

	public JButton getMakeTransferButton() {
		return this.makeTransferButton;
	}

	public JButton getCheckBalanceButton() {
		return this.checkBalanceButton;
	}

	public JButton getChangePinButton() {
		return this.changepinButton;
	}

	public JButton getLogoutButton() {
		return this.logoutButton;
	}

}