	/*
	 * Avery Guething
	 * COSC 1020 with Professor Gillen
	 * avery.guething@marquette.edu
	 */
public class Shape {
	// instance variables
	public double size;
	
	public Shape() { //default constructor 
		size = 1;
	}
	
	public Shape(double a) { //sets Size
		size = a;
	}
	
	public double getArea() { //default Area
		return 1;
	}
	
	public double getPerimeter() { //default Perimeter
		return 1;
	}
	
	public String toString() { //to string method using guideline from assignment
		String x = "A " + getClass().getName() + " of size " + size;
		return x;
	}
	
}
