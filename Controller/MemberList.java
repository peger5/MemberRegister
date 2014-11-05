package Controller;

import Model.RegisterList;
import View.EditScreen;
import View.ListScreen;

/*
 * Controller class responsible for displaying the register and calling Edit options
 */
public class MemberList {

	/*
	 * Method for showing the register in compact view (Name, member number and
	 * boat count)
	 */
	public void printCompact(RegisterList list, ListScreen ls) {

		ls.compactViewHeaders();

		for (int i = 0; i < list.size(); i++) {
			ls.printWall();
			ls.printMemberNumber(list.get(i));
			ls.printWall();
			ls.printName(list.get(i));
			ls.printWall();
			ls.printBoatCount(list.get(i));
			ls.printWall();
			ls.printLineBreak();
		}
		ls.addFooter();
		ls.showListOptions();

	}

	/*
	 * Method for showing the register in verbose view (personal number, name,
	 * member number, boat count and boat information
	 */
	public void printVerbose(RegisterList list, ListScreen ls) {

		ls.verboseViewHeaders();

		for (int i = 0; i < list.size(); i++) {
			ls.printWall();
			ls.printMemberNumber(list.get(i));
			ls.printWall();
			ls.printName(list.get(i));
			ls.printWall();
			ls.printMemberPIN(list.get(i));
			ls.printWall();
			ls.printBoatCount(list.get(i));
			ls.printWall();
			ls.printBoats(list.get(i));
			ls.printWall();
			ls.printLineBreak();
		}
		ls.addFooter();
		ls.showListOptions();
	}

	/*
	 * Method responsible for calling the edit controller
	 */
	public void editMember(RegisterList list, EditScreen es) {
		EditMember edit = new EditMember();
		edit.selectMember(list, es);
		switch (es.getEditEvent()) {
		case Name:
			edit.editMemberName(list, es);
			break;
		case PIN:
			edit.editPersonalNumber(list, es);
			break;
		case AddBoat:
			edit.addBoatToMember(list, es);
			break;
		case EditBoat:
			edit.boatList(list, es);
			edit.selectBoat(list, es);
			edit.boatEditMenu(list, es);
			break;
		case Delete:
			edit.deleteMember(list, es);
			break;
		}

	}
	
	/*
	 * Method for registering user input regarding the register options
	 */
	public void listMenu(RegisterList list, ListScreen ls) {

		switch (ls.getListEvent()) {
		case Compact:
			this.printCompact(list, ls);
			listMenu(list, ls);
			break;
		case Verbose:
			this.printVerbose(list, ls);
			listMenu(list, ls);
			break;
		case Edit:
			EditScreen es = new EditScreen();
			this.editMember(list, es);
			break;

		case Back:
			MainMenu m = new MainMenu();
			m.menuOptions(list);
			break;
		}
	}

}