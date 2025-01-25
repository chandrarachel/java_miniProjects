class P {
	int k;
	public P() {k=1;}
	public void triple() {k=3*k;}
	public void print() {
		triple();
		System.out.println("In P: "+k);
	}
}

class Q extends P {
	int k;
	public Q() {k=10;}
	public void triple() {k=3*super.k;}
	public void print() {
		this.triple();
		System.out.println("In Q: "+k);
	}
}

class R extends Q {
	int k;
	public R() {k=100;}
	public void triple() {k=3*k;}
	public void print() {
		super.print();
		System.out.println("In R: "+k);
	}
}

public class Main_Lab07_Q6 
{
	public static void main(String[] args) 
	{
		P x1=new P(); 
		x1.print();
		
		Q x2=new Q(); 
		..
	}
}
