package sockets;
import java.io.*;
import java.net.*;

/**
 * SimpleClient: Reads input from the keyboard and sends it to the server via
 * the socket.
 */
public class SimpleClient extends Thread {

	@Override
	public void run() {
		try {
/*

			// Sends a connection request to the server, running on a specific host & port
			//Socket socket = new Socket("g1212.cs.usfca.edu", SimpleServer.PORT); // use on campus

//			Socket socket = new Socket("localhost", SimpleServer.PORT); // running on the local machine

			// For reading user keyboard input from the console
			// (has nothing to do with sockets!)
//			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			// Practice
//			BufferedReader reader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			// For writing to the socket (so that the server could get client messages)
//			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
*/
			Socket socket = new Socket("localhost", SimpleServer.PORT);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

			String input;
			System.out.println("Client: Started..."); // Entered input will be stored here

			while (!socket.isClosed()) {
				input = in.readLine(); // read what the user typed in the console
				out.println(input); // send the message to the server via the socket

				if (input.equals(SimpleServer.EOT)) {
					System.out.println("Client: Ending client.");
					out.println("Client: Disconnected with me");
					socket.close();
				} else if (input.equals(SimpleServer.EXIT)) {
					System.out.println("Client: Shutting down server.");
					socket.close();
				}
			}
			in.close();
			out.close();
		}
		 catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SimpleClient client = new SimpleClient();
		client.start();
		try {
			client.join();
		} catch (InterruptedException e) {
			System.out.println("The thread got interrupted " + e);
		}
	}
}