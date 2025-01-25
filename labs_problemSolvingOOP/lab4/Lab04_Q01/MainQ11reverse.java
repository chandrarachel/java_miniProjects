import java.util.*;

public class MainQ11reverse
{
	
	static int tail(int x)
	{	
		if(x<10){
			return 0;
		}
		return x%10 + 10*tail(x/10);
	}

	static int leftMostDigit(int x)
	{	
		if(x<10){
			return x;
		} else{
			int m1 = leftMostDigit(x/10);
			return m1;
		}
	}	
	
	// 1234=>4321 
	static int reverse(int x)
	{	
		if(x<10){
			return x;
		}
		int a = leftMostDigit(x);
		int b = tail(x);
		return a+10*reverse(b);
	}


	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int x;
		System.out.print("input x (-1 to end) : "); x=s.nextInt();

		while (x!=-1)
		{
			System.out.println(reverse(x));
			
			System.out.print("input x (-1 to end) : "); x=s.nextInt();
		}

		s.close();
	}
}
