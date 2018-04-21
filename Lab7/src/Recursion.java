/*
 * Avery Guething
 * Lab7: Recursion
 * Feb 28, 2016
 * Tyler Gillen 1020
 */
public class Recursion {

	//fibonacci recursion call
	public static long Fib(int x) {
		if (x == 1 || x == 2) { //base case
			return 1;
		} else
			return Fib(x - 1) + Fib(x - 2);
	}

	public static int countLetter(String s, char c) {
		if (s.length() == 0) { //base case
			return 0;
		}
		else if (s.charAt(0) == c) { //recursively call the shorter string
			
			return 1 + countLetter(s.substring(1),c);
		}
		else {
			return countLetter(s.substring(1),c);
		}
		
		
		
		
	}
	//testing each method
	public static void main(String[] args) { 
		System.out.println(Fib(25));
		System.out.println(countLetter("Hello",'l'));

	}

}
