

public class ForwardingTableEntry implements Comparable<ForwardingTableEntry>  {
	private String prefix;
	private String nextHop;
	
	ForwardingTableEntry(String prefix, String nextHop) {
		this.prefix = prefix;
		this.nextHop = nextHop;
	}
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getNextHop() {
		return nextHop;
	}
	public void setNextHop(String nextHop) {
		this.nextHop = nextHop;
	}
	
	public String print() {
		return prefix + " " + nextHop;
	}

	@Override
	public int compareTo(ForwardingTableEntry o) {
		
		
		return(prefix.length() - o.prefix.length());
		
	}

	
	

}
