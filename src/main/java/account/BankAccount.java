package account;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;


public class BankAccount extends Account {


	static final NumberFormat US_DOLLARS = NumberFormat.getCurrencyInstance(Locale.US);
	
	private static final NumberFormat PERCENTAGE = NumberFormat.getPercentInstance();
	
	private double interestRate=0.01;


	BigDecimal accountBalance;


	public BankAccount(String accountName, Pin accountPin, BigDecimal accountBalance) throws IllegalArgumentException {
		super(accountName, accountPin);
		try {
			if (IS_POSITIVE_AMOUNT(accountBalance.doubleValue())) {
				this.accountBalance = accountBalance.setScale(2, RoundingMode.HALF_UP);		// Sets accountBalance to round to 2 significant digits.
			}
		} catch (IllegalArgumentException e) {
			closeAccount(this.accountPin.getPin());
			throw new IllegalArgumentException("Please enter a positive amount for your account balance.");
		}
	}


	public static final String TO_CURRENCY_FORMAT(double amount) {
		return US_DOLLARS.format(amount);
	}


	public static final String TO_CURRENCY_FORMAT(BigDecimal amount) {
		return US_DOLLARS.format(amount);
	}


	public static final boolean IS_POSITIVE_AMOUNT(double amount) throws IllegalArgumentException {
		if (amount >= 0) {
			return true;
		} else {
			throw new IllegalArgumentException("Please enter a positive amount.");
		}
	}


	public final boolean hasSufficientBalance(double amount) throws IllegalArgumentException {
		if (accountBalance.compareTo(new BigDecimal(amount)) >= 0) {
			return true;
		} else {
			throw new IllegalArgumentException("You have an insufficient balance to complete this transaction.");
		}
	}


	public final void transfer(int receivingAccount, double transferAmount) throws IllegalArgumentException, NullPointerException {
		if (ACCOUNT_EXISTS(receivingAccount) && IS_POSITIVE_AMOUNT(transferAmount) && hasSufficientBalance(transferAmount)) {
			accountBalance = accountBalance.subtract(new BigDecimal(transferAmount));
			accountHistory = accountHistory + DATE_TIME.format(LocalDateTime.now()) + " - Transfered " + TO_CURRENCY_FORMAT(transferAmount) + " to account #"
					+ receivingAccount + ".\n";
			BankAccount tempReceivingAccount = (BankAccount)GET_ACCOUNT_MAP().get(receivingAccount);
			tempReceivingAccount.accountBalance = tempReceivingAccount.accountBalance.add(new BigDecimal(transferAmount));
			tempReceivingAccount.accountHistory = tempReceivingAccount.accountHistory + DATE_TIME.format(LocalDateTime.now()) + " - Received "
					+ TO_CURRENCY_FORMAT(transferAmount) + " from account #" + ACCOUNT_NUMBER + ".\n";
			
		}
	}


	public void deposit(double depositAmount) throws IllegalArgumentException {
		if (IS_POSITIVE_AMOUNT(depositAmount)) {
			accountBalance = accountBalance.add(new BigDecimal(depositAmount + getInterest(depositAmount)));
			accountHistory = accountHistory + DATE_TIME.format(LocalDateTime.now()) + " - Deposited " + TO_CURRENCY_FORMAT(depositAmount) + ".\n";
		}
	}



	@Override
	public boolean equals(Object bankAccount) {
		if (this.toString().equalsIgnoreCase(((BankAccount)bankAccount).toString())) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public String toString() {
		return "Account Number: " + ACCOUNT_NUMBER + " \nAccount Name: " + accountName + " \nAccount Pin: " + accountPin + " \nAccount Balance: "
				+ TO_CURRENCY_FORMAT(accountBalance) + " \nInterest Rate: " + TO_PERCENTAGE_FORMAT(interestRate) + " \nAccount History: " + accountHistory;
	}


	public final BigDecimal getAccountBalance() {
		return accountBalance;
	}
	
	public double getInterest(double amount) {
		return (amount * (interestRate / 100));
	}

	
	public static String TO_PERCENTAGE_FORMAT(double percentage) {
		PERCENTAGE.setMinimumFractionDigits(2);
		PERCENTAGE.setMaximumFractionDigits(3);
		return PERCENTAGE.format(percentage / 100);
	}

	public final void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance.setScale(2, RoundingMode.HALF_UP);	  // Sets two significant decimal places.
	}

	public void withdrawl(double Amount) throws IllegalArgumentException {
		if (IS_POSITIVE_AMOUNT(Amount) && hasSufficientBalance(Amount)) {
			accountBalance = accountBalance.subtract(new BigDecimal(Amount));
			accountHistory = accountHistory + DATE_TIME.format(LocalDateTime.now()) + " - Withdrew " + TO_CURRENCY_FORMAT(Amount) + ".\n";
		}
	}

}
