

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		//Read input file pathname
		Scanner in = new Scanner(System.in); 
		System.out.print("Please enter the filename: ");
		String filepathname = in.next();
		System.out.println();

		//Grab the StatisticsSystem ss and add counters 
		StatisticsSystem ss = StatisticsSystem.getInstance();  
		ss.addCounter(new Counter());


		System.out.print("Enter the area names (e.g. TaiPo YuenLong WongTaiSin KwunTong): ");
		in.nextLine();
		String areaNameLine = in.nextLine();
		Scanner lineStream = new Scanner(areaNameLine);
		while(lineStream.hasNext()){
			ss.addCounter(new AreaCounter(lineStream.next()));
		}
		System.out.println();
		

		int num1, num2;
		do{
			System.out.print("Enter the age groups ('-1 -1' to end): ");
			num1 = in.nextInt();
			num2 = in.nextInt();
			
			if (num1 != -1 && num2 != -1){
				ss.addCounter(new AgeGroupCounter(num1, num2));
			}
		} while(num1 != -1 || num2 != -1);

		//The ss will load file data and tell its counters to count 
		ss.countData(filepathname);		
		
		//The ss will tell its counters to report
		ss.report();
		
		lineStream.close();
		in.close();
	}
}
