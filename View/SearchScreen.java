package View;

/*
 * View class responsible for the user interface used by the SearchMember controller
 */
public class SearchScreen extends Console{
	
	public void searchPrompt(){
		System.out.print("Enter personal number of member: ");
	}
	
	public void searchError(){
		System.out.println("No match.");
	}
	
	public void pressEnterPrompt(){
		System.out.println("\nPress 'Enter' to go back to the Main Menu");
		}
	

}
