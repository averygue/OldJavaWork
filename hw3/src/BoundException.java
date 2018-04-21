
public class BoundException extends Exception{
	public BoundException()
	{
		super();
		return;
	}


	public BoundException(String s)
	{
		super(s);
		return;
	}
	public BoundException(int a)
	{
		super( "Incorrect key pressed!");
		return;
	}

	public BoundException(int a, int b)
	{
		super("Invalid number. Number must be between" + a + "&" + b);
		return;
	}


}
