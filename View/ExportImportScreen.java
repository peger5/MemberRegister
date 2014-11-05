package View;


/*
 * View class responsible for handling the user interface covered by the ExportImportRegister controller
 */
public class ExportImportScreen extends Console{
	
	public enum EIEvent{
		Export,Import
	}
	
	public EIEvent getEIEvent(){
		while (true) {
			int c = GetInputChar();
			if (c == 'e') {
			return EIEvent.Export;
			} else if (c == 'i') {
			return EIEvent.Import;
			} 
			}
	}
	
	public void filenamePrompt(){
		System.out.print("Enter file destination: ");
	}
	
	public void exportOrImportPrompt(){
		System.out.println("Press 'e' for exporting the register to a .txt file");
		System.out.println("Press 'i' to import a register from a .txt file");
	}

}
