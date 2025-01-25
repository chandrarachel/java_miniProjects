class A {
	public int value = 1;
}

class B extends A {
	public int value = 2;
}

class Main {
	public static void main(String[] args) {
		A x = new B();
		System.out.println(x.value); // output: ____
		System.out.println(((B) x).value); // output: ____
	}
}
