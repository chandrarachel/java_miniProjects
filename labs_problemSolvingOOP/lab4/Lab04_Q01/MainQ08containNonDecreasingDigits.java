import java.util.*;

public class MainQ08containNonDecreasingDigits
{
	
	// Determine whether integer x contains non-decreasing digits (eg. 1234, 14789, 224466)
	//i.e., whether the sequence of digits is "sorted" in ascending order.
	static boolean containNonDecreasingDigits(int x)
	{	
		if(x<10){
			return true;
		} else{
			int r1 = x%10; // rightmost
			int r2 = (x/10)%10; // 2nd rightmost
			boolean m1 = containNonDecreasingDigits(x/10);
			if(r2>r1){
				return false;
			} else{
				return m1;
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			if (containNonDecreasingDigits(x)) 
				System.out.println("true");
			else
				System.out.println("false");
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}
