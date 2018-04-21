
/*
 * Avery Guething
 * Lab 6: File I/O
 * February 21, 2017
 * Tyler Gillen 1020
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class topScore {
	private static final int SIZE = 5;

	String[] name = new String[SIZE];
	int[] score = new int[SIZE];

	File file;
	Scanner scn;
	PrintWriter pw;

	public topScore() {
		try {
			file = new File("score.txt");

			// if file exists write current scores and names to file
			Scanner scn = new Scanner(file);

			int i = 0;
			while (scn.hasNextLine()) {
				name[i] = scn.nextLine();
				score[i] = scn.nextInt();
				i++;
			}
		} catch (Exception ex) {
			System.out.println("File Not Found. Creating a blank file. . .");
			try {
				pw = new PrintWriter(file);
				pw.write("Ronaldo\n0\nDidier\n0\nPele\n0\nKaka\n0\nChristiano\n0");
				pw.flush();
				pw.close();

			} catch (Exception e) {
				System.out.println("Unable to write file to the disk");
			}

		}
	}

	public String[] getTopNames() { // return names of top 5
		return name;
	}

	public int[] getTopScores() { // returns scores of top 5
		return score;
	}

	public void playScore(String name, int score) {

		int min = Integer.MAX_VALUE;
		int min_index = 0;

		for (int i = 0; i < this.score.length; i++) {
			if (min < this.score[i]) {
				min = this.score[i];
				min_index = i;
			}
		}
		/*
		 * if we have a new score which is greater than the lowest score of the
		 * current top five scores, then we have to replace the lowest score
		 * with the current. Then we have to rewrite the current top five scores
		 * to the file to synchronize content of the the array and file
		 */
		if (score > min) {
			this.name[min_index] = name;
			this.score[min_index] = score;

			int a = 0;
			while (a < this.name.length) {
				pw.write(this.name[a] + "\n");
				pw.write(this.name[a] + "\n");
				a++;
			}
			pw.flush();
			pw.close();
		}

	}

	public static void main(String[] args) {
		
		topScore ts = new topScore();
		System.out.println(ts.getTopNames());
		System.out.println(ts.getTopScores());
		ts.playScore("Messi", 99999);
	}
}