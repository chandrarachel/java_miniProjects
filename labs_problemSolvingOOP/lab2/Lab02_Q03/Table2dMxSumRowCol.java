import java.io.*;
import java.util.*;

public class Table2dMxSumRowCol 
{

	private int[][] nums;
	
	//Constructor
	public Table2dMxSumRowCol(String filepathname) throws FileNotFoundException //learn exceptions later
	{
		nums = new int[10][10];
		
		Scanner inFile;
		inFile = new Scanner(new File(filepathname));
		
		while (inFile.hasNext())
		{
			int row, col, value;
			row = inFile.nextInt();
			col = inFile.nextInt();
			value = inFile.nextInt();
			nums[row][col] = value;
		}

		inFile.close();
	}

	public void print() {

		for (int row=0; row<10; row++) 
		{
			for (int col=0; col<10; col++)
			{
				System.out.print("\t"+nums[row][col]); //separated by tabs
			}
			System.out.println();
		}
	}
	
	//Return the maximum sum among the rows
	public int getRowSumMax(){
		int max = 0;

		for (int r=0; r<10; r++){
			int sum = 0;

			for (int c=0; c<10; c++){
				sum+=nums[r][c];
			}

			if (sum>max)
				max = sum;
		}
		return max;
	}

	public int getColSumMax(){
		int max = 0;

		for (int c=0; c<10; c++){
			int sum = 0;

			for (int r=0; r<10; r++){
				sum+=nums[r][c];
			}

			if (sum>max)
				max = sum;
		}
		return max;
	}
	
}
