
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class CopyOfTest {
	//Change this to the path of the IP database file
	private static final String IP_DATABASE_FILE = "IP Database 40000.txt";
	
	
	private static final String [] filesNames = {"Unibit_BMP.txt", "Unibit_Memory_Accesses.txt", 
		"Patricia_BMP.txt", "Patricia_Memory_Accesses.txt", "FixedStride_BMP.txt", "FixedStride_Memory_Accesses.txt"};
	private String path;

	
	public CopyOfTest(String file_path){
		path = file_path;
	}
	
	public static void main(String [] args)throws IOException{
			CopyOfTest file = new CopyOfTest(IP_DATABASE_FILE);
			String[ ] arrayLines = file.OpenFile( );
			
			ArrayList<String> prefixes = new ArrayList<String>();
			ArrayList<String> nexthop = new ArrayList<String>();
			ArrayList<String> IPs = new ArrayList<String>();
			ArrayList<ForwardingTableEntry> table = new ArrayList<ForwardingTableEntry> ();
			int i;
			for ( i=0; i < arrayLines.length; i++ ) {
				    String[] temp = arrayLines[i].split("\t");
				//	prefixes.add(temp[4]);			
				//	nexthop.add(temp[5]);
					IPs.add(temp[1]);
					table.add(new ForwardingTableEntry(temp[4], temp[5]));
			}
			
			 
			PrintWriter test = new PrintWriter("ForwardinTableAscending.txt", "UTF-8");
			for (int z=0; z<table.size(); z++ )
				test.println(table.get(z).print());
			test.close();
			
			
			PrintWriter writerBMP ;
			PrintWriter writerMemoryAccesses;
			 
		    
		    
		    
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