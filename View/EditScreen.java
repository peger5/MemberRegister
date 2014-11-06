package View;

import Model.Member;


/*
 * View class responsible for the user interface used by the EditMember controller
 */
public class EditScreen extends Console {
	
	public enum EditEvent{
		Name, PIN, AddBoat, EditBoat, Delete
	}
	
	public enum BoatEditEvent{
		Type, Lenght, Delete, Back
	}
	
	public BoatEditEvent getBoatEditEvent(){
		while (true) {
			int c = GetInputChar();
			if (c == '1') {
			return BoatEditEvent.Type;
			} else if (c == '2') {
			return BoatEditEvent.Lenght;
			} else if (c == '3') {
			return BoatEditEvent.Delete;
			} else if (c == '4') {
			return BoatEditEvent.Back;
			}
			}
	}
	
	public EditEvent getEditEvent(){
		while (true) {
			int c = GetInputChar();
			if (c == '1') {
			return EditEvent.Name;
			} else if (c == '2') {
			return EditEvent.PIN;
			} else if (c == '3') {
			return EditEvent.AddBoat;
			} else if (c == '4') {
			return EditEvent.EditBoat;
			} else if(c == '5'){
			return EditEvent.Delete;
			}
			}
	}
	
	public void printBoatChoices(Member a_member){
		for (int i = 0; i < a_member.getBoatsNumber(); i++) {
			System.out.print(i + 1 + ". ");
			System.out
					.println(a_member.getBoat(i).getBoatType()
							+ " "
							+ a_member.getBoat(i)
									.getBoatLength());
		}
	}

	public void showEditOptions() {
		System.out.println("1. Edit name");
		System.out.println("2. Edit personal number");
		System.out.println("3. Add boat");
		System.out.println("4. Edit/Delete boat");
		System.out.println("5. Delete member");
	}

	public void showSelection() {
		System.out.print("Type in member number to edit: ");
	}

	public void showError() {
		System.out.println("Member number not found!");
	}
	
	public void showBoatError(){
		System.out.println("Boat not found!");
	}

	public void newNamePrompt() {
		System.out.print("Enter new name: ");
	}

	public void newPINPrompt() {
		System.out.print("Enter new personal number: ");
	}

	public void editBoatMenuPrompt() {
		System.out.println("1. Change type of the boat");
		System.out.println("2. Change lenght of the boat");
		System.out.println("3. Delete boat");
		System.out.println("4. Go back to main menu");
	}

	public void selectBoatToEdit() {
		System.out.print("Choose a boat to edit: ");
	}

	public void editBoatTypePrompt() {
		System.out.println("Choose new type: ");
		System.out
				.print("1.Sailboat\n 2.Motorsailer\n 3.Kayak\n 4.Other\n ");
	}

	public void editBoatLenghtPrompt() {
		System.out.print("Enter new lenght: ");
	}

}