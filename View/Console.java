package View;

import Model.Member;

/*
 * Abstract class inherited by all view classes. Contains general user interface methods
 */
public abstract class Console {

	public int GetInputChar() {

		try {
			int c = System.in.read();
			while (c == '\r' || c == '\n') {
				c = System.in.read();
			}
			return c;
		} catch (java.io.IOException e) {
			System.out.println("" + e);
			return 0;
		}
	}

	public boolean pressEnterToContinue() {
		try {
			int c = System.in.read();
			if (c == '\r' || c == '\n') {
				return true;
			}

		} catch (java.io.IOException e) {
			System.out.println("" + e);

		}
		return false;
	}

	public Model.Boat.Type getBoatTypeEvent() {
		while (true) {
			int c = GetInputChar();
			if (c == '1') {
				return Model.Boat.Type.Sailboat;
			} else if (c == '2') {
				return Model.Boat.Type.Motorsailer;
			} else if (c == '3') {
				return Model.Boat.Type.Kayak;
			} else if (c == '4') {
				return Model.Boat.Type.Other;
			}
		}
	}

	public void confirmPrompt() {
		System.out.println("DONE!\n");
	}

	public void printName(Member a_member) {
		System.out.print(a_member.getName());
	}

	public void printMemberNumber(Member a_member) {
		System.out.print(a_member.getMemberNumber());
	}

	public void printMemberPIN(Member a_member) {
		System.out.print(a_member.getPersonalNumber());
	}

	public void printBoatCount(Member a_member) {
		System.out.print(a_member.getBoatsNumber());
	}

	public void printBoats(Member a_member) {
		System.out.print(a_member.getBoatListStr());
	}

	public void printLineBreak() {
		System.out.println();
	}
}
