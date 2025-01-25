import java.util.*;
import java.io.*;

public class Main{

	public static void main(String [] args) throws FileNotFoundException
	{	
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please input the file pathname: ");
		String filepathname = in.nextLine();
		
		Team t = new Team(filepathname);
		
		System.out.printf(
			"\nThere are %d members in the team: %s\n\n", 
			t.getMemberCount(), t.getStringOfAllMembers()); //call Team methods to get the results: getMemberCount, getStringOfAllMembers
		
		System.out.print("Enter new leader: ");
		String name = in.nextLine();
		t.changeLeader(name);

		System.out.print("Result: " + t.getStringOfAllMembers());
		System.out.println();
		
		in.close();
	}
}
