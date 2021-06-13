package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;

public class EchoServlet extends HttpServlet {

	/**
	 * The method that displays an HTML form, created by us manually
	 * The form will be processed by a doPost method of the servlet
	 * mapped to /echo
	 * @param request http request object
	 * @param response http response object
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><title>EchoServlet</title><body>");

		// Escaping double quotes with \"
		out.println("<form action=\"echo\" method=\"post\">");
		out.println("Message: <br/>");
		
		// notice that the message will be stored in the parameter "userMsg"
		out.println("<input type=\"text\" name=\"userMsg\"><br/>");
		out.println("<input type=\"submit\" value=\"Submit\"></form>");
		out.println("</body></html>");

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
	}

	/** The method that will process the form once it's submitted */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Getting query params and cleaning up
		String msg = StringEscapeUtils.escapeHtml4(request.getParameter("userMsg"));

		PrintWriter out = response.getWriter();

		out.println("<html><title>EchoServlet</title><body>You said: " + msg + "</body></html>");

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
	}

}