	/*
	 * Avery Guething
	 * COSC 1020 with Professor Gillen
	 * avery.guething@marquette.edu
	 */
	public class Hexagon extends Shape { // Hexagon subclass
		Hexagon() {
			super(1); //calls parent Shape class
		}

		public Hexagon(double a) {
			super(a); //calls parent class for constructor with double variable type
		}

		public double getArea() { //Hexagon Area
			return size * size * Math.sqrt(3) * 1.5;
		}
		
		public double getPerimeter() { //Hexagon Perimeter 
			return 6 * size;
		}

	}
	
