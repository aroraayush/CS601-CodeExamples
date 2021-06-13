package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * A simple web server that sends the same response for each GET request (an
 * html page that says Hello, friends!)
 *
 */
public class SimpleHelloServer {

	public static final int PORT = 8081;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();

		// Model SimpleHelloServlet.class added to route /welcome
		handler.addServletWithMapping(SimpleHelloServlet.class, "/welcome");

		// Model SimpleByeServlet.class added to route /bye
//		handler.addServletWithMapping(SimpleByeServlet.class, "/bye");

		server.setHandler(handler);

		server.start();
		server.join();
	}
}