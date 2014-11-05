package Controller;

import Model.Boat.Type;
import Model.RegisterList;
import Model.Member;

import java.util.Scanner;

/*
 * Controller for adding a member to the list
 */
public class AddMember {

	private String memberName;
	private String memberPIN;
	private int countBoats = 0;
	private Scanner scan = new Scanner(System.in);

	/*
	 * Main method for adding the member. It takes the values of the names
	 * and attributes of the member by a scanner. There coulndn't be member
	 * without a boat.
	 */
	public void addMember(RegisterList list, View.AddMemberScreen s) {
		s.namePrompt();
		memberName = scan.nextLine();		//unknown problem with the scanner not registering input from one call
		memberName = scan.nextLine();

		s.numberPrompt();
		memberPIN = scan.next();

		s.boatCountPrompt();
		countBoats = scan.nextInt();

		Member member = new Member(memberName, memberPIN, list);

		for (int i = 1; i <= countBoats; i++) {							

			s.boatLengthPrompt();
			double lenghtPrompt = scan.nextDouble();
			s.boatTypePrompt();
			switch (s.getBoatTypeEvent()) {
			case Sailboat:
				member.addBoat(Type.Sailboat, lenghtPrompt);
				break;
			case Motorsailer:
				member.addBoat(Type.Motorsailer, lenghtPrompt);
				break;
			case Kayak:
				member.addBoat(Type.Kayak, lenghtPrompt);
				break;
			case Other:
				member.addBoat(Type.Other, lenghtPrompt);
				break;
			}

		}

		list.add(member);
		s.confirmPrompt();
	}
}
