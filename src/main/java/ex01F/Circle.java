package ex01F;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Circle {
	protected static Logger log = Logger.getLogger(Circle.class);
	int x;
	int y;
	int radius;
	public static final String path = "src/resources/log4j.properties";

	public Circle(int x, int y, int radius) {
		PropertyConfigurator.configure(path);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public String toString() {
		return (String.format("Circle with center (%d,%d) and radius %d(Perimter is %,.2f)", this.x, this.y,
				this.radius, (2 * java.lang.Math.PI * this.radius)));
	}
}