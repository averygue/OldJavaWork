



public class TestBookExample {

	public static void main(String[] args) {
		
		UniBit rami = new UniBit();
		
		rami.put("101", "P1");
		rami.put("111", "P2");
		rami.put("11001", "P3");
		rami.put("1", "P4");
		rami.put("0", "P5");
		rami.put("1000", "P6");
		rami.put("100000", "P7");
		rami.put("100", "P8");
		rami.put("110", "P9");

		System.out.println("UniBit Trie: BMP is  " + rami.longestPrefixOf("10000"));
		System.out.println("Number of nodes visited is " + rami.GetNumberOfNodesVisited());
		System.out.println("Number of nodes created is " + rami.GetNumberOfNodesCreated());
		
		

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
		
		
	}

}
