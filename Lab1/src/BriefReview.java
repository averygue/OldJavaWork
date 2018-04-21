/*
 * Avery Guething
 * Lab 1: A brief Review
 * January 17, 2017
 * avery.guething@marquette.edu
 */
import java.util.Scanner;
public class BriefReview {

	public static void main(String[] args) { //part 1
	System.out.print("Enter a positive number: ");
	Scanner s = new Scanner(System.in);
	int x = s.nextInt();
	System.out.println("For loop:");
	for(int i = 1; i < x; i++) {
		System.out.print(i + ", ");
	}
	System.out.println(x); //end of part 1
	
	System.out.println("Method Call within class:");
	System.out.println(whileLoop(x));
	
	System.out.println("Method call frome external class");
	Part3 finalLoop = new Part3();
	finalLoop.part3Loop(x);

	}
//new method for part 2
	public static String whileLoop(int x) {
		int a = 1;
		String b = "";
		while(a < x) {
			b += a + ", ";
			a++;
		}
		b += x;
		
		return b;
	}
}
