import java.util.*;
import java.io.*;

public class Main{

	public static void main(String [] args) throws FileNotFoundException
	{	
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname of each team: ");
		String filepathname = in.nextLine();


		ArrayList<Team> teamArr;
		teamArr = new ArrayList<Team>();

		Scanner inString = new Scanner(filepathname);
		while(inString.hasNext()){
			Team t = new Team(inString.next());
			teamArr.add(t);
		}

		System.out.println("Listing of teams: ");
		for(int i=0; i<teamArr.size(); i++){
			System.out.println("[Team " + (i+1) + "] " + teamArr.get(i).getMemberCount() + " members: " + teamArr.get(i).getStringOfAllMembers());
		}
		
		System.out.print("Enter a name for searching: ");
		String name = in.nextLine();

		System.out.print("Result: ");
		
		boolean isNameAvailable = false;
		for(int i=0; i<teamArr.size(); i++){
			isNameAvailable = teamArr.get(i).searchName(name);
			if(isNameAvailable){
				teamArr.get(i).getStringOfSearchName(name);
				System.out.print(" in Team " + (i+1));
				break;
			}
		}
		if(!isNameAvailable){
			System.out.print("Not Found");
		}

		System.out.println();
		
		in.close();
		inString.close();
	}
}
