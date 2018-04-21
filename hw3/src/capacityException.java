
public class capacityException extends Exception {
	public capacityException()
	{
		super();
		return;
	}
	public capacityException(String s)
	{
		super(s);
		return;
	}

	public capacityException(int a)
	{
		super( "Note Capacity Reached");
		return;
	}
}
