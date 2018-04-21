
public class Driver {

	public static void main(String[] args) {

		//creates cars, motorcycles, and one vehicle
		Car carOne = new Car(45);
		Car carTwo = new Car(45);
		Motorcycle motorOne = new Motorcycle(15);
		Motorcycle motorTwo = new Motorcycle(45);
		Vehicle vehicle1 = new Vehicle(3,70);

		//prints out info
		System.out.println("Car One Info: " + carOne.toString());
		System.out.println("Car Two Info: " + carTwo.toString());
		System.out.println();
		System.out.println("MotorCycle One Info: " + motorOne.toString());
		System.out.println("MotorCycle One Info: " + motorTwo.toString());
		System.out.println();
		
		//uses .equals to check to see if they are equal
		if (carOne.equals(carTwo)) {
			System.out.println("Car One IS THE SAME AS Car Two");
		}
		else {
			System.out.println("Car One IS NOT THE SAME AS Car Two");
		}
		
		if (motorOne.equals(motorTwo)) {
			System.out.println("Motorcycle One IS THE SAME AS Motorcycle Two");
		}
		else {
			System.out.println("Motorcycle One IS NOT THE SAME AS Motorcycle Two");
		}
		System.out.println();
		System.out.println("Vehicle Info: " + vehicle1.toString()); //prints out vehicle info
		
	}
}
