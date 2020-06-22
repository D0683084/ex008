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
final class ChangePin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Font labelFont = new Font("Dialog", Font.BOLD, 14);
	private JLabel ChangePinLabel, OldPinLabel,NewPinLabel;
	private JTextField OldPinField,NewPinField;
	private JButton backButton, changeButton;
	private int newpin;

	public ChangePin() {
		super(null);

		ChangePinLabel = new JLabel("ChangePin");
		ChangePinLabel.setFont(labelFont);
		ChangePinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ChangePinLabel.setVerticalAlignment(SwingConstants.CENTER);
		ChangePinLabel.setBounds(150, 10, 200, 50);

		OldPinLabel = new JLabel("Old Pin:");
		OldPinLabel.setFont(labelFont);
		OldPinLabel.setVerticalAlignment(SwingConstants.CENTER);
		OldPinLabel.setBounds(75, 85, 200, 50);

		OldPinField = new JTextField();
		OldPinField.setFont(labelFont);
		OldPinField.setToolTipText("Enter the your old pin.");
		OldPinField.setBounds(225, 85, 200, 50);
		
		NewPinLabel = new JLabel("New Pin:");
		NewPinLabel.setFont(labelFont);
		NewPinLabel.setVerticalAlignment(SwingConstants.CENTER);
		NewPinLabel.setBounds(75, 150, 200, 50);

		NewPinField = new JTextField();
		NewPinField.setFont(labelFont);
		NewPinField.setToolTipText("Enter the pin you want to change.");
		NewPinField.setBounds(225, 150, 200, 50);

		backButton = new JButton("Back");
		backButton.setToolTipText("Return to the account menu.");
		backButton.setBounds(75, 285, 150, 50);

		changeButton = new JButton("Change");
		changeButton.setToolTipText("Change your old pin to your new pin.");
		changeButton.setBounds(275, 285, 150, 50);

		this.add(ChangePinLabel);
		this.add(OldPinLabel);
		this.add(OldPinField);
		this.add(NewPinLabel);
		this.add(NewPinField);
		this.add(backButton);
		this.add(changeButton);

	}

	public JLabel getChangePinLabel() {
		return this.ChangePinLabel;
	}

	public JLabel getOldPinLabel() {
		return this.OldPinLabel;
	}
	
	public JLabel getNewPinLabel() {
		return this.NewPinLabel;
	}


	public JTextField getOldPinField() {
		return this.OldPinField;
	}
	
	public JTextField getNewPinField() {
		return this.NewPinField;
	}

	public JButton getBackButton() {
		return this.backButton;
	}

	public JButton getchangeButton() {
		return this.changeButton;
	}

	public int getnewpin() {
		try {
			this.newpin = Integer.parseInt(NewPinField.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		return this.newpin;
	}

}

