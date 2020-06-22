package account;


import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class Account {

	
	private static final HashMap<Integer, Account> ACCOUNT_MAP = new HashMap<>();


	static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");


	final int ACCOUNT_NUMBER;


	String accountName;

	Pin accountPin;

	String accountHistory;


	Account(String accountName, Pin accountPin) {
		ACCOUNT_NUMBER = GENERATE_ACCOUNT_NUMBER();
		this.accountName = accountName;
		this.accountPin = accountPin;
		accountHistory = DATE_TIME.format(LocalDateTime.now()) + " - Account opened.\n";
		ACCOUNT_MAP.put(ACCOUNT_NUMBER, this);
	}


	private static final int GENERATE_ACCOUNT_NUMBER() {
		int accountNumber;
		do {
			accountNumber = (int)(Math.random() * 1_000_000);
			if ((accountNumber < 100_000) || (accountNumber > 999_999)) {
				continue;
			} else if (ACCOUNT_MAP.containsKey(accountNumber)) {
				continue;
			} else {
				break;
			}
		} while (true);
		return accountNumber;
	}


	public static final Account GET_ACCOUNT(int accountNumber, String accountPin) throws IllegalArgumentException, NullPointerException {
		if (ACCOUNT_EXISTS(accountNumber) && Pin.IS_CORRECT_PIN(accountNumber, accountPin)) {
			return ACCOUNT_MAP.get(accountNumber);
		} else {
			return null;
		}
	}


	public static final boolean ACCOUNT_EXISTS(int accountNumber) throws NullPointerException {
		if (ACCOUNT_MAP.containsKey(accountNumber)) {
			return true;
		} else {
			throw new NullPointerException("This account does not exist. Please check the account number.");
		}
	}


	public final void changeAccountPin(String oldPin, String newPin, String confirmPin) throws IllegalArgumentException {
		accountPin.changePin(ACCOUNT_NUMBER, oldPin, newPin, confirmPin);
		accountHistory = accountHistory + DATE_TIME.format(LocalDateTime.now()) + " - Pin changed.\n";
	}


	public final void closeAccount(String accountPin) throws IllegalArgumentException {
		if (Pin.IS_CORRECT_PIN(ACCOUNT_NUMBER, accountPin)) {
			ACCOUNT_MAP.remove(ACCOUNT_NUMBER, this);
		}
	}


	public static final HashMap<Integer, Account> GET_ACCOUNT_MAP() {
		return ACCOUNT_MAP;
	}


	@Override
	public abstract boolean equals(Object account);


	@Override
	public abstract String toString();


	public final int getAccountNumber() {
		return ACCOUNT_NUMBER;
	}


	public final String getAccountName() {
		return accountName;
	}


	public final Pin getAccountPin() {
		return accountPin;
	}


	public final String getAccountHistory() {
		return accountHistory;
	}



}
