import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {

	public static void main(String [] args) throws FileNotFoundException {	
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname: ");
		String filepathname = in.nextLine();
		
		Scanner inFile = new Scanner(new File(filepathname));
		
		//The first command in the file must be to set the system date 
		//(eg. "startNewDay 03-Jan-2024"); and it cannot be undone
		String cmdLine1 = inFile.nextLine();
		String[] cmdLine1Parts = cmdLine1.split(" ");
		System.out.println("\n> "+cmdLine1);
		SystemDate.createTheInstance(cmdLine1Parts[1]);
		
		while (inFile.hasNext()) {
			try {
				String cmdLine = inFile.nextLine().trim();
				
				//Blank lines exist in data file as separators.  Skip them.
				if (cmdLine.equals("")) continue;  

				System.out.println("\n> "+cmdLine);
				
				//split the words in actionLine => create an array of word strings
				String[] cmdParts = cmdLine.split(" "); 
				
				if (cmdParts[0].equals("register"))
					(new CmdRegister()).execute(cmdParts);
				else if (cmdParts[0].equals("listMembers"))
					(new CmdListMembers()).execute(cmdParts);
				else if (cmdParts[0].equals("startNewDay"))
					(new CmdStartNewDay()).execute(cmdParts);
				else if (cmdParts[0].equals("create"))
					(new CmdCreate()).execute(cmdParts);
				else if (cmdParts[0].equals("arrive"))
					(new CmdArrive()).execute(cmdParts);
				else if (cmdParts[0].equals("listEquipment"))
					(new CmdListEquipment()).execute(cmdParts);
				else if (cmdParts[0].equals("borrow"))
					(new CmdBorrow()).execute(cmdParts);
				else if (cmdParts[0].equals("listMemberStatus"))
					(new CmdListMemberStatus()).execute(cmdParts);
				else if (cmdParts[0].equals("listEquipmentStatus"))
					(new CmdListEquipmentStatus()).execute(cmdParts);
				else if (cmdParts[0].equals("request"))
					(new CmdRequest()).execute(cmdParts);
				else if (cmdParts[0].equals("undo"))
					RecordedCommand.undoOneCommand();
				else if (cmdParts[0].equals("redo"))
					RecordedCommand.redoOneCommand();
				else
					throw new ExWrongCommand();
			} catch (ExWrongCommand e) {
				System.out.println("Unknown command - ignored.");
				System.exit(1);
			}
		}
		inFile.close();
			
		in.close();
	}
}