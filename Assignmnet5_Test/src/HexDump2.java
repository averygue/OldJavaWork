import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HexDump2 {
	InputStreamReader inputStream;
	String fileStringArray;
	StringBuffer hex = new StringBuffer();

	public String fileToString(String a) {
		try {
			File fileName = new File(a);
			Scanner scanner = new Scanner(inputStream);
			while (scanner.hasNextLine()) {
				fileStringArray = scanner.nextLine();
			}

			char[] chars = fileStringArray.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				hex.append(Integer.toHexString((int) chars[i]));
			}
		} catch (Exception ee) {
			System.out.println("Error");
		}
		return hex.toString();
	}
}
