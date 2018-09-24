package ex01D;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ex01C.Log4jBasics;

public class C {
	static void method1(int i, StringBuffer s) {
		i++;
		s.append("d");
	}

	protected static Logger log = Logger.getLogger(Log4jBasics.class);
	static final String path = "src/resources/log4j.properties";

	public static void main(String[] args) {

		PropertyConfigurator.configure(path);
		int i = 0;
		StringBuffer s = new StringBuffer("abc");
		method1(i, s);
		log.info("i = " + i + " AND s = " + s);
	}
}