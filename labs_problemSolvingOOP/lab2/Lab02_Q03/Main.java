import java.io.FileNotFoundException; //We will learn exceptions later
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException //We will learn exceptions later
	{
		System.out.print("Please input the file pathname: ");

		Scanner scannerObj = new Scanner(System.in);
		String filePathName = scannerObj.nextLine();
		
		Table2dMxSumRowCol t = new Table2dMxSumRowCol(filePathName);

		t.print();
		System.out.println("Maximum row sum: " + t.getRowSumMax());
		
		System.out.println("Maximum col sum: " + t.getColSumMax());

		scannerObj.close();
	}
	
}
