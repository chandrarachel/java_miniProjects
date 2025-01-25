import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner in = new Scanner(System.in); //create a scanner object for keyboard input

		System.out.print("Please enter the filename: ");
		String filepathname = in.next(); //Read user input: in.next();
		
		Day[] days= Day.createDayListFromFile(filepathname);
		
		System.out.println("\nValid dates: ");
		for (int i=0; i<days.length; i++)
			if (days[i].valid())
				System.out.println(days[i].toString());
		
		System.out.println("\nInvalid dates: ");
        for (int j=0; j<days.length; j++)
			if (!days[j].valid()) {
                System.out.println(
                    days[j].getDay() + "/" +
                    days[j].getMonth() + "/" +
                    days[j].getYear()
                ); 
            }

		in.close();
	}
}