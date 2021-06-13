package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;

@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {

	/**
	 * A method that gets executed when the get request is sent to the
	 * HelloServlet
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting query params
		String name = request.getParameter("name");

		if (name == null || name.trim().isEmpty())
			name = "anonymous";

		System.out.println(name);

		// "clean up" - convert name value to pure string
		// If we did not call escapeHtml4,our site would be prone to
		// cross-site scripting attacks (XSS attacks)
		// <script> tag could be passed
		// ?name=<script>window.open("http://www.usfca.edu/");</script>
		name = StringEscapeUtils.escapeHtml4(name);

		// Uncomment the line below to disable security feature in the browser
		// response.setIntHeader("X-XSS-Protection", 0);

		// Creating the custom HTML page response
		response.setContentType("text/html");

		// Creating the response to be sent to client
		// response object already has outputstream writer internally
		PrintWriter out = response.getWriter();

		// writing to the response
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello, " + name + "!</h1>");
		out.println("</body>");
		out.println("</html>");

		// SC - Status Code [SC_OK - 200]
		response.setStatus(HttpServletResponse.SC_OK);
	}
}