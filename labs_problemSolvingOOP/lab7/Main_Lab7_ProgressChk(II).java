class A {
	public void print() {System.out.println("A"); }
}

class B extends A {
	public void print() { System.out.println("B"); }
	public void printSuper() { super.print(); }
}

class C extends B {
}

class Main {

	public static void main(String[] args) {
		A a = new B();
		a.print(); // output: _________

		(new B()).printSuper(); // output: _________
		(new C()).printSuper(); // output (Many students think 'B'): _________
	}
}
