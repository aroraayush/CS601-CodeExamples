package jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Demonstrates simple user registration, login, and session tracking. This
 * is a simplified example, and **NOT** secure.
 * This comprehensive example is provided by Prof. Engle.
 */
public class LoginServer {
	protected static Logger log = LogManager.getLogger();
	private static int PORT = 8080;

	public static void main(String[] args) {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();

		handler.addServletWithMapping(UserServlet.class,     "/login");
		handler.addServletWithMapping(RegisterServlet.class, "/register");
		handler.addServletWithMapping(WelcomeServlet.class,  "/welcome");
		handler.addServletWithMapping(RedirectServlet.class, "/*");

		server.setHandler(handler);

		log.info("Starting server on port " + PORT + "...");

		try {
			server.start();
			server.join();

			log.info("Exiting...");
		}
		catch (Exception ex) {
			log.fatal("Interrupted while running server.", ex);
			System.exit(-1);
		}
	}
}