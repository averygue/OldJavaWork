	/*
	 * Avery Guething
	 * COSC 1020 with Professor Gillen
	 * avery.guething@marquette.edu
	 */
public class Triangle extends Shape{ //Triangle subclass

	public Triangle(double a){ 
		super(a); //calls parent class
	}
	public Triangle() {
		super(1); //calls parent class for constructor
	}
	public double getPerimeter(){ 
		return 3*size; //given code
	}

	public double getArea(){
		return size*size*Math.sqrt(3)/4.0; //given code
	}
}

