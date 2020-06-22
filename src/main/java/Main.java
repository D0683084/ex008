

import gui.GUI;

import static util.Constants.INVALID_COMMAND_ARGS_CODE;


public final class Main {


	private Main() {}


	public static void main(String[] args) {
		if (args.length == 0) {
			new GUI();
		} else {
			System.out.println("Invalid command line arguments.");
			System.exit(INVALID_COMMAND_ARGS_CODE);
		}
	}

}