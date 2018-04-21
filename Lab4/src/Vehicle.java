/*
 * Avery Guething
 * Lab 4: Inheritance
 * Feb. 7, 2017
 */

//parent class
public class Vehicle {
	private int noWheels;
	private int mpg;

	//default constructor
	public Vehicle() {
		noWheels = 0;
		mpg = 0;
	}

	//constructor for two variables
	public Vehicle(int wheels, int miles) {
		noWheels = wheels;
		mpg = miles;
	}

	//accessor and mutator methods
	public int getNoWHeels() {
		return noWheels;
	}

	public int getMPG() {
		return mpg;
	}
	
	public void setMPG(int MPG) {
		mpg = MPG;
	}
	
	public void setNoWheels(int wheels) {
		noWheels = wheels;
	}

	//toString method
	public String toString() {
		String x = "This vehicle has " + noWheels + " wheels and gets " + mpg + " mpg";
		return x;
	}

	//checks to see if the two vehicles are equal
	public boolean equals(Vehicle v) {
		if (this.mpg == v.mpg && this.noWheels == v.noWheels) {
			return true;
		} else {
			return false;
		}
	}
}
