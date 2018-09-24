package ex01E;

class A {
	int x = 0;

	void m() {
		System.out.println("Je suis dans la méthode m d'une instance de A");
	}

}

class B extends A {
	int x = 1;

	void m() {
		System.out.println("Je suis dans la méthode m d'une instance de B");
	}
}

class C extends B {
	int x = 2;
	int a = 4;

	void m() {
		System.out.println("Je suis dans la méthode m d'une instance de C");
	}

	void test() {
		a = super.x;
		System.out.println(a);
		// a = super.super.x;
		a = ((B) this).x;
		a = ((A) this).x;
		super.m();
		// super.super.m();
		((B) this).m();
		// (1)
	}

}