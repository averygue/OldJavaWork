/*
 * Avery Guething
 * Lab 9: Sorting
 * March 21, 2017
 */
public class Sorting {
	
	//uses insertionSort method to sort out arary using pseudocode given
	public static void insertionSort (int[]a) {
		for(int i = 1; i <= a.length-1;i++) {
			int j = i;
			while( (j > 0) && (a[j] < a[j-1])) {
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				j = j-1;
			}
		}
	}
	
	//uses bubbleSort method to sort out array using pseudocode given
	public static void bubbleSort (int[] a) {
		for (int i = 0; i  < a.length-1; i++) {
			for (int j = 0; j < a.length-1; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	//tests two sorting methods with two arrays and prints out new sorted array
	public static void main(String[] args){ 
		 int[] a = {5,10,0,15,1,2};
		 int[] b = {5,10,0,15,1,2};
		
		insertionSort(a);
		for(int i = 0; i < a.length;i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		bubbleSort(b);
		for(int i = 0; i < b.length;i++) {
			System.out.print(b[i] + " ");
		}
	}
	
}
