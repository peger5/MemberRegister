package Controller;

import java.util.Scanner;

import Model.RegisterList;
import Model.Boat.Type;
import View.AddMemberScreen;
import View.EditScreen;

/*
 * Controller class responsible for the edit function of the register
 */
public class EditMember {

	private int memberPosition = -1;
	private int boatPosition;

	/*
	 * Method for selecting which member to edit
	 */
	public void selectMember(RegisterList list, EditScreen es) {
		Scanner scan = new Scanner(System.in);

		es.showSelection();

		int memberNumberSearch = scan.nextInt(); // member unique number

		for (int i = 0; i < list.size(); i++) { // search the position of

			  if (memberNumberSearch == list.get(i).getMemberNumber()) {
				memberPosition = i;
				es.showEditOptions();
			
			  }
				else if (i == list.size()-1 && memberPosition==-1) {
				es.showError();
				selectMember(list, es);
			}
		}
		

	}

	/*
	 * Method for changing the name of selected member
	 */
	public void editMemberName(RegisterList list, EditScreen es) {
		Scanner scan = new Scanner(System.in);
		es.newNamePrompt();
		String newName = scan.nextLine();
		newName = scan.nextLine();
		list.get(memberPosition).editName(newName);
		es.confirmPrompt();
	}

	/*
	 * Method for changing the personal number of selected member
	 */
	public void editPersonalNumber(RegisterList list, EditScreen es) {
		Scanner scan = new Scanner(System.in);
		es.newPINPrompt();
		String newPIN = scan.nextLine();
		newPIN = scan.nextLine();
		list.get(memberPosition).editPersonalNumber(newPIN);
		es.confirmPrompt();
	}
	
	/*
	 * Method for deleting a member from the register
	 */
	public void deleteMember(RegisterList list, EditScreen es) {
		list.remove(memberPosition);
		es.confirmPrompt();
	}
	
	/*
	 * Method for assigning a boat to selected member
	 */
	public void addBoatToMember(RegisterList list, EditScreen es) {
		AddMemberScreen s = new AddMemberScreen();
		Scanner scan = new Scanner(System.in);
		s.boatLengthPrompt();
		double boatLength = scan.nextDouble();

		s.boatTypePrompt();
		switch (es.getBoatTypeEvent()) {
		case Sailboat:
			list.get(memberPosition).addBoat(Type.Sailboat, boatLength);
			break;
		case Motorsailer:
			list.get(memberPosition).addBoat(Type.Motorsailer, boatLength);
			break;
		case Kayak:
			list.get(memberPosition).addBoat(Type.Kayak, boatLength);
			break;
		case Other:
			list.get(memberPosition).addBoat(Type.Other, boatLength);
			break;
		}
		es.confirmPrompt();
	}

	/*
	 * Method for selecting the edit options regarding boats
	 */
	public void boatEditMenu(RegisterList list, EditScreen es) {
		es.editBoatMenuPrompt();
		MainMenu m = new MainMenu();

		switch (es.getBoatEditEvent()) {
		case Type:
			this.changeBoatType(list, es);
			m.menuOptions(list);
			break;
		case Lenght:
			this.changeBoatLenght(list, es);
			m.menuOptions(list);
			break;
		case Delete:
			this.deleteBoat(list, es);
			m.menuOptions(list);
			break;
		case Back:
			m.menuOptions(list);
			break;
		}
	}

	/*
	 * Method for boat displaying
	 */
	public void boatList(RegisterList list, EditScreen es) {
		es.printBoatChoices(list.get(memberPosition));
	}

	/*
	 * Method for the user to select a boat to edit, boat is chosen depending on the boat list
	 */
	public void selectBoat(RegisterList list, EditScreen es) {
		Scanner scan = new Scanner(System.in);
		es.selectBoatToEdit();
		boatPosition = scan.nextInt() - 1;
		if(list.get(memberPosition).getBoat(boatPosition)==null){
			es.showBoatError();
			selectBoat(list,es);
		}
	}

	/*
	 * Method for editing the lenght of the previously selected boat
	 */
	public void changeBoatLenght(RegisterList list, EditScreen es) {
		Scanner scan = new Scanner(System.in);
		es.editBoatLenghtPrompt();
		double newLenght = scan.nextDouble();
		list.get(memberPosition).getBoat(boatPosition)
				.editBoatLength(newLenght);

		es.confirmPrompt();
	}
	
	/*
	 * Method for editing the type of the previously selected boat
	 */
	public void changeBoatType(RegisterList list, EditScreen es) {
		es.editBoatTypePrompt();
		switch (es.getBoatTypeEvent()) {
		case Sailboat:
			list.get(memberPosition).getBoat(boatPosition)
					.editBoatType(Type.Sailboat);
			break;
		case Motorsailer:
			list.get(memberPosition).getBoat(boatPosition)
					.editBoatType(Type.Motorsailer);
			break;
		case Kayak:
			list.get(memberPosition).getBoat(boatPosition)
					.editBoatType(Type.Kayak);
			break;
		case Other:
			list.get(memberPosition).getBoat(boatPosition)
					.editBoatType(Type.Other);
			break;
		}
		es.confirmPrompt();
	}

	/*
	 * Method for deleting a boat assigned to the selected member. Deletion is done on previously selected boat
	 */
	public void deleteBoat(RegisterList list, EditScreen es) {
		list.get(memberPosition).deleteBoat(boatPosition);
		es.confirmPrompt();
	}
}
