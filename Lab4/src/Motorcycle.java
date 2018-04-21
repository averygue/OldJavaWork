
public class Motorcycle extends Vehicle {

	//constructor that goes to paretn class
	public Motorcycle() {
		super();
	}

	//sets mpg
	public Motorcycle(int mpg) {
		super(2, mpg);
	}

	//specific toString method
	public String toString() {
		String x = "This motorcycle has 4 wheels and gets " + this.getMPG() + " mpg";
		return x;
	}
	
}
