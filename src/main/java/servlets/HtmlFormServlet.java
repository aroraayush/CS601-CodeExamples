package servlets;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** An example that demonstrates how to process HTML forms with servlets.*/
@SuppressWarnings("serial")
public class HtmlFormServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println();

		PrintWriter out = response.getWriter();

		// printf - It consists of literals and format specifiers.
		// Format specifiers include flags, width, precision, and conversion characters
		out.printf("<html>%n%n");
		out.printf("<head><title>%s</title></head>%n", "My Form");

		out.printf("<body>%n");

		// creating and embedding HTML Form in body
		printForm(request, response);

		out.printf("%n</body>%n");
		out.printf("</html>%n");

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nameParam = request.getParameter("name");
		nameParam = nameParam == null ? "anonymous" : StringEscapeUtils.escapeHtml4(nameParam);

//		response.setStatus(HttpServletResponse.SC_OK);

		// Redirect to another url, send name in the get request
		// Going to this url will invoke a welcome servlet
		response.sendRedirect("/welcome?name=" + nameParam);
	}

	private static void 	printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();

		// request.getServletPath()) - Getting current servlet endpoint
		out.printf("<form method=\"post\" action=\"%s\">%n", request.getServletPath());

		out.printf("Enter name:<br><input type=\"text\" name=\"name\"><br>");
		out.printf("<p><input type=\"submit\" value=\"Enter\"></p>\n%n");
		out.printf("</form>\n%n");
	}

}