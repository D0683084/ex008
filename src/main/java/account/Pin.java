package account;



public final class Pin {


	private String pin;


	public Pin(String pin, String confirmPin) throws IllegalArgumentException {
		if (PINs_MATCH(pin, confirmPin)) {
			this.pin = String.format("%04d", Short.parseShort(pin));	// "%04d" is regex that adds leading zeros to the String if the length is less than 4.
		}
	}


	public void changePin(int accountNumber, String oldPin, String newPin, String confirmPin) throws IllegalArgumentException {
		if (IS_CORRECT_PIN(accountNumber, oldPin) && PINs_MATCH(newPin, confirmPin)) {
			pin = newPin;
		}
	}


	public static boolean IS_VALID_PIN(String pin) throws IllegalArgumentException {
		boolean onlyContainsNumbers = false;
		for (int i = 0; i < pin.length(); i++) {
			if (Character.isDigit(pin.charAt(i))) {
				onlyContainsNumbers = true;
			} else {
				onlyContainsNumbers = false;
				break;
			}
		}
		try {	// Short.parseShort() could throw NumberFormatException.
			if ((Short.parseShort(pin) >= 0) && (pin.length() == 4) && onlyContainsNumbers) {	// PIN must be 4 digits and cannot be negative.
				return true;
			} else {
				throw new IllegalArgumentException("Please enter a 4 digit PIN.");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Please enter a 4 digit numerical PIN.", new NumberFormatException());	// Sets NumberFormatException as cause.
		}
	}


	public static boolean PINs_MATCH(String pin, String confirmPin) throws IllegalArgumentException {
		if ((IS_VALID_PIN(pin) && IS_VALID_PIN(confirmPin)) && pin.equals(confirmPin)) {
			return true;
		} else {

			throw new IllegalArgumentException("The PINs you entered do not match.");
		}

	}


	public static boolean IS_CORRECT_PIN(int accountNumber, String accountPin) throws IllegalArgumentException, NullPointerException {
		if (Account.GET_ACCOUNT_MAP().get(accountNumber).getAccountPin().getPin().equals(accountPin)) {
			return true;
		} else {
			throw new IllegalArgumentException("The PIN you entered is incorrect.");
		}
	}


	@Override
	public boolean equals(Object confirmPin) {
		if (this.toString().equalsIgnoreCase(((Pin)confirmPin).toString())) {	// Casts confirmPin to type Pin. This forces it to use Pin.toString().
			return true;
		} else {
			return false;
		}
	}


	@Override
	public String toString() {
		return pin;
	}


	public String getPin() {
		return pin;
	}

}