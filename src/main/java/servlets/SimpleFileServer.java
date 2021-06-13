package servlets;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

/**
 * A simple example of using Jetty and servlets to serve files.
 */
public class SimpleFileServer {

	public static final int PORT = 8081;

	public static void main(String[] args) throws Exception {

		Server server = new Server(PORT);

		// Jetty ResourceHandler
		// This handle will serve static content (files). No caching is done.
		// Requests for resources that do not exist are let pass (Eg no 404's).
		ResourceHandler resourceHandler = new ResourceHandler();

		// Add static resource holders to web server
		// This indicates where web files are accessible on the file system
		resourceHandler.setDirectoriesListed(true);

		// a directory from where we want to serve files
		// The directory needs to exist in the project
		resourceHandler.setResourceBase("src/main/java/abstractClasses");

		server.setHandler(resourceHandler);

		// optional - if you want to map /files url path to the same resource handler
		ContextHandler ctx = new ContextHandler("/files"); // url
		ctx.setHandler(resourceHandler);
		
		// Setup handlers (and handler order)
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { resourceHandler, ctx});
		server.setHandler(handlers);

		server.start();
		server.join();

		
	}
}