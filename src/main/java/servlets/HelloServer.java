package servlets;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Creating a basic web server with Jetty like NodeJS on port 3000
 * It sends an html page as a response for each GET request
 */
public class HelloServer {

	public static final int PORT = 8081;

	public static void main(String[] args) throws Exception {
		// Method 1:  Creating an instance of server
		Server server = new Server(PORT);

		// Method 2: Creating server with custom hostName and port
		// (Optional) Setup the connector component explicitly
		Server server2 = new Server();
		ServerConnector connector = new ServerConnector(server2);
//		connector.setHost("localhost");
		connector.setHost("127.0.0.1");
		connector.setPort(4000);
		// Telling the server object that we will be using a connector
		server2.addConnector(connector);


		ServletHandler handler = new ServletHandler();

		// allocating route "/hello" with Model HelloServlet.class
		handler.addServletWithMapping(HelloServlet.class, "/hello");

		// adding handler to server
		server.setHandler(handler);
		server2.setHandler(handler);

		// starting the server (thread)
		server.start();
		server2.start();

		// waiting for the server thread to join main thread,
		// other Ops will happen after the server joins main thread
		server.join();
		server2.join();
	}
}