/*
 * Avery Guething 
 * Tyler Gillen 1020
 * Lab 10: March 28
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> intList = new ArrayList<Integer>(); //creates new arraylist
		String s = "";
		
		while (!s.equals("done")) { //while the user does not input done, add value to arrayList
			System.out.print("Please enter value or enter done: ");
			s = sc.next();
			try {
				int x = Integer.parseInt(s);
				intList.add(x);
			} catch (Exception e) {
			}
		}
		sc.close(); //closes scanner when done
		
		int totalSum = 0;
		for (int a = 1; a < intList.size(); a = a + 2) //alternating sums method
			totalSum -= intList.get(a);
		for (int i = 0; i < intList.size(); i = i + 2) { //adds every other
			totalSum += intList.get(i);
		}

		System.out.println("The alternating sum of all elements is: " + totalSum);

	}

}
