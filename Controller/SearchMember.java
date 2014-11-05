package Controller;

import java.util.Scanner;
import Model.RegisterList;

/*
 * Controller class for looking up a member based on personal number
 */
public class SearchMember {

	private String searchQuery;
	Scanner scan = new Scanner(System.in);

	public void search(RegisterList list, View.SearchScreen ss) {

		ss.searchPrompt();
		searchQuery = scan.nextLine();
		searchQuery = scan.nextLine();
		
		
		for (int i = 0; i < list.size(); i++) {
			if (searchQuery.equals(list.get(i).getPersonalNumber())) {
				
				ss.printMemberNumber(list.get(i));
					ss.printLineBreak();
				ss.printName(list.get(i));
					ss.printLineBreak();
				ss.printMemberPIN(list.get(i));
					ss.printLineBreak();
				ss.printBoatCount(list.get(i));
					ss.printLineBreak();
				ss.printBoats(list.get(i));

			}
			else if(i==list.size()-1) ss.searchError();
				
		}
		ss.pressEnterPrompt();

	}

}
