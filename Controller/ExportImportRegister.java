package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import Model.Member;
import Model.Boat.Type;
import View.ExportImportScreen;

/*
 * Controller class responsible for exporting and importing the register to/from a text file
 */
public class ExportImportRegister {

	/*
	 * Method for transferring the register to .txt file. The user must specify
	 * the .txt extension in the path location
	 */
	public void writeCSVFile(Model.RegisterList list, ExportImportScreen eis) {
		Scanner scan = new Scanner(System.in);
		eis.filenamePrompt();
		String filepath = scan.nextLine();
		filepath = scan.nextLine();
		try {
			FileWriter fstream = new FileWriter(filepath);
			BufferedWriter writer = new BufferedWriter(fstream);

			for (Member o : list.getList()) {
				writer.write(o.getMemberNumber() + ",");
				writer.write(o.getName() + ",");
				writer.write(o.getPersonalNumber() + ",");
				writer.write(o.getBoatListStr());
				writer.newLine();
			}
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		eis.confirmPrompt();
	}

	/*
	 * Method for reading a .txt file and populating the current list. Adding is
	 * done considering where the separation sign - , is placed.
	 */
	public void readCSVFile(Model.RegisterList list, ExportImportScreen eis) {
		Scanner scan = new Scanner(System.in);
		eis.filenamePrompt();
		String filepath = scan.nextLine();
		filepath = scan.nextLine();

		try {

			BufferedReader buff = new BufferedReader(new FileReader(filepath));
			String line = buff.readLine();

			while (line != null && line.length() != 0) {
				String[] itemArray = line.split(",");
				Member a_member = new Member(itemArray[1], itemArray[2], list);
				a_member.setMemberNumber(Integer.valueOf(itemArray[0]));

				for (int i = 3; i < itemArray.length; i = i + 2) {
					if (itemArray[i].equals("Sailboat"))
						a_member.addBoat(Type.Sailboat,
								Double.valueOf(itemArray[i + 1]));
					else if (itemArray[i].equals("Kayak"))
						a_member.addBoat(Type.Kayak,
								Double.valueOf(itemArray[i + 1]));
					else if (itemArray[i].equals("Motorsailer"))
						a_member.addBoat(Type.Motorsailer,
								Double.valueOf(itemArray[i + 1]));
					else if (itemArray[i].equals("Other"))
						a_member.addBoat(Type.Other,
								Double.valueOf(itemArray[i + 1]));
				}
				list.add(a_member);
				line = buff.readLine();
			}
			buff.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		eis.confirmPrompt();

	}

}
