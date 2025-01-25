

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{

		//Start up the system
		Scanner in = new Scanner(System.in); 

		System.out.print("Please enter the filename: ");
		String filepathname = in.next(); 

		PersonnelOffice po = new PersonnelOffice();
		po.loadEmployeeData(filepathname);

		System.out.println("\nTotal count: " + po.getTotal() + " records.\n");
				
		po.report();



		System.out.print("Enter percentage for raising salary: ");
		
		double percentageForRaisingSalary = in.nextDouble();
		po.raiseAllSalaries(percentageForRaisingSalary);

		po.report();
		in.close();
	}
}
