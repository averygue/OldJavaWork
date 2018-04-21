/**
 * This  implementation of the Patricia trie is based on the one described in  
 * the Algorithms book by Robert Sedgewick's  (3rd Edition, chapter 9, pages 650-657).
 * More features were added such as the Longest Prefix Match method
 */

public class Patricia {

    private final Node head = new Node(-1);
    private Node BMP;
    private int numberOfNodesVisited = 0; //Number of nodes accessed when a lookup operation is performed
	private int numberOfNodeCreated = 0;  //Total number of nodes created in the trie
    private int longestLength = -1;
   
    
    private static class Node {
        
        private int bit = -1; //skipped bits
        private String prefix = null; //prefix key is stored here
        private String nextHop = null;  
        
        private Node left = null; //Left node location with with an address bit 0
		private Node right = null ;		//Right node location with with an address bit 1 
        
        private Node(int bit) {
            this(null, null, bit);
        }
        
        private Node(String prefix, String nextHop, int bit) {
            this.bit = bit;
            this.prefix = prefix;
            this.nextHop = nextHop;
        }
    }
    
    // INIT
    {
        head.left = head;
    }
      
    public String longestPrefixOf(String destinationAddress) {
    	
    	numberOfNodesVisited = 0;
		longestLength = -1;
		BMP = findBMP(head.left, destinationAddress, -1);

		if (BMP == null ) {
			return null;
		}
		
				
		return  BMP.nextHop;
	}
    
    private Node findBMP(Node h, String destinationAddress, int b) {
    	
    	
        if (h.bit <= b) 	
        	return BMP;
        
        if (h.prefix.length() >= longestLength && destinationAddress.startsWith(h.prefix)) {
        	BMP = h;
        	longestLength = h.prefix.length();
        }
        	
        if (!isSet(destinationAddress, h.bit)) {
        	numberOfNodesVisited ++;
        	return findBMP(h.left, destinationAddress, h.bit);
        }
         else { 
        	 numberOfNodesVisited ++;
        	 return findBMP(h.right, destinationAddress, h.bit);
         }
    }
    
    
    private Node searchR(Node h, String key, int i) {
        if (h.bit <= i) { 
            return h; 
        }
        
        if (!isSet(key, h.bit)) {
            return searchR(h.left, key, h.bit);
        } else {
            return searchR(h.right, key, h.bit);
        }
    }
    
    public void put(String prefix, String nextHop) {
        Node node = searchR(head.left, prefix, -1);
        
        String existing = null;
        if (node != null) {
            existing = node.prefix;
            if (equals(prefix, existing)) {
                node.nextHop = nextHop;
                return;
            }
        }
        
        int bit = 0;
        while (isSet(prefix, bit) == isSet(existing, bit)) {
            ++bit;
        }
        
        head.left = insertR(head.left, prefix, nextHop, bit, head);
    }
    
    private Node insertR(Node h, String key, String nextHop, int i, Node p) {
        if ((h.bit >= i) || (h.bit <= p.bit)) {
            Node t = new Node(key, nextHop, i);
            numberOfNodeCreated ++;
            
            boolean isSet = isSet(key, t.bit);
            t.left = isSet ? h : t;
            t.right = isSet ? t : h;
            return t;
        }
        
        if (!isSet(key, h.bit)) {
            h.left = insertR(h.left, key, nextHop, i, h);
        } else {
            h.right = insertR(h.right, key, nextHop, i, h);
        }
        return h;
    }
    
    
    /**
     * The most significant bit of a {@code char}.
     */
    private static final int MSB = 1 << Character.SIZE-1;
    
    /**
     * Returns {@code true} if the key's bit at the given bit index is set.
     */
    private static boolean isSet(String key, int bitIndex) {
        if (key == null) {
            return false;
        }
        
        int index = (int)(bitIndex / Character.SIZE);        
        int bit = (int)(bitIndex % Character.SIZE);

        if (index >= key.length()) {
            return false;
        }
        
        int mask = (MSB >>> bit);
        return (key.charAt(index) & mask) != 0;
    }
    
    /**
     * Returns {@code true} if the two objects are equal.
     */
    private static boolean equals(Object o1, Object o2) {
        if (o1 == null) {
            return (o2 == null);
        }
        
        return o1.equals(o2);
    }
      
    public int getNumberOfNodesVisited() {
    	return numberOfNodesVisited;
    }
    
    public int getNumberOfNodeCreated() {
    	return numberOfNodeCreated + 1;
    }
    
    
}
