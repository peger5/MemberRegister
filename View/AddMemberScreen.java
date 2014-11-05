package View;

/*
 * View class covering the user interface form the AddMember controller
 */
public class AddMemberScreen extends Console{
	

	public void namePrompt() {
		System.out.print("Enter name: ");

	}

	public void numberPrompt() {

		System.out.print("Enter personal number (YYMMDD-NNNN): ");
	}

	public void boatTypePrompt() {
		System.out
				.print("Enter boat type:\n 1.Sailboat\n 2.Motorsailer\n 3.Kayak\n 4.Other\n ");
	}

	public void boatLengthPrompt() {
		System.out.print("Enter lenght of boat: ");
	}

	public void boatCountPrompt() {
		System.out.print("Enter number of boats: ");
	}
	
	
}
