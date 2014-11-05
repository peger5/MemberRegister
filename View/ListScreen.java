package View;


/*
 * View class responsible for handling the user interface passed by the MemberList controller
 */
public class ListScreen extends Console{
	
	public enum ListEvent{
		Compact, Verbose, Edit, Back
	}
	
	public ListEvent getListEvent(){
		while (true) {
			int c = GetInputChar();
			if (c == 'c') {
			return ListEvent.Compact;
			} else if (c == 'v') {
			return ListEvent.Verbose;
			} else if (c == 'e') {
			return ListEvent.Edit;
			} else if (c == 'b') {
			return ListEvent.Back;
			}
			}
	}
	
	public void showListOptions(){
		System.out.println("Press 'c' for Compact view");
		System.out.println("Press 'v' for Verbose view");
		System.out.println("Press 'e' to edit member");
		System.out.println("press 'b' to go back to main menu");
	}
	
	public void printWall(){
		System.out.print("|");
	}
	
	public void compactViewHeaders(){
		System.out.println("Compact View");
		addFooter();
		System.out.print("|     #|");
		System.out.print(" \tName\t |");
		System.out.println(" Number of boats\t |");
	}
	
	public void addFooter(){
		System.out.println("------------------------------------");
	}
	
	public void verboseViewHeaders(){
		System.out.println("Verbose View");
		System.out.print("|     #|");
		System.out.print(" Name\t |");
		System.out.print(" Personal number\t |");
		System.out.print(" Number of boats | ");
		System.out.println(" Boat information");
	}

}
