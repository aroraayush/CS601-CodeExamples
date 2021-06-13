package codeCamp2;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.HelloServlet;

import java.nio.file.Paths;

// Problem 3 - you can assume this class is given
public class WelcomeServer {

	public static final int PORT = 8080;

	public static void main(String[] args)  {
		Server server = new Server(PORT);
		ServletContextHandler context  = new ServletContextHandler(ServletContextHandler.SESSIONS);
		String dir = Paths.get(".", "static/js").toString();
		context.setResourceBase(dir);

		context.addServlet(WelcomeServlet.class, "/welcome");
		/*ServletHolder holder = new ServletHolder("default", MyDefaultServlet.class);
		holder.setInitParameter("dirAllowed","false");
		context.addServlet(holder, "/"); */
		server.setHandler(context);

		try {
			server.start();
			server.join();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}