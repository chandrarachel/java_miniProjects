import java.util.*;
import java.io.*;

public class Main{
	
    public static void main(String [] args) throws FileNotFoundException
	{	
		System.out.print("Please input the file pathname: ");
		Scanner in = new Scanner(System.in);
		String filepathname = in.nextLine();
		
		Student[] students; 
		students = Student.createStudentListFromFile(filepathname);
		
		Team[] teams;
		teams = createTeams(students);
		
		System.out.println("\nGrouping result: ");				
		System.out.println(teams[0].toString());
		System.out.println(teams[1].toString());
		System.out.println(teams[2].toString());
		System.out.println(teams[3].toString());
		System.out.println(teams[4].toString());
		
		Assignment[] assignments;
		assignments = decideTasks(teams, in);
		
		System.out.println("\nSorted listing by tasks: ");
		Assignment.printTaskTeam("Lab05", assignments);
		Assignment.printTaskTeam("Lab06", assignments);
		Assignment.printTaskTeam("Lab07", assignments);
		Assignment.printTaskTeam("Lab08", assignments);
		Assignment.printTaskTeam("Lab09", assignments);
		
		in.close();
	}

	private static Team[] createTeams(Student[] students) 
	{
		Team[] result; 
		result = new Team[5]; 
		
	
		result[0]=new Team("Team A", Arrays.copyOfRange(students, 0,6));
		result[1]=new Team("Team B", Arrays.copyOfRange(students, 6, 12));
		result[2]=new Team("Team C", Arrays.copyOfRange(students, 12, 18));
		result[3]=new Team("Team D", Arrays.copyOfRange(students, 18, 24));
		result[4]=new Team("Team E", Arrays.copyOfRange(students, 24, 30));
		return result;
	}

	private static Assignment[] decideTasks(Team[] teams, Scanner in)
	{
		Assignment[] assignments;
		assignments = new Assignment[5];
				
		System.out.println("\nEnter tasks for the teams (Lab05,Lab06,Lab07,Lab08,Lab09): ");
		for (int i=0; i<5; i++)
		{
			System.out.print(teams[i].getName()+ ": ");
			String taskName = in.next();
			assignments[i] = new Assignment(teams[i], new Task(taskName));
		}
		return assignments;
	}
}