/*
 * Avery Guething
 * Tyler Gillen 1020
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Problem2 {

	//following method finds max number and max index in array list
	public static int findMax(ArrayList<Float> intList) { 
		float maxNumber = intList.get(0);
		int maxIndex = 0;
		for (int i = 1; i < intList.size(); i++) {
			if (intList.get(i) > maxNumber) {
				maxNumber = intList.get(i);
				maxIndex = i;
			}
		}
		return maxIndex;

	}

	//following method finds min number and min index in arrayList
	public static int findMin(ArrayList<Float> intList) {
		float minNumber = intList.get(0);
		int minIndex = 0;
		for (int i = 1; i < intList.size(); i++) {
			if (intList.get(i) < minNumber) {
				minNumber = intList.get(i);
				minIndex = i;
			}
		}
		return minIndex;

	}

	//main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Float> floatList = new ArrayList<Float>(); //creates new array list
		float x = 0;
		while (x < 1.2 || x > 3.8) { //makes sure that the degree of difficulty fits requirements and stores in x-value
			System.out.println("Enter the degree of difficulty for the dive (1.2-3.8): ");
			x = sc.nextFloat();
		}
		for (int i = 1; i <= 7; i++) {
			float a = -1;
			while (a < 0 || a > 10) {
			System.out.println("Enter Score for Judge " + i + " (0-10): "); //asks for score for each judge
			a = sc.nextFloat();
			}
			floatList.add(a);
		}
		int max = findMax(floatList); //finds and removes max and min numbers in arrayList
		floatList.remove(max);
		int min = findMin(floatList);
		floatList.remove(min);

		float sum = 0; //adds all the remaining numbers together
		for (int a = 0; a < floatList.size(); a++) {
			sum += floatList.get(a);
		}
		float score = sum * x * (float) 0.6; //multiplies by difficulty and and 0.6
		System.out.println("The Diver's final score is " + score);
	}
}
