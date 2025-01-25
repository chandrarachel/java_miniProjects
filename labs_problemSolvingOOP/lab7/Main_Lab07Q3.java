abstract class A {
	public int i;
	protected int j;
	private int k;
	
	public static void print1() {}	
	public void print2() {}	
}

class B extends A 
{
	protected static void print1() //line 1
	{
		System.out.println(i); //line 2
		System.out.println(j); //line 3
		System.out.println(k); //line 4 
	}
	
	protected void print2() //line 5  
	{
		System.out.println(i); //line 6
        System.out.println(j); //line 7
        System.out.println(k); //line 8
	}	
}

public class Main_Lab07Q3 
{
	public static void main(String[] args) 
	{
		
	}
}
