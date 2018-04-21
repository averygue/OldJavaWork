
/*
 * Michael Fuss and Avery Guething
 * Assignemtn 4: HexDump
 * October 2017
 * CSC 2200
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HexDump {
	private static String line = new String();
	public static ArrayList<String> brokenStrings = new ArrayList<String>();

	public static void main(String[] args) {
		load();
		convertStringToHex(line);

	}

	public static void convertStringToHex(String str) {
		// breaks up Strings
		brokenStringArrays(line);
		int count1 = 24;
		int count2 = 49;
		char[] chars = str.toCharArray();
		StringBuilder hex = new StringBuilder();

		for (char c : chars) {
			int i = (int) c;
			// special case if it is a special character
			if (i < 32) {
				hex.append("2E");
			} else {
				hex.append(Integer.toHexString(i).toUpperCase() + " ");
				if (hex.length() == count1) {
					hex.append(" ");
					count1 += 50;

				} else if (hex.length() == count2) {
					hex.append("\n");
					count2 += 50;
				}
			}

		}
		// splits each 16 into String Array
		String hexString2 = hex.toString();
		String[] strings = hexString2.split("\n");
		int stringLength = 0;

		// adds Bytes
		for (int a = 0; a < strings.length; a++) {
			strings[a] = String.format("%08X", (stringLength)) + "  " + strings[a];
			stringLength += brokenStrings.get(a).length();
		}
		// adds 16 characters
		for (int b = 0; b < brokenStrings.size(); b++) {
			strings[b] += ("|" + brokenStrings.get(b) + "|");
		}
		// final statement
		for (int finalCount = 0; finalCount < strings.length; finalCount++) {
			System.out.println(strings[finalCount]);

		}
		// adds final length
		System.out.println(String.format("%08X", (stringLength)));
	}

	private static ArrayList<String> brokenStringArrays(String s) {
		int count1 = 0;
		int count2 = 16;
		for (count1 = 0, count2 = 16; count2 < s.length(); count1 += 16, count2 += 16) {
			String temp = s.substring(count1, count2);
			brokenStrings.add(temp);
		}

		// if the length isn't divisble by 16
		if (count2 != s.length() + 15) {
			String temp = s.substring(count1);
			brokenStrings.add(temp);
		}
		// TODO: NEED TO FIGURE OUT CODE FOR THE LAST LINE SINCE IT ISN'T
		// DIVISBLE BY 2

		return brokenStrings;

	}

	public static void load() {
		try {
			FileReader reader = new FileReader("test.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			Scanner sc = new Scanner(reader);
			String nline;
			while ((nline = bufferedReader.readLine()) != null) {
				line += nline;
				if (sc.hasNextLine())
					;
				line += ".";
			}
			reader.close();
			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
