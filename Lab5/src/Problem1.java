/*
 * Avery Guething
 * Lab 5: Part 1
 */
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double number = 0;

		System.out.print("Enter a number: "); // asks for number and saves input as string
		String input = s.next();

		try {

			if (isNumber(input)) { // if it is a number, parse, and print square
				number = Double.parseDouble(input);
				System.out.println("The square of the number is: " + number * number);

			} else //if not throw exception, catch, and print error message
				throw new InvalidInputException();
		} catch (InvalidInputException e) {
			System.out.print(e.getMessage());
		}

	}

	//tests to see if the string is a number
	public static boolean isNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) >= '0' && number.charAt(i) <= '9' || number.charAt(i) == '.') {
				;
			} else {
				return false;
			}
		}
		return true;
	}
}
