package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/** Demonstrates how to process HTML forms with 2 endpoints using 2 servlets.
*/
public class HtmlFormServer {

	public static final int PORT = 8083;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(HtmlFormServlet.class, "/form");
		handler.addServletWithMapping(WelcomeServlet.class, "/welcome");

		server.setHandler(handler);
		server.start();
		server.join();
	}
}