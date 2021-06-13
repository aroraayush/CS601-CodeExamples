package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * A web-server that displays HTML form that allows a user to enter a message and submit it.
 * The server prints the message back to the user.
 * GET and POST handled by same Endpoint - /echo
 */
public class EchoServer {

	public static final int PORT = 8082;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		
		ServletHandler handler = new ServletHandler();

		// attaching Model EchoServlet.class to route "/echo"
		handler.addServletWithMapping(EchoServlet.class, "/echo");
		server.setHandler(handler);
		server.start();
		server.join();
	}
}