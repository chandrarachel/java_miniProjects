import java.util.*;
import java.io.*;

public class Main{
	
    public static void main(String [] args) throws FileNotFoundException
	{	
		System.out.print("Please input the file pathname: ");
		Scanner in = new Scanner(System.in);
		String filepathname = in.nextLine();
		
		Scanner inFile = new Scanner(new File(filepathname));
		int studentsNum = inFile.nextInt();
		System.out.println("Total number of students: " + studentsNum);


		System.out.print("Enter the number of teams: ");
		int teamsNum = in.nextInt();

		if (studentsNum % teamsNum != 0) {
			System.out.println("Wrong input - It is not a factor of 16.");
		} else {
			Student[] students; 
			students = Student.createStudentListFromFile(filepathname);


			Team[] teams;
			teams = createTeams(students, studentsNum, teamsNum);
			
			System.out.println("\nGrouping result: ");
			for (int i=0; i<teamsNum; i++) {
				System.out.println(teams[i].toString());
			}
			
			String[] taskNamesInput = new String[teamsNum];
			System.out.print("\nEnter " + teamsNum + " task names (eg. \"Lab05 Lab06 Lab07 ..\"): ");
			for (int i=0; i<teamsNum; i++) {
				taskNamesInput[i] = in.next();
			}

			Assignment[] assignments;
			assignments = decideTasks(teams, in, teamsNum, taskNamesInput);
			
			System.out.println("\nSorted listing by tasks: ");
			for (int i=0; i<teamsNum; i++) {
				Assignment.printTaskTeam(taskNamesInput[i], assignments);
			}
		}
		
		in.close();
		inFile.close();
	}

	
	private static Team[] createTeams(Student[] students, int studentsNum, int teamsNum) 
	{
		Team[] result; 
		result = new Team[teamsNum]; 
		char teamLabel = 'A';
		int memberStartRange = 0;
		int memberPerTeam = studentsNum/teamsNum;

		for (int i=0; i<teamsNum; i++) {
			result[i]=new Team("Team " + teamLabel, Arrays.copyOfRange(students, memberStartRange,(memberStartRange+memberPerTeam)));
			teamLabel = (char) (teamLabel + 1);
			memberStartRange += memberPerTeam;
		}
		// result[0]=new Team("Team A", Arrays.copyOfRange(students, 0,6));
		// result[1]=new Team("Team B", Arrays.copyOfRange(students, 6, 12));
		// result[2]=new Team("Team C", Arrays.copyOfRange(students, 12, 18));
		// result[3]=new Team("Team D", Arrays.copyOfRange(students, 18, 24));
		// result[4]=new Team("Team E", Arrays.copyOfRange(students, 24, 30));
		return result;
	}

	private static Assignment[] decideTasks(Team[] teams, Scanner in, int teamsNum, String[] taskNamesInput)
	{
		Assignment[] assignments;
		assignments = new Assignment[teamsNum];
		
		System.out.print("\nEnter tasks for the teams (");
		for (int i=0; i<teamsNum; i++) {
			System.out.print(taskNamesInput[i]);
			if(i<teamsNum-1)
				System.out.print(",");
		}
		System.out.print("): ");
		System.out.println();
		for (int i=0; i<teamsNum; i++)
		{
			System.out.print(teams[i].getName()+ ": ");
			String taskName = in.next();
			assignments[i] = new Assignment(teams[i], new Task(taskName));
		}
		return assignments;
	}
}