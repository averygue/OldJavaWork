/* 
 * Avery Guething
 * Feb. 14: Exception Lab
 * Tyler Gillen CS 1020
 */
public class InvalidInputException extends Exception {
	
	public InvalidInputException() { //default constructor
		super("Invalid Input!");
	}

	public InvalidInputException(String invalidNumber) { //constructor with invalid input
		super("You provided " + invalidNumber + " which is not a valid input." );
	}
}
