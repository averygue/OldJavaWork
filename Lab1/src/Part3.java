
public class Part3 {
	
	public void part3Loop(int x) {
		int b = 1; //repeat method from other class with different variables
		String c = "";
		while ( b < x) {
			c += b + ", ";
			b++;
		}
		c += x;
		System.out.println(c);

	}

}
