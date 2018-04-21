	/*
	 * Avery Guething
	 * Homework 1: Shape & Subclasses. The Perry Assignment
	 * COSC 1020 with Professor Gillen
	 * avery.guething@marquette.edu
	 */
public class SupplyEstimator{
		static Shape[] shapeList = { //changed Triangle array to Shape array with new shapes 
		   new Triangle(4.0),
		   new Hexagon(2.5),
		   new Square(5),
		   new Square(10.0),
		};

		public static void main(String[] args){
			double perimeter = 0.0; //given Code
			double area = 0.0;
			
			for (int i=0; i<shapeList.length; i++){ 
				perimeter += shapeList[i].getPerimeter();
				area += shapeList[i].getArea();
			}
			
			for (int i = 0; i < shapeList.length; i++) { //loop that prints each shape with size using .toString
				System.out.println(shapeList[i].toString()); 
			}
			System.out.println("the total perimeter is "+perimeter);
			System.out.println("and the total area is "+area);
		}
	}

