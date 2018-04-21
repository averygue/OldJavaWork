import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args)  throws IOException{
		Socket client = new Socket("localhost", 1234); //127.0.0.1
		
		/*DataInputStream in = new DataInputStream(client.getInputStream());
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		
		Scanner scn = new Scanner(System.in);
		
		int x = scn.nextInt();
		out.writeInt(x);
		System.out.print("Server Response: " + in.readUTF());
		
		out.close();
		in.close();*/
		client.close();
	}

}
