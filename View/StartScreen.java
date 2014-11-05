package View;

/*
 * View class responsible for the user interface by the MainMenu controller
 */
public class StartScreen extends Console{

	public enum StartEvent{
		List, Add, Search, ExportImport, Quit
	}

	
	public void ShowWelcomeMessage(){
		System.out.println("Welcome to the members register.");
	}
	
	public void ShowStartInstructions(){
		System.out.println("1. List members");
		System.out.println("2. Add member");
		System.out.println("3. Search a member");
		System.out.println("4. Export/Import");
		System.out.println("Press Q to quit.");
	}
	
	public StartEvent getStartEvent() {
		while (true) {
			int c = GetInputChar();
			if (c == '1') {
			return StartEvent.List;
			} else if (c == '2') {
			return StartEvent.Add;
			} else if (c == '3') {
			return StartEvent.Search;
			} else if (c == '4') {
			return StartEvent.ExportImport;
			} else if(c == 'q'){
			return StartEvent.Quit;
			}
			}
	}

}
