package sockets;

import java.net.*;
import java.io.*;

/** The server that reads strings from the input stream of the socket,
 *  reverses them and prints to the console */
public class ReverseEchoServer {
	public final static int PORT = 5534;
	
	public static void main(String[] args) throws IOException {
		ServerSocket welcomingSocket = null;
		Socket connectionSocket = null;
		try {
			welcomingSocket = new ServerSocket(ReverseEchoServer.PORT);
			System.out.println("Server started: waiting for connections on port " + ReverseEchoServer.PORT);
			connectionSocket = welcomingSocket.accept();
			System.out.println("EchoServer: EchoClient connected.");
			PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null && (!inputLine.equals("EXIT"))) { // stop when the client types EXIT
				String reversed = new StringBuffer(inputLine).reverse().toString();
				out.println(reversed);
				System.out.println("server: " + reversed);
			}
		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen on port " + ReverseEchoServer.PORT + " or listening for a connection");
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Bye!");
			if (welcomingSocket != null)
				welcomingSocket.close();
			if (connectionSocket != null)
				connectionSocket.close();
		}
	}
}
