public class FixedStrideMultiBit {
	
	private static final int STRIDE = 10; //stride size
	private Node root;
	
	private Node BMP;	//Best Matching Prefix
	
	private int numberOfNodesVisited = 0; //Number of nodes accessed when a lookup operation is performed
	private int numberOfNodeCreated = 0;  //Total number of nodes created in the trie
	
	
	private static class Node {
		private String nextHop = null;
		private Node[] pointer = new Node[(int)Math.pow(2, STRIDE)];
		 
	}
	
	
	public void put(String destinationAddress, String nextHop) {
		
		if (destinationAddress.length() % STRIDE == 0)
			root = put(root, destinationAddress, nextHop, 0);
		else { 
			int expansion = STRIDE - (destinationAddress.length()%STRIDE);
		for (int i=0; i<(int)Math.pow(2,expansion); i++) 
			root = put(root, destinationAddress + paddZeros(intToStr(i),expansion), nextHop, 0);
			
		
		}
				
		
	}

	private Node put(Node x, String destinationAddress, String nextHop, int b) {
		
		if (x == null) {
			x = new Node();
			numberOfNodeCreated ++;
		}
		
		if(b == destinationAddress.length()) {
			//
			
				x.nextHop = nextHop;
			return x;
		}
		x.pointer[strToInt(destinationAddress.substring(b, b+STRIDE))] = put(x.pointer[strToInt(destinationAddress.substring(b, b+STRIDE))], 
				destinationAddress, nextHop, b+STRIDE) ;
		
		
		return x;
	}
	
	public String longestPrefixOf(String destinationAddress) {
		numberOfNodesVisited = 0;
		BMP = Search (root, destinationAddress, 0);
		if (BMP == null) {
			return null;
		}
		return  BMP.nextHop;
	}
	
private Node Search(Node x, String destinationAddress, int b) {
		
		if(x == null) 
			return BMP;
		
		if (x.nextHop != null) 
			BMP = x;
		
		if( (b + STRIDE) > destinationAddress.length() ) 
			return BMP;
		numberOfNodesVisited ++;
		return  Search(x.pointer[strToInt(destinationAddress.substring(b, b+STRIDE))], destinationAddress, b+STRIDE);	
			
	}


private int strToInt( String str ){
	  int i = 0;
	  int num = 0;
	 
	  //process each char of the string; 
	  while( i < str.length()) {
	    num *= 2;
	    num += str.charAt(i++) - '0'; //minus the ASCII code of '0' to get the value of the charAt(i++)
	  }

	  
	  return num;
	}

private String intToStr(int a) {

    int c;
    char m;
    StringBuilder ans = new StringBuilder();
    // convert the String to int
    while (a > 0) {
        c = a % 2;
        a = a / 2;
        m = (char) ('0' + c);
        ans.append(m);
    }
    return ans.reverse().toString();
}

private String paddZeros(String str, int expansion) {
	if(str.length()==expansion) 
		return str;
	
	else {
		String zeros = "";
		for (int i=0; i<expansion-str.length(); i++)
			zeros += '0';
		return zeros.concat(str);
	}
	
}

public int getNumberOfNodesVisited () {
	return numberOfNodesVisited;
}

public int getNumberOfNodeCreated () {
	return numberOfNodeCreated + 1;
}


}
