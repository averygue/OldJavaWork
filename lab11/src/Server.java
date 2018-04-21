import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	
	private static ServerSocket server = null;
	private static Socket child = null;
	
/*	public void run() {
		try {
		DataInputStream in = new DataInputStream(child.getInputStream());
		DataOutputStream out = new DataOutputStream(child.getOutputStream());
			while(true) {
				int x = in.readInt();
				out.writeUTF((x++) + "");
				break;
			}
			out.close();
			in.close();
			child.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}t
		
	}*/

	public static void main(String[] args) throws IOException {
		
		//initialize server and port
		server = new ServerSocket(1234);
		
		//while(true) {
		//serevr is going to wait here forever until client sends request to connect
		System.out.println("Waiting for client. . .");
			child = server.accept();
			System.out.println("Connected with Client. . .");
			(new Server()).start();
		//}
	}
}
