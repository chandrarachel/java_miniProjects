import java.io.*;
import java.util.Scanner;

public class Day {
	
	private int year;
	private int month;
	private int day;
	
	//Constructor
	public Day(int y, int m, int d) {
		this.year=y;
		this.month=m;
		this.day=d;		
	}

    public int getYear()  {return year;}
    public int getMonth() {return month;}
    public int getDay()   {return day;}
	
	// check if a given year is a leap year
	static public boolean isLeapYear(int y)
	{
		if (y%400==0)
			return true;
		else if (y%100==0)
			return false;
		else if (y%4==0)
			return true;
		else
			return false;
	}
	
	// check if y,m,d valid
	static public boolean valid(int y, int m, int d)
	{
		if (m<1 || m>12 || d<1) return false;
		switch(m){
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
					 return d<=31; 
			case 4: case 6: case 9: case 11:
					 return d<=30; 
			case 2:
					 if (isLeapYear(y))
						 return d<=29; 
					 else
						 return d<=28; 
		}
		return false;
	}

	public boolean valid()
	{
		return valid(year, month, day);
	}

	// Return a string for the day like dd MMM yyyy
	public String toString() {
		
		final String[] MonthNames = {
				"Jan", "Feb", "Mar", "Apr",
				"May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec"};
		
		return day+" "+ MonthNames[month-1] + " "+ year;
	}

    public static Day[] createDayListFromFile(String filepathname) throws FileNotFoundException
{
	//Create a scanner object for reading file
	Scanner inFile = new Scanner(new File(filepathname));

	int count=inFile.nextInt();

	Day[] result; // set up an array of Day objects for returning the result
	result = new Day[count];
		
	for (int i=0; i<count; i++) //Loop a number of times based on the count
	{
		int y, m, d;
		d=inFile.nextInt();
		m=inFile.nextInt();
		y=inFile.nextInt();

		result[i] = new Day(y,m,d);
	}
		
	inFile.close();
	return result;
    }
}