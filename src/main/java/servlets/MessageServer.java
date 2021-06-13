package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/** An example demonstrating how to create a simple message board using jetty/servlets.
 *  Run MessageServer, then go to localhost:8091/messageBoard
 */
public class MessageServer {

	public static final int PORT = 8091;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();

		// ServletHolder
		// Holds the name, params and some state of a javax.servlet.Servlet instance.
		// It implements the ServletConfig interface. This class will organise the
		// loading of the servlet when needed or requested.

		handler.addServletWithMapping(new ServletHolder(new MessageServlet()), "/messageBoard");
		server.setHandler(handler);
		server.start();
		server.join();
	}
}