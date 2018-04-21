



public class RunningExample {

	public static void main(String[] args) {
		/*
		UniBit rami = new UniBit();
		rami.put("", "P1");
		rami.put("1", "P2");
		rami.put("00", "P3");
		rami.put("101", "P4");
		rami.put("111", "P5");
		rami.put("1000", "P6");
		rami.put("11101", "P7");
		rami.put("111001", "P8");
		rami.put("1000011", "P9");
		
		System.out.println("Total number of nodes created is " + rami.getNumberOfNodesCreated());
		
		String destinationAddress = "1110100";
		System.out.println("Longest prefix match for the destination address " + destinationAddress + " is " + rami.longestPrefixOf(destinationAddress));
		System.out.println("Number of nodes visited is " + rami.getNumberOfNodesVisited());
		*/
		FixedStrideMultiBit rami = new FixedStrideMultiBit();
		rami.put("", "P1");
		rami.put("1", "P2");
		rami.put("00", "P3");
		rami.put("101", "P4");
		rami.put("111", "P5");
		rami.put("1000", "P6");
		rami.put("11101", "P7");
		rami.put("111001", "P8");
		rami.put("1000011", "P9");
		
		System.out.println("Total number of non null entries created is " + rami.getNumberOfNodeCreated());
		
		String destinationAddress = "1110100";
		System.out.println("Longest prefix match for the destination address " + destinationAddress + " is " + rami.longestPrefixOf(destinationAddress));
		System.out.println("Number of nodes visited is " + rami.getNumberOfNodesVisited());
		
		/*
		Patricia rami = new Patricia();
		rami.put("00001", "P1");
		rami.put("10011", "P2");
		rami.put("00101", "P3");
		rami.put("10010", "P4");
		rami.put("00011", "P5");
		rami.put("01000", "P6");
		rami.put("01000", "P7");
		rami.put("01110", "P8");
		
		System.out.println("Total number of nodes created is " + rami.getNumberOfNodeCreated());
		
		String destinationAddress = "10011110";
		System.out.println("Longest prefix match for the destination address " + destinationAddress + " is " + rami.longestPrefixOf(destinationAddress));
		System.out.println("Number of nodes visited is " + rami.getNumberOfNodesVisited());
		*/
		
		/*
		Patricia rami2 = new Patricia();
		
		rami2.put("101", "P1");
		rami2.put("111", "P2");
		rami2.put("11001", "P3");
		rami2.put("1", "P4");
		rami2.put("0", "P5");
		rami2.put("1000", "P6");
		rami2.put("100000", "P7");
		rami2.put("100", "P8");
		rami2.put("110", "P9");
		System.out.println("Patricia stuff");
		System.out.println("------------------");
		System.out.println("Patricia Trie: BMP is  " + rami2.longestPrefixOf("10000"));
		System.out.println("------------------");
		
		
		FixedStrideMultiBit rami3 = new FixedStrideMultiBit();
		
		rami3.put("101", "P1");
		rami3.put("111", "P2");
		rami3.put("11001", "P3");
		rami3.put("1", "P4");
		rami3.put("0", "P5");
		rami3.put("1000", "P6");
		rami3.put("100000", "P7");
		rami3.put("100", "P8");
		rami3.put("110", "P9");

		System.out.println("Fixed Stride Multibit Trie: BMP is  " + rami3.longestPrefixOf("10000"));
		*/
		
	}

}
