package Controller;

/*
 * Controller class with the highest responsibility. Calls all other controller classes
 */
public class MainMenu {

	private View.StartScreen s = new View.StartScreen();
	private View.AddMemberScreen adds = new View.AddMemberScreen();
	private View.ListScreen ls = new View.ListScreen();
	private View.SearchScreen ss = new View.SearchScreen();
	private View.EditScreen es = new View.EditScreen();
	private View.ExportImportScreen eis = new View.ExportImportScreen();

	public void menuOptions(Model.RegisterList list) {

		s.ShowWelcomeMessage();
		s.ShowStartInstructions();

		switch (s.getStartEvent()) {
		case List:
			Controller.MemberList mmbl = new Controller.MemberList();

			mmbl.printCompact(list, ls);

			switch (ls.getListEvent()) {
			case Compact:
				mmbl.printCompact(list, ls);
				mmbl.listMenu(list, ls);
				break;
			case Verbose:
				mmbl.printVerbose(list, ls);
				mmbl.listMenu(list, ls);
				break;
			case Edit:
				mmbl.editMember(list, es);
				this.menuOptions(list);
				break;
			case Back:
				this.menuOptions(list);

				break;
			}

			break;
		case Add:
			Controller.AddMember addm = new Controller.AddMember();
			addm.addMember(list, adds);
			this.menuOptions(list);
			break;
		case Search:
			Controller.SearchMember smb = new Controller.SearchMember();
			smb.search(list, ss);
			if (ss.pressEnterToContinue()) {
				this.menuOptions(list);
			}
			break;
		case ExportImport:
			Controller.ExportImportRegister eir = new Controller.ExportImportRegister();
			eis.exportOrImportPrompt();
			switch (eis.getEIEvent()) {
			case Export:
				eir.writeCSVFile(list, eis);
				this.menuOptions(list);
				break;
			case Import:
				eir.readCSVFile(list, eis);
				this.menuOptions(list);
				break;
			}

			break;
		case Quit:
			System.exit(-1);

		}

	}

}
