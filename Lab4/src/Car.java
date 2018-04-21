
public class Car extends Vehicle{

	//goes to parent class
	public Car() {
		super();
	}
	
	//sets mpg
	public Car(int mpg) {
		super(4, mpg);
	}

	//specific toString method that overrides 
	public String toString() {
		String x = "This car has 4 wheels and gets " + this.getMPG() + " mpg";
		return x;
	}
}
