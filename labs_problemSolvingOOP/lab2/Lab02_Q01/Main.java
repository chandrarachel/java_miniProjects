
public class Main {

	public static final int WIDTH = 12;
	public static final int HEIGHT = 8;

	public static void count_0_to_100(int[][] A)
	{
		int count = 0;
		
		for(int y = 0; y < HEIGHT; y++)
		{
			for (int x = 0; x < WIDTH; x++)
				if(0 <= A[y][x] && A[y][x] <= 100)		
	                count+=1;	 
		}
		
		System.out.print("The count is: " + count);
	}
	
	public static void main(String[] args) 
	{
		int[][] values = new int[HEIGHT][WIDTH];
		int x, y;
		
		//create some data in values[][]
		for(y = 0 ; y < HEIGHT; y++)
			for(x = 0 ; x < WIDTH; x++)
				values[y][x] = ((x+13)*(y+29))%413-139;
		
		//display contents in values[][]
		for(y = 0 ; y < HEIGHT; y++)
		{
			for(x = 0 ; x < WIDTH ; x++)
				System.out.printf("%5d", values[y][x]); //width = 5, right aligned, decimal
			System.out.println();
		}
		
		//call the function count_0_to_100 for counting(0...100)
		count_0_to_100(values); 
	}
}
