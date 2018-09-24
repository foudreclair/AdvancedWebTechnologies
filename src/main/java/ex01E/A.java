package ex01E;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
class A {
	int x = 0;
	protected static Logger log = Logger.getLogger(A.class);
	static final String path = "src/resources/log4j.properties";

	void m() {
		PropertyConfigurator.configure(path);
		log.info("Je suis dans la méthode m d'une instance de A");
	}
	


}

class B extends A {
	int x = 1;

	void m() {
		log.info("Je suis dans la méthode m d'une instance de B");
	}
}

class C extends B {
	int x = 2;
	int a = 4;

	void m() {
		log.info("Je suis dans la méthode m d'une instance de C");
	}

	void test() {
		a = super.x;
		log.info(a);
		// a = super.super.x;
		a = ((B) this).x;
		a = ((A) this).x;
		super.m();
		// super.super.m();
		((B) this).m();
		// (1)
	}

}