
public class UniBit {
	private Node root;
	
	private Node BMP;	//Best Matching Prefix
	
	private int numberOfNodesVisited = 0; //Number of nodes accessed when a lookup operation is performed
	private int numberOfNodeCreated = 0;  //Total number of nodes created in the trie
	
	private static class Node {
		private String nextHop = null;	//If a prefix node
		private Node left = null ;		//Left node location with with an address bit 0
		private Node right = null ;		//Right node location with with an address bit 1 
	}
	
	
	public void put(String prefix, String nextHop) {
		root = put(root, prefix, nextHop, 0);
	}

	private Node put(Node x, String prefix, String nextHop, int b) {
		if (x == null) {
			x = new Node();
			numberOfNodeCreated ++; //A new node is created and so increment the nodes counter
		}
		if(b == prefix.length()) {
			x.nextHop = nextHop;
			return x;
		}
		if (prefix.charAt(b) == '0') 
			x.left = put(x.left, prefix, nextHop, b+1);
		else 	
			x.right = put(x.right, prefix, nextHop, b+1);
		return x;
	}
	
	public String longestPrefixOf(String destinationAddress) {
		numberOfNodesVisited = 0;
		BMP = Search (root, destinationAddress, 0);
		if (BMP == null) 
			return null;
		return  BMP.nextHop;
	}
	
private Node Search(Node x, String destinationAddress, int b) {
		if(x == null) 
			return BMP;
		if (x.nextHop != null) 
			BMP = x;
		if(b == destinationAddress.length()) 
			return BMP;
		if (destinationAddress.charAt(b) == '0') {
			numberOfNodesVisited ++;
			return  Search(x.left, destinationAddress, b+1);
		}
		else {
			numberOfNodesVisited ++;
			return Search(x.right, destinationAddress, b+1);
		}	
	}

public int getNumberOfNodesVisited() {
	return numberOfNodesVisited;
}

public int getNumberOfNodesCreated() {
	return numberOfNodeCreated;
}

}
