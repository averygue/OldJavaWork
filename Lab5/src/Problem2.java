/*
 * Avery Guething
 * Lab 5 Problem 2
 */
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		boolean test = true;
		int number = 0;
		Scanner s = new Scanner(System.in);

		while (test == true) { //while test is true, run following
			
			System.out.print("Enter a whole number: ");
			String input = s.next();
			try {
				if (isInt(input)) { //if integer is number, parse, print and stop loop
					number = Integer.parseInt(input);
					System.out.println("You entered: " + number);
					test = false;
					
				} else { //if not, throw exception, catch, print error, and run again
					throw new InvalidInputException(input);
				}
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}

		}
	}

	public static boolean isInt(String number) { //checks to see if number is int
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
				;
			} else {
				return false;
			}
		}
		return true;
	}
}
