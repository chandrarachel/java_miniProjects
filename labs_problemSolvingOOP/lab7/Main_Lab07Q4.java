abstract class A {
	public abstract void fi();
}

class B extends A {
	public void fi() {}
	public void fj() {}
}

public class Main_Lab07Q4 
{
	public static void main(String[] args) 
	{
		A a;			//line 1
		a = new A(); 	//line 2 
		a.fi(); 		//line 3
		
		B b;			//line 4
		b = new B();	//line 5
		b.fj();			//line 6

		B b1 = a; 		//line 7 
		A a1 = b;        //line 8
        b.fj();        //line 9
        a1.fj();         //line 10
	}
}
