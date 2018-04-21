	/*
	 * Avery Guething
	 * COSC 1020 with Professor Gillen
	 * avery.guething@marquette.edu
	 */
public class Square extends Shape{
	public Square() { 
		super(1); //calls parent class for constructor with size of 1
	}

	public Square(double a) {
		super(a); //calls
	}

	public double getArea() {
		return size * size; //gets area for square
	}
	
	public double getPerimeter() {
		return size * 4; //gets perimeter for square
	}

}
