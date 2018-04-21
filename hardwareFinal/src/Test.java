
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	//Change this to the path of the IP database file
	private static final String IP_DATABASE_FILE = "IP Database 40000.txt";
	
	
	private static final String [] filesNames = {"Unibit_BMP.txt", "Unibit_Memory_Accesses.txt", 
		"Patricia_BMP.txt", "Patricia_Memory_Accesses.txt", "FixedStride_BMP.txt", "FixedStride_Memory_Accesses.txt"};
	private String path;

	
	public Test(String file_path){
		path = file_path;
	}
	
	public static void main(String [] args)throws IOException{
			Test file = new Test(IP_DATABASE_FILE);
			String[ ] arrayLines = file.OpenFile( );
			
			ArrayList<String> prefixes = new ArrayList<String>();
			ArrayList<String> nexthop = new ArrayList<String>();
			ArrayList<String> IPs = new ArrayList<String>();
			ArrayList<ForwardingTableEntry> table = new ArrayList<ForwardingTableEntry> ();
			int i;
			for ( i=0; i < arrayLines.length; i++ ) {
				    String[] temp = arrayLines[i].split("\t");
					prefixes.add(temp[4]);			
					nexthop.add(temp[5]);
					IPs.add(temp[1]);
					table.add(new ForwardingTableEntry(temp[4], temp[5]));
			}
			
			 
			PrintWriter test = new PrintWriter("ForwardinTableAscending.txt", "UTF-8");
			for (int z=0; z<table.size(); z++ )
				test.println(table.get(z).print());
			test.close();
			
			UniBit rami = new UniBit();
			//Insert prefixes into the unibit trie first
			for(i = 0; i < prefixes.size(); i++)  
				rami.put(prefixes.get(i), nexthop.get(i));
			//Here You can do the 
			PrintWriter writerBMP = new PrintWriter(filesNames[0], "UTF-8");
			PrintWriter writerMemoryAccesses = new PrintWriter(filesNames[1], "UTF-8");
			 
		    for(int j=0; j<IPs.size(); j++) {
		    	writerBMP.println(rami.longestPrefixOf(IPs.get(j)));
		    	writerMemoryAccesses.println(rami.getNumberOfNodesVisited());
			}
		    writerBMP.close();
		    writerMemoryAccesses.close();
		    System.out.println("Number of created nodes in unibit is " + rami.getNumberOfNodesCreated());
		    
		    /*
		    int sizeOfPrefixes = 0;
		    for (int k=0; k<prefixes.size(); k++) {
		    	final byte[] utf8Bytes = prefixes.get(k).getBytes("UTF-8");
		    	sizeOfPrefixes += utf8Bytes.length; // accumulate the size
		    }
		   
		    System.out.println(sizeOfPrefixes);
		    */	
		    	
		    Patricia rami1 = new Patricia();
			//Insert prefixes into the patricia trie second
			for(i = 0; i < prefixes.size(); i++)  
				rami1.put(prefixes.get(i), nexthop.get(i));
			//Here You can do the 
			 writerBMP = new PrintWriter(filesNames[2], "UTF-8");
			 writerMemoryAccesses = new PrintWriter(filesNames[3], "UTF-8");
			 
		    for(int j=0; j<IPs.size(); j++) {
		    	writerBMP.println(rami1.longestPrefixOf(IPs.get(j)));
		    	writerMemoryAccesses.println(rami1.getNumberOfNodesVisited());
			}
		    System.out.println("Number of created nodes in patricia is " + rami1.getNumberOfNodeCreated());
		    writerBMP.close();
		    writerMemoryAccesses.close();
		    
		    FixedStrideMultiBit rami2 = new FixedStrideMultiBit();
		    Collections.sort(table); //Sort the forwarding table before inserting the prefixes
		    
			//Insert prefixes into the fixed-stride multibit trie first
			for(i = 0; i < table.size(); i++)  
				rami2.put(table.get(i).getPrefix(), table.get(i).getNextHop());
			
			writerBMP = new PrintWriter(filesNames[4], "UTF-8");
			writerMemoryAccesses = new PrintWriter(filesNames[5], "UTF-8");
			 
		    for(int j=0; j<IPs.size(); j++) {
		    	writerBMP.println(rami2.longestPrefixOf(IPs.get(j)));
		    	writerMemoryAccesses.println(rami2.getNumberOfNodesVisited());
			}
		    writerBMP.close();
		    writerMemoryAccesses.close();
		    System.out.println("Number of created nodes in fixed stride is " + rami2.getNumberOfNodeCreated());
		    
		}
			   
//Sandeep part
	public String[] OpenFile() throws IOException{
		
		FileReader fr = new FileReader(path);
		BufferedReader reader = new BufferedReader(fr);
		
		int numberOfLines = readLines();
		String[ ] textData = new String[numberOfLines];
		
		int i;

		for (i=0; i < numberOfLines; i++) {
		textData[ i ] = reader.readLine();

		}
		reader.close( );
		return textData;
	}
	int readLines() throws IOException {
		FileReader fR = new FileReader(path);
		BufferedReader bf = new BufferedReader(fR);
		
		String aLine;
		int numberofLines = 0;
		
		while((aLine = bf.readLine()) != null){
			numberofLines++;
		}
		
		bf.close();
		return numberofLines;
	}



}